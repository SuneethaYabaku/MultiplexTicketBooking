package com.capg.Service;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.capg.Exceptions.BookingAlreadyExistException;
import com.capg.Model.Booking;
import com.capg.Repository.BookingRepo;
@Service
public class BookingService {
	
	public Booking addBooking(Booking bookingObj) {
		return bookingRepo.save(bookingObj);
	}
	public List<Booking> getAllBooking(){
		return bookingRepo.findAll();
	}
public Optional<Booking> fetchBookingById(int id){
	return bookingRepo.findById(id);
	
}



@Autowired
private BookingRepo bookingRepo;

//@Autowired
 //private RestTemplate restTemplate;

//@Override
public Booking addBookingDetails(Booking booking) throws BookingAlreadyExistException {
	Optional <Booking> optionalBooking = bookingRepo.findById(booking.getBookingSeatId());
	if(optionalBooking.isPresent()) {
		throw new BookingAlreadyExistException("Booking already exists.....!");
	}
	return bookingRepo.save(booking);

			
	
	
}
}