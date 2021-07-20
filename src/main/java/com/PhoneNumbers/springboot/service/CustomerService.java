package com.PhoneNumbers.springboot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.PhoneNumbers.springboot.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PhoneNumbers.springboot.repository.CustomerRepository;
//the customer Service implementation
@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	private CustomerRepository customerRepository; 
	@Override
	//get all customers
	public List<Customer> findAll() 
	{
		List<Customer> customers = this.customerRepository.findAll();
		customers = initializeCustomers(customers);
		customers.forEach(customer-> customer.validateCustomer());
		int [] id={1};
		customers.forEach(customer->{
			customer.setCountryCode(customer.getPhone().substring(1,4));
			customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
			customer.setId(id[0]++);
		});
		return customers;
	}
	/* initialize the customers based on their country so that if there is any needed for extensions in
	the customer class it is handled efficiently (transform customer to CountryCustomer )
	 */

	public static List<Customer> initializeCustomers(List<Customer> customers){
		List<Customer> initializedCustomers=new ArrayList<>();
		for (Customer customer:customers) {
			String countryCode = customer.getPhone().substring(1,4);
			switch (countryCode){
				case "212": customer.setCountry("Morocco");
					customer.setCountryCode(countryCode);
					customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
					initializedCustomers.add(new MoroccoCustomer(customer.getName(),customer.getPhone(),
							customer.getCountry(),customer.getValid()));
					break;
				case "237": customer.setCountry("Cameroon");
					customer.setCountryCode(countryCode);
					customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
					initializedCustomers.add(new CameroonCustomer(customer.getName(),customer.getPhone(),
							customer.getCountry(),customer.getValid()));
					break;
				case "251": customer.setCountry("Ethiopia");
					customer.setCountryCode(countryCode);
					customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
					initializedCustomers.add(new EthiopiaCustomer(customer.getName(),customer.getPhone(),
							customer.getCountry(),customer.getValid()));
					break;
				case "258": customer.setCountry("Mozambique");
					customer.setCountryCode(countryCode);
					customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
					initializedCustomers.add(new MozambiqueCustomer(customer.getName(),customer.getPhone(),
							customer.getCountry(),customer.getValid()));
					break;
				case "256": customer.setCountry("Uganda");
					customer.setCountryCode(countryCode);
					customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
					initializedCustomers.add(new UgandaCustomer(customer.getName(),customer.getPhone(),
							customer.getCountry(),customer.getValid()));
					break;
				default : customer.setCountry("Unknown");
					customer.setValid("Not Valid");
					customer.setCountryCode(countryCode);
					customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
					initializedCustomers.add(customer);
					break;

			}

		}
		int [] id={1};
		initializedCustomers.forEach(customer->{
			customer.setCountryCode(customer.getPhone().substring(1,4));
			customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
			customer.setId(id[0]++);
		});
		return initializedCustomers;
	}
	//Get customers based on state


	@Override
	public List<Customer> getValidOrInvalidCustomers(String valid) {
		
		List<Customer> customers= this.customerRepository.findAll();
		List<Customer> returnedCustomers= initializeCustomers(customers);
		returnedCustomers.forEach(customer->customer.validateCustomer());
		Iterator<Customer> itr = returnedCustomers.iterator();

		while (itr.hasNext())
		{ 
			Customer tempCustomer = itr.next(); 
			if (!tempCustomer.getValid().equals(valid)) 
			{
				itr.remove(); 
			} 
		}
		int [] id={1};
		returnedCustomers.forEach(customer->{
			customer.setCountryCode(customer.getPhone().substring(1,4));
			customer.setPhone(customer.getPhone().substring(5,customer.getPhone().length()));
			customer.setId(id[0]++);
		});

		return returnedCustomers;

	
	}
	//get Customers based on Country
	@Override
	public List<Customer> getCountryCustomers(String country) {
		// TODO Auto-generated method stub
		List<Customer> customers= this.customerRepository.findAll();
		List<Customer> returnedCustomers =initializeCustomers(customers);

		Iterator<Customer> itr = returnedCustomers.iterator();
		while (itr.hasNext()) 
		{ 
			Customer tempCustomer = itr.next(); 
			if (!tempCustomer.getCountry().equals(country)) 
			{
				itr.remove(); 
			}
		}
		returnedCustomers.forEach(customer->customer.validateCustomer());

		int [] id={1};
		returnedCustomers.forEach(customer->{
			customer.setCountryCode(customer.getPhone().substring(1,4));
			customer.setNumber(customer.getPhone().substring(5,customer.getPhone().length()));
			customer.setId(id[0]++);
		});
		return returnedCustomers;
	}

}



