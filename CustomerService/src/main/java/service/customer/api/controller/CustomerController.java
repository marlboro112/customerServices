package service.customer.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.customer.api.request.AddAddressToCustomerRequestModel;
import service.customer.api.request.CustomerRequestModel;
import service.customer.api.request.CustomerUpdateRequestModel;
import service.customer.api.response.CustomerDetailsResponseModel;
import service.customer.api.response.CustomerResponseModel;
import service.customer.api.response.SuperUserCustomerResponseModel;
import service.customer.api.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
/**************************************************************************************************************/
	// Add new Customer
	@PostMapping(path ="/add", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public CustomerResponseModel addCustomer (@RequestBody CustomerRequestModel customer) {
		CustomerResponseModel returnValue = customerService.createCustomer(customer);
		
		return returnValue;
	}
	
/****************************************************************************************************************/
	
	// Get Customer by Public Id
	@GetMapping(path ="/{publicId}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public CustomerDetailsResponseModel findCustomerByPublicId (@PathVariable String publicId) {
		CustomerDetailsResponseModel returnValue = customerService.findCustomerByPublicId(publicId);
		
		return returnValue;
	}
	
/******************************************************************************************************************/

	
	// Update Customer info
	@PutMapping(path ="/{publicId}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	private CustomerResponseModel updateCustomer (@RequestBody CustomerUpdateRequestModel customer, @PathVariable String publicId) {
		CustomerResponseModel returnValue =  customerService.updateCustomer(customer, publicId);
		
		return returnValue;
	}
	
/***********************************************************************************************************************/
	
	// Get Customer list
	@GetMapping(path ="/", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public List<CustomerResponseModel> getCustomerList(){
		List<CustomerResponseModel> returnValue = customerService.getCustomerList();
		
		return returnValue;
	}
	
/***********************************************************************************************************************/
	// Delete Customer by publicId. If delete was success returnValue=true, otherwise returnValue=false 
	@DeleteMapping(path = "/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Boolean deleteCustomer(@PathVariable("publicId") String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) {
		Boolean returnValue = customerService.deleteCustomer(publicId,logedInUserPublicId);
		
		return returnValue;
	}
	
/***********************************************************************************************************************/
	// Disable Customer by publicId. If delete was success returnValue=true, otherwise returnValue=false 
	@GetMapping(path = "/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Boolean disableCustomer(@PathVariable("publicId") String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) {
		Boolean returnValue = customerService.disableCustomer(publicId,logedInUserPublicId);
		
		return returnValue;
	}
	
/***********************************************************************************************************************/
	//Add address to  Customer by publicId
	@PutMapping(path ="/addaddresstocustomer", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public CustomerDetailsResponseModel addAddressToCustomer (@RequestBody AddAddressToCustomerRequestModel addresses) {
		CustomerDetailsResponseModel returnValue = customerService.addAddressToCutsomerByPublicId(addresses);
		
		return returnValue;
	}
	
/***********************************************************************************************************************/
	//TODO: Add Contact Person to  Customer by publicId
	
/***********************************************************************************************************************/
	// Get all Customer list for SuperUser
	@GetMapping(path ="/superuser",consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public List<SuperUserCustomerResponseModel> getAllCustomerList(){
		List<SuperUserCustomerResponseModel> returnValue = customerService.getAllCustomerList();
		
		return returnValue;
	}
}
