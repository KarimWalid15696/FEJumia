package com.PhoneNumbers.springboot.service;
//Interface for the Customer Service
import java.util.ArrayList;
import java.util.List;

import com.PhoneNumbers.springboot.model.Customer;

public interface ICustomerService {

	public List<Customer> findAll();
	public List<Customer> getValidOrInvalidCustomers(String valid);
	public List<Customer> getCountryCustomers(String country);
	public static List<Customer> initializeCustomers(List<Customer> Customers){
		return new ArrayList<>();
	}
}
