package com.example.HotelMangement.Service;

import com.example.HotelMangement.Entity.Hotel;
import com.example.HotelMangement.Exception.CustomException;
import com.example.HotelMangement.Repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public Hotel createHotel(Hotel hotel) {
        try {
            String id = UUID.randomUUID().toString();
            hotel.setId(id);
            return this.hotelRepository.save(hotel);
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage());
        }
    }

    public List<Hotel> getAllHotel() {
        try {
            return this.hotelRepository.findAll();
        } catch (Exception ex) {
            throw new CustomException(ex.getMessage());
        }
    }

    public List<Hotel> getHotelByLocation(String location) {
        try {
            if (!this.hotelRepository.findByLocation(location).isEmpty())
                return this.hotelRepository.findByLocation(location);
            else
                throw new CustomException("Hotel Not Present");
        } catch (Exception ex) {
            throw new CustomException("Error Occurred");
        }
    }

}
