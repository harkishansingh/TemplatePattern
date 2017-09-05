package com.harki.pattern.service;

import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harki.pattern.model.Customer;

@Service
public class OnlineBankingJava8 {
	@Autowired
	CustomerDatabase database;

	public void processCustomer(String name, Consumer<Customer> makeCustomerHappy) {
		Optional<Customer> customer = database.getCustomer(name);
		if (customer.isPresent())
			makeCustomerHappy.accept(customer.get());
		else
			throw new RuntimeException("No customer found with name " + name);
	}

}
