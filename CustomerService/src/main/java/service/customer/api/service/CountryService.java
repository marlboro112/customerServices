package service.customer.api.service;

import service.customer.api.dto.CountryDTO;

public interface CountryService {

CountryDTO getCountry(String countryPublicId);

}
