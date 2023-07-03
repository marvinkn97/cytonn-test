package dev.marvin.ticketbooking.event;

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

    public Event geEventById(UUID eventId) {
        return eventDao.findEventById(eventId);
    }

    public Event getEventByName(String eventName) {
        return eventDao.findEventByName(eventName);
    }

    public Event createEvent(EventDto eventDto, MultipartFile imageFile) {
        if (imageFile != null && !imageFile.isEmpty()) {
            String fileName = generateUniqueFileName(imageFile.getOriginalFilename());
            Event newEvent = Event.builder()
                    .name(eventDto.name())
                    .startDate(eventDto.startDate())
                    .endDate(eventDto.endDate())
                    .location(eventDto.location())
                    .capacity(eventDto.capacity())
                    .image(fileName)
                    .host(eventDto.host())
                    .description(eventDto.description())
                    .build();
            try {
                saveImageToFile(imageFile, fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return eventDao.save(newEvent);
        }
        try {
            throw new FileUploadException("failed to upload file");
        } catch (FileUploadException e) {
            throw new RuntimeException(e);
        }
    }

    public Event updateEvent(UUID eventId, EventDto eventDto, MultipartFile imageFile){
        Event event = eventDao.findEventById(eventId);

       return null;
    }

    private String generateUniqueFileName(String originalFileName) {
        return UUID.randomUUID().toString().concat("_" + originalFileName);
    }

    private void saveImageToFile(MultipartFile imageFile, String fileName) throws IOException {
        Path imagePath = Path.of("src/main/resources/static/img");
        Files.copy(imageFile.getInputStream(), imagePath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
    }
}
