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

import service.customer.api.request.AddressesTypeRequestModel;
import service.customer.api.response.AddressesTypeResponseModel;
import service.customer.api.response.SuperUserAddressesTypeResponseModel;
import service.customer.api.service.AddressesTypeService;

@RestController
@RequestMapping("customer/addressestype")
public class AddressesTypeController {
	
	@Autowired
	AddressesTypeService addressesTypeService;

/*******************************************************************************************************************/
	// Add new Address Type
	@PostMapping(path ="/add", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE })	
	public AddressesTypeResponseModel addAddressesType (@RequestBody AddressesTypeRequestModel type) {
		AddressesTypeResponseModel returnValue = addressesTypeService.addAddressesType(type);
		return returnValue;		
	}

/*********************************************************************************************************************/
	//Update Address Type
	@PutMapping(path ="/{publicId}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public AddressesTypeResponseModel updateddressesType (@RequestBody AddressesTypeRequestModel type, @PathVariable String publicId) {
		AddressesTypeResponseModel returnValue = addressesTypeService.updateAddressesType(type,publicId);
		
		return returnValue;
	} 

/*********************************************************************************************************************/
	// Delete Address Type
	@DeleteMapping(path ="/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, 
		MediaType.APPLICATION_XML_VALUE })
	public Boolean deleteAddressesType (@PathVariable("publicId") String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) 	{
		Boolean returnValue = addressesTypeService.deleteAddressesType(publicId,logedInUserPublicId);

		return returnValue;
	}
/*********************************************************************************************************************/
	//Disable Address Type
	@GetMapping(path  ="/disable/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, 
		MediaType.APPLICATION_XML_VALUE })
	public Boolean disableAddressesType (@PathVariable("publicId") String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) 	{
		Boolean returnValue = addressesTypeService.disableAddressesType(publicId,logedInUserPublicId);

		return returnValue;
	}
/*********************************************************************************************************************/
	//Enable Address Type
	@GetMapping(path  ="/enable/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, 
		MediaType.APPLICATION_XML_VALUE })
	public Boolean enableAddressesType (@PathVariable("publicId") String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) 	{
		Boolean returnValue = addressesTypeService.enableAddressesType(publicId,logedInUserPublicId);

		return returnValue;
	}
/*********************************************************************************************************************/
	// Get Active Address Type List
	@GetMapping(path ="/", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public List<AddressesTypeResponseModel> getAddressesTypeList(){
		List<AddressesTypeResponseModel> returnValue = addressesTypeService.getAddressesTypeList();
		
		return returnValue;
	}

/*********************************************************************************************************************/
	//Get All Address Type List for SuperUser
	@GetMapping(path ="/superuser",consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public List<SuperUserAddressesTypeResponseModel> getAllCountryList(){
		List<SuperUserAddressesTypeResponseModel> returnValue = addressesTypeService.getAllAddressesTypeList();
		
		return returnValue;
	}
}
