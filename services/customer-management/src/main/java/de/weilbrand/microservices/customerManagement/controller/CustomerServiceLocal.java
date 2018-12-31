package de.weilbrand.microservices.customerManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import de.weilbrand.microservices.customerManagement.entity.Customer;

@ApplicationScoped
public class CustomerServiceLocal implements CustomerService {

	private List<Customer> customers;

	public CustomerServiceLocal() {
		customers = new ArrayList<>();
	}

	@Override
	public List<Customer> getCustomers() {
		return customers;
	}

	@Override
	public void createCustomer(Customer customer) {
		customers.add(new Customer(customer));
	}

	@Override
	public Customer getCustomer(String customerId) throws CustomerNotFoundException {
		Optional<Customer> potentialCustomer = customers.stream().filter(customer -> customer.getId() == customerId)
				.findFirst();

		if (potentialCustomer.isPresent()) {
			return new Customer(potentialCustomer.get());
		}

		throw new CustomerNotFoundException();
	}

	@Override
	public void deleteCustomer(String customerId) {
		Optional<Customer> potentialCustomer = customers.stream().filter(customer -> customer.getId() == customerId)
				.findFirst();

		if (potentialCustomer.isPresent()) {
			customers.remove(potentialCustomer.get());
		}
	}

	@Override
	public void updateCustomer(String customerId, Customer customer) {
		Optional<Customer> potentialCustomer = customers.stream().filter(c -> c.getId() == customerId)
				.findFirst();

		if (potentialCustomer.isPresent()) {
			Customer updatedCustomer = potentialCustomer.get();
			updatedCustomer.setName(customer.getName());
		}
	}

}
