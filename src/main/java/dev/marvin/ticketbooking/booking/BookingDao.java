package dev.marvin.ticketbooking.booking;

import java.util.List;

public interface BookingDao {
    List<Booking> findBookingsByUserId(Long userId);
    List<Booking> findBookingsByEventId(Long eventId);
    List<Booking> findAllBookings();
    Booking findBookingById(Long bookingId);
    Booking save(Booking booking);
    void deleteBookingById(Long bookingId);
}
