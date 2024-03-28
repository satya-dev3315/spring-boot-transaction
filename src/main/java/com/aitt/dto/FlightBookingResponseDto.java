package com.aitt.dto;

import com.aitt.entity.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingResponseDto {

	private String status;
	private Double totalFare;
	private String pnr;
	
	private PassengerInfo passengerInfo;
}
