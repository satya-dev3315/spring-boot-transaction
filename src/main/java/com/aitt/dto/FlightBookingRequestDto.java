package com.aitt.dto;

import com.aitt.entity.PassengerInfo;
import com.aitt.entity.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequestDto {

	private PassengerInfo passengerInfo;
	private PaymentInfo paymentInfo;
}
