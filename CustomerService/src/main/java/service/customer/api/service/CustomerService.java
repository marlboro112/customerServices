package service.customer.api.service;

import org.springframework.stereotype.Service;

import service.customer.api.dto.CustomerDTO;
import service.customer.api.request.CustomerRequestModel;
import service.customer.api.request.CustomerUpdateRequestModel;
import service.customer.api.response.CustomerDetailsResponseModel;
import service.customer.api.response.CustomerResponseModel;

@Service
public interface CustomerService {
	
	//Get Customer by public id for internal use
	CustomerDTO getCustomerByPublicId (String publicId);
	
	// Create new customer
	CustomerResponseModel createCustomer (CustomerRequestModel customer);
	
	// Find Customer by public id	
	CustomerDetailsResponseModel findCustomerByPublicId (String publicId);
	
	//Update Customer
	CustomerResponseModel updateCustomer (CustomerUpdateRequestModel customer, String publicId);

}
