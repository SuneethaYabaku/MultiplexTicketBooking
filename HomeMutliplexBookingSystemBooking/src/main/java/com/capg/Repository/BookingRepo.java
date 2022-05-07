package com.capg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.Model.Booking;
 
 
 @Repository
 public interface BookingRepo extends JpaRepository<Booking, Integer> {
	 
 }