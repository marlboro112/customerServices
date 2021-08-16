package service.customer.api.service;

import service.customer.api.request.CustomerRequestModel;
import service.customer.api.response.CustomerResponseModel;

public interface CustomerService {
	
	// Create new customer
	CustomerResponseModel createCustomer (CustomerRequestModel customer);

}
