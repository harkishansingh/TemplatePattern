package com.harki.pattern.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.harki.pattern.model.Customer;

public abstract class OnlineBanking {
	@Autowired
	CustomerDatabase database;

	public void processCustomer(String name) {
		Optional<Customer> customer = database.getCustomer(name);
		if (customer.isPresent())
			makeCustomerHappy(customer.get());
		else
			throw new RuntimeException("No customer found with name " + name);
	}

	abstract void makeCustomerHappy(Customer customer);
}
