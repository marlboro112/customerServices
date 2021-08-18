package service.customer.api.service;

import service.customer.api.dto.CityDTO;
import service.customer.api.request.CityRequestModel;
import service.customer.api.response.CityResponseModel;

public interface CityService {

	CityDTO getCityByPublicId(String publicId);
	CityResponseModel addCity (CityRequestModel city);

}
