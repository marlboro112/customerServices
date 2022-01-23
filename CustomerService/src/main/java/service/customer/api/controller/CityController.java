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

import service.customer.api.request.CityRequestModel;
import service.customer.api.response.CityResponseModel;
import service.customer.api.response.SuperUserCityResponseModel;
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
	
/**************************************************************************************************************/
	// Update City info by publicId
	@PutMapping(path ="/{publicId}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE })
	public CityResponseModel updateCity (@RequestBody CityRequestModel city, @PathVariable String publicId) {		
		CityResponseModel returnValue = cityService.updateCity(city,publicId);
		return returnValue;
	}
/*************************************************************************************************************/
	// Get Active City list for selected Country
	@GetMapping(path ="/{countryPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE })
	public List<CityResponseModel> getActiveCityListByCountry (@PathVariable String countryPublicId) {		
		List<CityResponseModel> returnValue = cityService.getActiveCityListByCountry(countryPublicId);
		return returnValue;
	}
/*************************************************************************************************************/
	// Get All City list by Country for Super User
	@GetMapping(path ="/superuser/{countryPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE })
	public List<SuperUserCityResponseModel> getActiveCityList (@PathVariable String countryPublicId) {		
		List<SuperUserCityResponseModel> returnValue = cityService.getAllCityListByCountry(countryPublicId);
		return returnValue;
	}
/*************************************************************************************************************/
	// Disable City Info by pubicId
	@GetMapping(path = "/disable/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Boolean disableCity(@PathVariable("publicId") String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) {
		Boolean returnValue = cityService.disableCity(publicId,logedInUserPublicId);
		return returnValue;
	}
/*************************************************************************************************************/
	// Enable City Info by pbicId
	@GetMapping(path = "/enable/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Boolean enableCity(@PathVariable("publicId") String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) {
		Boolean returnValue = cityService.enableCity(publicId,logedInUserPublicId);
		return returnValue;
	}
/*************************************************************************************************************/
	// Delete City Info by publicId
	@DeleteMapping(path = "/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Boolean deleteCity(@PathVariable("publicId") String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) {
		Boolean returnValue = cityService.deleteCity(publicId,logedInUserPublicId);
		return returnValue;
	}
/*************************************************************************************************************/
	
}
