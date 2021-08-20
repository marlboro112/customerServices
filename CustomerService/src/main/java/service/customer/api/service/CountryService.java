package service.customer.api.service;

import org.springframework.stereotype.Service;

import service.customer.api.dto.CountryDTO;
import service.customer.api.request.CountryRequestModel;
import service.customer.api.response.CountryResponseModel;

@Service
public interface CountryService {

	CountryDTO getCountryByPublicId(String publicId);
	CountryResponseModel addCountry (CountryRequestModel country);

}
