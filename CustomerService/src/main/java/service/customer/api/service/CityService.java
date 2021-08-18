package service.customer.api.service;

import service.customer.api.dto.CityDTO;

public interface CityService {

	CityDTO getCityByPublicId(String publicId);

}
