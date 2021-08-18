package service.customer.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import service.customer.api.dto.CityDTO;
import service.customer.api.entity.CityEntity;
import service.customer.api.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityRepository cityRepository;
	
/************************************************************************************************************/

	// Get City by public id and return as DTO for internal use
	@Override
	public CityDTO getCityByPublicId(String publicId) {
		CityEntity cityEntity = cityRepository.findCityByPublicId(publicId);
		if(cityEntity == null || cityEntity.getDeleted() == true) throw new RuntimeException(publicId);
		Gson gson = new Gson();
		String temp = gson.toJson(cityEntity);
		CityDTO cityDTO = gson.fromJson(temp, CityDTO.class);
		return cityDTO;
	}
	
/***************************************************************************************************************/

}
