package com.example.HotelMangement.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document (collection = "hotel")
public class Hotel {

    @Id
    private String id;
    private String hotelName;
    private String location;
    private String about;
    private int chargePerHead;
}
