package service.customer.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import service.customer.api.dto.CountryDTO;
import service.customer.api.request.CountryRequestModel;
import service.customer.api.response.CountryResponseModel;
import service.customer.api.response.SuperUserCountryResponseModel;

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

	// Disable Country info by publicId
    Boolean disableCountry(String publicId, String logedInUserPublicId);

	// Get Active Country List
    List<CountryResponseModel> getCountryList();

	// Get All Country Llist for SuperUser
	List<SuperUserCountryResponseModel> getAllCountryList();

	//Enable Country Info by publicId
    Boolean enableCountry(String publicId, String logedInUserPublicId);

}
