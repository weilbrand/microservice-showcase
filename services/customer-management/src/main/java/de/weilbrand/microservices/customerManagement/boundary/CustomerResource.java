package de.weilbrand.microservices.customerManagement.boundary;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import de.weilbrand.microservices.customerManagement.entity.Customer;

@Path("/customer")
public class CustomerResource {

	@GET
	public Response getCustomers() {
		return Response.ok("getCustomers").build();
	}
	
	@POST
	public Response createCustomer(Customer customer) {
		return Response.ok("createCustomer").build();
	}
	
	@Path("/{customerId}")
	@GET
	public Response getCustomer(@PathParam("customerId") String customerId) {
		return Response.ok("getCustomer").build();
	}

	@Path("/{customerId}")
	@PUT
	public Response updateCustomer(@PathParam("customerId") String customerId, Customer customer) {
		return Response.ok("updateCustomer").build();
	}
	
	@Path("/{customerId}")
	@DELETE
	public Response deleteCustomer(@PathParam("customerId") String customerId) {
		return Response.ok("deleteCustomer").build();
	}
}
