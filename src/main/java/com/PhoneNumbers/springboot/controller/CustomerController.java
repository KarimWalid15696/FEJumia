package com.PhoneNumbers.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.PhoneNumbers.springboot.model.Customer;
import com.PhoneNumbers.springboot.service.CustomerService;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CustomerController
{
    //Service object 
	@Autowired
	private CustomerService customerService;
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("customers")
	//api to get all customers in DB
	public List<Customer> getCustomers()
	{
		return customerService.findAll();
	}
	@GetMapping("customers/hello")
	public String getHelloWorld() {

		return "Hello world";
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("customers/country")
	@ResponseBody
	//api to get all customers in DB for a certain Country or Country Code
	public List<Customer> getCountryCustomers(@RequestParam String country)
	{
		
		return this.customerService.getCountryCustomers(country);
		
	}
	//api to get all customers in DB with a certain state
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("customers/valid")
	@ResponseBody
	public List<Customer> getValidCustomers(@RequestParam String valid)
	{
		return this.customerService.getValidOrInvalidCustomers(valid);
	}
	
}
	
