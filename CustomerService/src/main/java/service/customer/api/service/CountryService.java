package service.customer.api.service;

import org.springframework.stereotype.Service;

import service.customer.api.dto.CountryDTO;
import service.customer.api.request.CountryRequestModel;
import service.customer.api.response.CountryResponseModel;

@Service
public interface CountryService {

	// Get Country by publicId
	CountryDTO getCountryByPublicId(String publicId);
	
	//Add new Country info
	CountryResponseModel addCountry (CountryRequestModel country);
	
	//Update Country info by publicId
	CountryResponseModel updateCountry(CountryRequestModel country, String publicId);

	// Delete Country info by publicId
    Boolean deleteCountry(String publicId,String logedInUserPublicId);

}
