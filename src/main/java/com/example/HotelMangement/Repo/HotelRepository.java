package com.example.HotelMangement.Repo;

import com.example.HotelMangement.Entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends MongoRepository<Hotel, Integer> {

    List<Hotel> findByLocation(String location);
    Hotel findById(String id);
}
