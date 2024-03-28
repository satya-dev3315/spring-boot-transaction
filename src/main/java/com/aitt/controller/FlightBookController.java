package com.aitt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aitt.dto.FlightBookingRequestDto;
import com.aitt.dto.FlightBookingResponseDto;
import com.aitt.service.FlightBookingService;

@RestController
public class FlightBookController {

	
	@Autowired
	private FlightBookingService bookingService;
	
	@PostMapping("/bookTicket")
	public ResponseEntity<FlightBookingResponseDto> bookFlightTicket(@RequestBody FlightBookingRequestDto dto){
		FlightBookingResponseDto bookTicket = bookingService.bookTicket(dto);
		return new ResponseEntity<>(bookTicket, HttpStatus.CREATED);
		
	}
}
