package service.customer.api.service;

import org.springframework.stereotype.Service;

import service.customer.api.dto.CityDTO;
import service.customer.api.request.CityRequestModel;
import service.customer.api.response.CityResponseModel;

@Service
public interface CityService {

	CityDTO getCityByPublicId(String publicId);
	CityResponseModel addCity (CityRequestModel city);

}
