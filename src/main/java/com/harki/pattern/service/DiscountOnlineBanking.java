package com.harki.pattern.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.harki.pattern.model.Customer;

@Service
@Qualifier(value = "DiscountOnlineBanking")
public class DiscountOnlineBanking extends OnlineBanking{

	@Override
	void makeCustomerHappy(Customer customer) {
		System.out.println("Inside DiscountOnlineBanking");
		
	}

}
