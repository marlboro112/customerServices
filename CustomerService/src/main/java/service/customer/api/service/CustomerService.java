package service.customer.api.service;

import org.springframework.stereotype.Service;

import service.customer.api.dto.CustomerDTO;
import service.customer.api.request.CustomerRequestModel;
import service.customer.api.response.CustomerResponseModel;

@Service
public interface CustomerService {
	
	//Find Customer by public id
	CustomerDTO getCustomerByPublicId (String publicId);
	
	// Create new customer
	CustomerResponseModel createCustomer (CustomerRequestModel customer);

}
