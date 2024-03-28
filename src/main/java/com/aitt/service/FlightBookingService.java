package com.aitt.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aitt.dto.FlightBookingRequestDto;
import com.aitt.dto.FlightBookingResponseDto;
import com.aitt.entity.PassengerInfo;
import com.aitt.entity.PaymentInfo;
import com.aitt.repo.PassenengerRepo;
import com.aitt.repo.PaymentRepo;
import com.aitt.utils.PaymentUtils;


@Service
public class FlightBookingService {

	@Autowired
	private PassenengerRepo passenengerRepo;
	
	@Autowired
	private PaymentRepo paymentRepo;
	
	@Transactional(readOnly = false)   //its nt get request, so read only is fales because its nt used for reading purpose only but we r doing some actions
	public FlightBookingResponseDto bookTicket(FlightBookingRequestDto bookingRequestDto) {
				
		PassengerInfo passengerInfo = bookingRequestDto.getPassengerInfo();
		passengerInfo = passenengerRepo.save(passengerInfo);
		
		PaymentInfo paymentInfo = bookingRequestDto.getPaymentInfo();
		
		//validate payment, if its enough to book a ticket
		
		PaymentUtils.validateCredit(paymentInfo.getAccountNo(), passengerInfo.getFare());
		
		paymentInfo.setPassengerId(passengerInfo.getPassengerId());
		paymentInfo.setAmount(passengerInfo.getFare());
		
		paymentRepo.save(paymentInfo);
		
		return new FlightBookingResponseDto("Success", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
		
	}
}
