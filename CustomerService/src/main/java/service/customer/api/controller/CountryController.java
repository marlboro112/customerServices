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

import service.customer.api.request.CountryRequestModel;
import service.customer.api.response.CountryResponseModel;
import service.customer.api.response.SuperUserCountryResponseModel;
import service.customer.api.service.CountryService;

@RestController
@RequestMapping("customer/country")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
/**************************************************************************************************************/
	// Add new Country
	@PostMapping(path ="/add", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public CountryResponseModel addCountry (@RequestBody CountryRequestModel country) {
		CountryResponseModel returnValue = countryService.addCountry(country);
		return returnValue;
	}
	
/***************************************************************************************************************/
	//Update Country
	@PutMapping(path ="/{publicId}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public CountryResponseModel updateCountry (@RequestBody CountryRequestModel country, @PathVariable String publicId) {
		CountryResponseModel returnValue = countryService.updateCountry(country,publicId);
		
		return returnValue;
	} 
/***************************************************************************************************************/
	//Delete Country. If delete was success returnValue=true, otherwise returnValue=false
	@DeleteMapping(path ="/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Boolean deleteCountry (@PathVariable String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) {
		Boolean returnValue = countryService.deleteCountry(publicId,logedInUserPublicId);
		return returnValue;
	} 
/***************************************************************************************************************/
	//Disable Country by publicId. If disabling was success returnValue=true, otherwise returnValue=false 
	@GetMapping(path = "/disable/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Boolean disableCountry(@PathVariable("publicId") String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) {
		Boolean returnValue = countryService.disableCountry(publicId,logedInUserPublicId);
		return returnValue;
	}

/****************************************************************************************************************/
	//Enable Country by publicId. If enabling was success returnValue=true, otherwise returnValue=false 
	@GetMapping(path = "/enable/{publicId}/{logedInUserPublicId}", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public Boolean enableCountry(@PathVariable("publicId") String publicId,@PathVariable("logedInUserPublicId") String logedInUserPublicId) {
		Boolean returnValue = countryService.enableCountry(publicId,logedInUserPublicId);
		return returnValue;
	}
/***************************************************************************************************************/
	//Get Active Country list
	@GetMapping(path ="/", consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public List<CountryResponseModel> getCountryList(){
		List<CountryResponseModel> returnValue = countryService.getCountryList();
		
		return returnValue;
	}
/***************************************************************************************************************/
	//Get Country List for Super User
	@GetMapping(path ="/superuser",consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public List<SuperUserCountryResponseModel> getAllCountryList(){
		List<SuperUserCountryResponseModel> returnValue = countryService.getAllCountryList();
		
		return returnValue;
	}
/***************************************************************************************************************/

}
