package com.example.HotelMangement.Controller;

import com.example.HotelMangement.Entity.Hotel;
import com.example.HotelMangement.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;
    @PostMapping("/createHotel")
    public ResponseEntity<?> createHotel(@RequestBody Hotel hotel) {
        Hotel save = this.hotelService.createHotel(hotel);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/getAllHotel")
    public ResponseEntity<?> getAllHotels() {
        return ResponseEntity.ok(this.hotelService.getAllHotel());
    }

    @GetMapping("/getByLocation")
    public ResponseEntity<?> getHotelByLocation(@RequestParam String location) {
        return ResponseEntity.ok(this.hotelService.getHotelByLocation(location));
    }

}
