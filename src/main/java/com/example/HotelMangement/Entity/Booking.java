package com.example.HotelMangement.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document (collection = "booking")
public class Booking {

    @Id
    private String id;
    private String hotelId;
    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;
    private int numberOfGuests;
    private int totalCharge;

}
