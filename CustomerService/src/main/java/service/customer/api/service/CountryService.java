package service.customer.api.service;

import service.customer.api.dto.CountryDTO;
import service.customer.api.request.CountryRequestModel;
import service.customer.api.response.CountryResponseModel;

public interface CountryService {

	CountryDTO getCountryByPublicId(String publicId);
	CountryResponseModel addCountry (CountryRequestModel country);

}
