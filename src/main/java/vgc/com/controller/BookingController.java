package vgc.com.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import vgc.com.entities.Booking;
import vgc.com.service.BookingService;
import vgc.com.service.ScheduleService;
import vgc.com.service.SeatService;

@RestController
@Api("Booking API")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ScheduleService scheduleService;


    @ApiOperation(value = "Get list of booking")
    @GetMapping("/booking")
    public ResponseEntity<?> getBooking() {
        return bookingService.getBooking();
    }

    @ApiOperation(value = "Get a booking information")
    @GetMapping("/booking/{id}")
    public ResponseEntity<?> showBooking(@PathVariable int id) {
        return bookingService.showBooking(id);
    }

    @ApiOperation(value = "Get a booking's user")
    @GetMapping("/booking/{id}/users")
    public ResponseEntity<?> getBookingUser(@PathVariable int id) {
        return bookingService.getBookingUser(id);
    }

    @ApiOperation(value = "Get booking's schedule")
    @GetMapping("/booking/{id}/schedule")
    public ResponseEntity<?> getBookingSchedule(@PathVariable int id) {
        return bookingService.getBookingSchedule(id);
    }

    @ApiOperation(value = "Get booking seat")
    @GetMapping("/booking/{id}/seat")
    public ResponseEntity<?> getBookingSeat(@PathVariable int id) {
        return bookingService.getBookingSeat(id);
    }


    @ApiOperation(value = "Get booking total price")
    @GetMapping("/booking/{id}/price")
    public ResponseEntity<?> getPrice(@PathVariable int id) {
        return bookingService.getBookingPrice(id);
    }

    @ApiOperation(value = "Get booking status")
    @GetMapping("/booking/{id}/status")
    public ResponseEntity<?> getBookingStatus(@PathVariable int id) {
        return bookingService.getBookingStatus(id);
    }


    @ApiOperation(value = "Post a booking")
    @PostMapping("/booking/create")
    public void createBooking(@RequestBody Booking booking) {
        bookingService.addBooking(booking);
    }

    @ApiOperation(value = "Update a booking status")
    @PostMapping("/booking/{id}/{status}")
    public void updateStatus(@PathVariable int id, String status) {
        bookingService.updateBookingStatus(id, status);
    }




}
