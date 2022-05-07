package com.capg.Model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

	@Entity
	public class Booking {
		
		@Id
		private int bookingSeatId;
		 
		 @NotBlank
		@Size(max=10,message="seat type length should be min of 2")
		private String seatType;
		 

		public int getBookingSeatId() {
			return bookingSeatId;
		}
		public void setBookingSeatId(int bookingSeatId) {
			this.bookingSeatId = bookingSeatId;
		}
		
		public String getSeatType() {
			return seatType;
		}
		public void setSeatType(String seatType) {
			this.seatType = seatType;
		}
		
		
		public Booking(int bookingSeatId, String seatType) {
			super();
			this.bookingSeatId = bookingSeatId;
			this.seatType = seatType;
		}
		
		public Booking() {
			super();
		}
		@Override
		public String toString() {
			return "Booking [bookingSeatId = " + bookingSeatId + ", seatType=" + seatType + "]";
		}
		
		

		
	}