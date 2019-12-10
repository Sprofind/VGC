package vgc.com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vgc.com.entities.Booking;
import vgc.com.entities.Seat;
import vgc.com.repositories.iBookingRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private iBookingRepository bookingRepository;


    public ResponseEntity<?> getBooking() {
        return ResponseEntity.ok(bookingRepository.findAll());
    }

    public ResponseEntity<?> showBooking(int id) {
        return ResponseEntity.ok(bookingRepository.getOne(id));
    }

    public ResponseEntity<?> getBookingSchedule(int id) {
        return ResponseEntity.ok(bookingRepository.getOne(id).getSchedule_id());
    }

    public ResponseEntity<?> getBookingSeat(int id) {
        return ResponseEntity.ok(bookingRepository.getOne(id).getSeat_id());
    }

    public ResponseEntity<?> getBookingUser(int id) {
        return ResponseEntity.ok(bookingRepository.getOne(id).getUser_id());
    }

    public ResponseEntity<?> getBookingByUser(int id) {
        List<Booking> list = bookingRepository.findAll();
        for (Booking booking : list) {
            if (booking.getUser_id() != id) {
                list.remove(booking);
            }
        }
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<?> getBookingStatus(int id) {
        return ResponseEntity.ok(bookingRepository.getOne(id).isSeat_status());
    }

    public ResponseEntity<?> getBookingPrice(int id) {
        return ResponseEntity.ok(bookingRepository.getOne(id).getPrice());
    }

    public void addBooking(Booking booking) {
        bookingRepository.saveAndFlush(booking);
    }

    public void updateBookingStatus(int id, String status) {
        boolean newStatus = true;
        if (status.equalsIgnoreCase("true")) {

            bookingRepository.getOne(id).setSeat_status(newStatus);
        } else {
            newStatus = false;
            bookingRepository.getOne(id).setSeat_status(newStatus);
        }

    }




}
