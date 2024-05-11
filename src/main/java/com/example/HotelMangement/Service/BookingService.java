package com.example.HotelMangement.Service;

import com.example.HotelMangement.Entity.Booking;
import com.example.HotelMangement.Entity.Hotel;
import com.example.HotelMangement.Exception.CustomException;
import com.example.HotelMangement.Repo.BookingRepository;
import com.example.HotelMangement.Repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    HotelRepository hotelRepository;

    public Booking createBooking(Booking booking) {
        try {
            String id = UUID.randomUUID().toString();
            booking.setId(id);
            Hotel hotel = hotelRepository.findById(booking.getHotelId());
            booking.setTotalCharge(hotel.getChargePerHead()*booking.getNumberOfGuests());
            return this.bookingRepository.save(booking);
        } catch (Exception ex) {
            throw new CustomException("Error occurred or hotel not present");
        }
    }

    public Booking getBookingById(String id) {
        try {
            if (this.bookingRepository.findById(id) != null)
                return this.bookingRepository.findById(id);
            else
                throw new CustomException("Booking Not Present");
        } catch (Exception ex) {
            throw new CustomException("Error occurred");
        }
    }


    public void cancelBooking(String bookingId) {
        try {
            Booking booking = getBookingById(bookingId);
            this.bookingRepository.delete(booking);
        } catch (Exception ex) {
            throw new CustomException("Error occurred");
        }
    }



}
