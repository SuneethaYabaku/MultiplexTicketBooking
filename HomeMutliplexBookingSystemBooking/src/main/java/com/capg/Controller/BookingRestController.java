package com.capg.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.Exceptions.BookingAlreadyExistException;
import com.capg.Model.Booking;
import com.capg.Service.BookingService;

@RestController
@RequestMapping("/Booking")
public class BookingRestController {

	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/addBooking")
	public ResponseEntity<String> addBookingDetails(@Validated @RequestBody Booking booking) throws  BookingAlreadyExistException {
		Booking bookingResponse = bookingService.addBooking(booking);
		return new ResponseEntity<String>(bookingResponse.getBookingSeatId() + "has been inserted successfully", HttpStatus.OK);
	}

	@GetMapping("/getAllBooking")
	public ResponseEntity<List<Booking>> fetchAllBooking() {
		List<Booking> bookingObj = bookingService.getAllBooking();
		return new ResponseEntity<List<Booking>>(bookingObj, HttpStatus.OK);
	}

	@GetMapping("/getBookingById")
	public ResponseEntity<Booking> fetchBookingById(@RequestParam("id") int id) {
		Optional<Booking> booking = bookingService.fetchBookingById(id);
		return new ResponseEntity<Booking>(booking.get(), HttpStatus.OK);
	}
		//public class bookingRestController{
	
		/*@Autowired
	 BookingService BookingService;
		@Autowired
		private RestTemplate restTemplate;*/
		
		//@PostMapping("/addBooking")
		//public Booking addBookingDetails(@RequestBody Booking booking) throws  BookingAlreadyExistException{
			//return bookingService.addBookingDetails(booking);
//}
		}