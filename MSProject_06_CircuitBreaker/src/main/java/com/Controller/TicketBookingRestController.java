package com.Controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController()
@RequestMapping("/Booking")
public class TicketBookingRestController {

	    @CircuitBreaker(name = "ticketService",fallbackMethod = "dummyBookTicket")
		@GetMapping("/book")
		public String bookTicket() {
	    	
		    if (new Random().nextInt(10) <= 5) {
		        throw new RuntimeException("Problem in ticket service");
		    }
		    System.out.println("Ticket is Booked");
		    return "Ticket booked successfully";
		}
		public String dummyBookTicket(Throwable ex) {
			  System.out.println("Ticket is Not Booked :Booking service is unreachable...");
		    return "Ticket service is temporarily unavailable. Please try again later.";
		}
}
