package com.aitt.utils;

import java.util.HashMap;
import java.util.Map;

import com.aitt.exception.InsufficientAmountException;

public class PaymentUtils {

	private static Map<String, Double> paymentMap = new HashMap<>();  //we took static so we can initialize at time of class loading, hence belbow declare static block
	
	static{
		paymentMap.put("account-1", 10000.0);
		paymentMap.put("account-2", 20000.0);
		paymentMap.put("account-3", 30000.0);
		//we r hardcoding account no and amount limit, ie: how much amount u have in ur account
	}
	
	//now validate credit limit
	
	public static Boolean validateCredit(String accountNo , Double paidAmount) {
		
		//if amount to pay or paid amount is > mount u have in ur account , throw error
		if(paidAmount > paymentMap.get(accountNo)) {
			
			throw new InsufficientAmountException("Amount in your account is less than amount you have to pay ");
			
		}else {
			return true;
		}
		
	}
}

//send req
//{
//	  "passengerInfo": {
//	   
//	    "name": "Satya",
//	    "email": "satya@gmail.com",
//	    "source": "sagar",
//	    "destination": "pune",
//	    "fare": 5000.0,
//	    "travelDate": "29-02-2023"
//	  },
//	  "paymentInfo": {
//	    "accountNo": "account-1",
//	    "amount": 10000.0
//	  }
//	}