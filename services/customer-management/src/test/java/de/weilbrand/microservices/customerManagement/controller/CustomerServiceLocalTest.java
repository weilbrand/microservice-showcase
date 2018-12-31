package de.weilbrand.microservices.customerManagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.weilbrand.microservices.customerManagement.entity.Customer;

public class CustomerServiceLocalTest {

	private CustomerServiceLocal customerService;
	
	@BeforeEach
	public void setup() {
		customerService = new CustomerServiceLocal();
	}
	
	@Test
	public void createGetDeleteCustomerTest() {
		assertEquals(0, customerService.getCustomers().size());
		Customer expectedCustomer = new Customer("1234", "Bob");
		
		customerService.createCustomer(expectedCustomer);
		assertEquals(1, customerService.getCustomers().size());
		
		try {
			Customer customer = customerService.getCustomer("1234");
			assertNotNull(customer);
			
			customerService.deleteCustomer("1234");
			assertEquals(0, customerService.getCustomers().size());
		} catch (CustomerNotFoundException e) {
			fail();
		}
	}
	
	@Test
	public void getNonExistingCustomerTest() {
		assertThrows(CustomerNotFoundException.class, () -> {
			customerService.getCustomer("1234");
		});
	}
	
	@Test
	public void updateCustomerTest() throws CustomerNotFoundException {
		Customer newCustomer = new Customer("1234", "Bob");
		Customer updatedCustomer = new Customer("1234", "James");
		
		customerService.createCustomer(newCustomer);
		
		Customer actualCustomer = customerService.getCustomer("1234");
		newCustomer.setName("Blubb");
		assertEquals("Bob", actualCustomer.getName());
		
		customerService.updateCustomer("1234", updatedCustomer);
		
		actualCustomer = customerService.getCustomer("1234");
		updatedCustomer.setName("Blubb");
		assertEquals("James", actualCustomer.getName());
	}
	
}
