package com.harki.pattern.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.harki.pattern.model.Customer;

@Service
public class CustomerDatabase {
	
	private List<Customer> customers;
	
	@PostConstruct
	private void createCustomers(){
		customers = new ArrayList<>();
		Customer customer1 = new Customer();
		customer1.setAccountNo("123456789");
		customer1.setAccountType("Salary");
		customer1.setAddress("abcd");
		customer1.setMobileNo("9916161616");
		customer1.setName("Harkishan");
		
		Customer customer2 = new Customer();
		customer2.setAccountNo("987654321");
		customer2.setAccountType("Saving");
		customer2.setAddress("qwerty");
		customer2.setMobileNo("9919989898");
		customer2.setName("Harki");
		
		customers.add(customer1);
		customers.add(customer2);
	}
	
	public Optional<Customer> getCustomer(String name){
		return customers.stream().filter(d -> d.getName().equals(name)).findFirst();
	}

}
