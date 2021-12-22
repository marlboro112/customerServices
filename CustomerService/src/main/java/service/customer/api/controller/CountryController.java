package service.customer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.customer.api.request.CountryRequestModel;
import service.customer.api.response.CountryResponseModel;
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
	//TODO: Disable Country
/***************************************************************************************************************/
	//TODO: Get Country list
/***************************************************************************************************************/
	//TODO: Get Country List for Super User
/***************************************************************************************************************/

}
