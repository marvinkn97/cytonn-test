package dev.marvin.ticketbooking.event;

import dev.marvin.ticketbooking.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EventService {
    private final EventDao eventDao;

    public List<Event> getAllEvents() {
        return eventDao.findAllEvents();
    }

    public Event geEventById(Long eventId) {
        return eventDao.findEventById(eventId);
    }

    public Event getEventByName(String eventName) {
        return eventDao.findEventByName(eventName);
    }

    public Event createEvent(EventDto eventDto) {

        MultipartFile imageFile = eventDto.imageFile();

        if (imageFile.isEmpty()) {
            try {
                throw new FileUploadException("failed to upload file");
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
        }
        String fileName = generateUniqueFileName(imageFile.getOriginalFilename());
        Event newEvent = Event.builder().name(eventDto.name()).startDate(eventDto.startDate()).endDate(eventDto.endDate()).location(eventDto.location()).capacity(eventDto.capacity()).image(fileName).host(eventDto.host()).description(eventDto.description()).build();
        try {
            saveImageToFile(imageFile, fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return eventDao.save(newEvent);

    }

    public Event updateEvent(Long eventId, EventDto eventUpdateRequest) {
        Event event = eventDao.findEventById(eventId);

        if (event == null) {
            throw new ResourceNotFoundException("event with id [%s] not found".formatted(eventId));
        }

        event.setName(eventUpdateRequest.name());
        event.setStartDate(eventUpdateRequest.startDate());
        event.setEndDate(eventUpdateRequest.endDate());
        event.setLocation(eventUpdateRequest.location());
        event.setCapacity(eventUpdateRequest.capacity());
        event.setHost(eventUpdateRequest.host());
        event.setDescription(eventUpdateRequest.description());

        MultipartFile imageFile = eventUpdateRequest.imageFile();

        if (imageFile.isEmpty()){
            try {
                throw new FileUploadException("file upload failed");
            } catch (FileUploadException e) {
                throw new RuntimeException(e);
            }
        }

        if (!imageFile.isEmpty()) {
            try {
                deleteImageFile(event.getImage());
                String fileName = generateUniqueFileName(imageFile.getOriginalFilename());
                event.setImage(fileName);
                saveImageToFile(imageFile, fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return eventDao.save(event);

    }

    public void deleteEventById(Long eventId) {
        Event event = eventDao.findEventById(eventId);

        if (event != null) {
            try {
                deleteImageFile(event.getImage());
                eventDao.deleteEventById(eventId);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

    private String generateUniqueFileName(String originalFileName) {
        return UUID.randomUUID() + "_" + originalFileName;
    }

    private void saveImageToFile(MultipartFile imageFile, String fileName) throws IOException {
        Path imagePath = Path.of("src/main/resources/static/img");
        Files.copy(imageFile.getInputStream(), imagePath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
    }

    private void deleteImageFile(String fileName) throws IOException {
        Path imagePath = Path.of("src/main/resources/static/img");
        Files.deleteIfExists(imagePath.resolve(fileName));
    }
}
