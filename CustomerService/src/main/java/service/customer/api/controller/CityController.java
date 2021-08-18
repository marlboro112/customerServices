package service.customer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.customer.api.request.CityRequestModel;
import service.customer.api.response.CityResponseModel;
import service.customer.api.service.CityService;

@RestController
@RequestMapping("customer/city")
public class CityController {
	
	@Autowired
	CityService cityService;
	
	
/*********************************************************************************************************/
	
	// Add new City
	@PostMapping(path ="/add", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE })
	public CityResponseModel addCity (@RequestBody CityRequestModel city) {		
		CityResponseModel returnValue = cityService.addCity(city);
		return returnValue;
	}
}
