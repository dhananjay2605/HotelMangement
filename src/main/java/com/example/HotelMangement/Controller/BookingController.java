package com.example.HotelMangement.Controller;

import com.example.HotelMangement.Entity.Booking;
import com.example.HotelMangement.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;
    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        Booking save = this.bookingService.createBooking(booking);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getStudent(@RequestParam String id) {
        return ResponseEntity.ok(this.bookingService.getBookingById(id));
    }

    @DeleteMapping("/cancel")
    public ResponseEntity<?> cancelBooking(@RequestParam String bookingId) {
        this.bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}
