package dev.marvin.ticketbooking.booking;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
@Primary
public class BookingDaoJpaImpl implements BookingDao {
    private final BookingRepository bookingRepository;

    @Override
    public List<Booking> findBookingsByUserId(Long userId) {
        return bookingRepository.findBookingsByAppUserId(userId);
    }

    @Override
    public List<Booking> findBookingsByEventId(Long eventId) {
        return bookingRepository.findBookingsByEventId(eventId);
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findBookingById(Long bookingId) {
        return bookingRepository.findBookingById(bookingId);
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBookingById(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
