package vgc.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vgc.com.entities.Booking;

public interface iBookingRepository extends JpaRepository<Booking, Integer> {
}
