package service.customer.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import service.customer.api.dto.CityDTO;
import service.customer.api.request.CityRequestModel;
import service.customer.api.response.CityResponseModel;
import service.customer.api.response.SuperUserCityResponseModel;

@Service
public interface CityService {

	CityDTO getCityByPublicId(String publicId);
	CityResponseModel addCity (CityRequestModel city);
	CityResponseModel updateCity(CityRequestModel city, String publicId);
	List<CityResponseModel> getActiveCityListByCountry(String countryPublicId);
	List<SuperUserCityResponseModel> getAllCityListByCountry(String countryPublicId);
	Boolean disableCity(String publicId, String logedInUserPublicId);
	Boolean enableCity(String publicId, String logedInUserPublicId);
	Boolean deleteCity(String publicId, String logedInUserPublicId);

}
