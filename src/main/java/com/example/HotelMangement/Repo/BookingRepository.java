package com.example.HotelMangement.Repo;

import com.example.HotelMangement.Entity.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, Integer> {

    Booking findById(String id);

}
