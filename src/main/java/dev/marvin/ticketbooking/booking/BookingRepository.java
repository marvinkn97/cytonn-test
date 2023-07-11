package dev.marvin.ticketbooking.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingsByAppUserId(Long userId);
    List<Booking> findBookingsByEventId(Long eventId);
    Booking findBookingById(Long bookingId);
}
