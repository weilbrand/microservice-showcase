package de.weilbrand.microservices.customerManagement.controller;

import java.util.List;

import de.weilbrand.microservices.customerManagement.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();
	void createCustomer(Customer customer);
	Customer getCustomer(String customerId) throws CustomerNotFoundException;
	void deleteCustomer(String customerId);
	void updateCustomer(String customerId, Customer customer);
}
