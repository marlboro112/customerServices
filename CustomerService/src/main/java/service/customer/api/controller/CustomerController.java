package service.customer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.customer.api.request.CustomerRequestModel;
import service.customer.api.response.CustomerDetailsResponseModel;
import service.customer.api.response.CustomerResponseModel;
import service.customer.api.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
/**************************************************************************************************************/
	// Add new Customer
	@PostMapping(path ="/add", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE })
	public CustomerResponseModel addCustomer (@RequestBody CustomerRequestModel customer) {
		CustomerResponseModel returnValue = customerService.createCustomer(customer);
		
		return returnValue;
	}
	
/****************************************************************************************************************/
	
	// Get Customer by Public Id
	@GetMapping(path ="/{publicId}", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE })
	public CustomerDetailsResponseModel findCustomerByPublicId (@PathVariable String publicId) {
		CustomerDetailsResponseModel returnValue = customerService.findCustomerByPublicId(publicId);
		
		return returnValue;
	}

}
