package service.customer.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import service.customer.api.dto.CustomerDTO;
import service.customer.api.request.AddAddressToCustomerRequestModel;
import service.customer.api.request.CustomerRequestModel;
import service.customer.api.request.CustomerUpdateRequestModel;
import service.customer.api.response.CustomerDetailsResponseModel;
import service.customer.api.response.CustomerResponseModel;
import service.customer.api.response.SuperUserCustomerResponseModel;

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
	
	// Get Active customer list
	List<CustomerResponseModel> getCustomerList();
	
	//Delete Customer by publicId
	Boolean deleteCustomer(String publicId,String logedInUserPublicId);
	
	//Disable Customer by publicId
	Boolean disableCustomer(String publicId,String logedInUserPublicId);
	
	//Get All Customer list for SuperUser
	List<SuperUserCustomerResponseModel> getAllCustomerList();
	
	// Add new address to Customer by pubicId
	CustomerDetailsResponseModel addAddressToCutsomerByPublicId(AddAddressToCustomerRequestModel addresses);

}
