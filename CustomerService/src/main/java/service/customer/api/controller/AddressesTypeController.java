package service.customer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.customer.api.request.AddressesTypeRequestModel;
import service.customer.api.response.AddressesTypeResponseModel;
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
}
