package service.customer.api.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import service.customer.api.dto.CityDTO;
import service.customer.api.entity.CityEntity;
import service.customer.api.repository.CityRepository;
import service.customer.api.request.CityRequestModel;
import service.customer.api.response.CityResponseModel;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CountryService countryService;
	
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

	// Add City to Database for Administrator use
	@Override
	public CityResponseModel addCity(CityRequestModel city) {
		CityEntity checkStoredcityEntity = cityRepository.findByCityName(city.getCityName());
		if (checkStoredcityEntity != null) throw new RuntimeException(city.getCityName());
		CityDTO cityDTO = new CityDTO();
		Gson gson = new Gson();
		Date currentDate = new Date();
		cityDTO.setPublicId(UUID.randomUUID().toString());
		cityDTO.setDescription(city.getDescription());
		cityDTO.setCreatedBy(city.getLogedInUserPublicId());
		cityDTO.setCreated(currentDate);
		cityDTO.setModifiedBy(city.getLogedInUserPublicId());
		cityDTO.setModified(currentDate);
		cityDTO.setDeleted(false);
		cityDTO.setDeletedBy("Not deleted yet");
		cityDTO.setEnabled(true);
		cityDTO.setCityName(city.getCityName());
		cityDTO.setCountry(countryService.getCountryByPublicId(city.getCountryPublicId()));	
		String temp = gson.toJson(cityDTO);
		CityEntity cityEntity = gson.fromJson(temp, CityEntity.class);
		CityEntity savedCityEntity = cityRepository.save(cityEntity);
		temp = gson.toJson(savedCityEntity);
		CityDTO savedCityDTO = gson.fromJson(temp, CityDTO.class);
		CityResponseModel returnValue = new CityResponseModel();
		returnValue.setCityName(savedCityDTO.getCityName());
		returnValue.setCountryName(savedCityDTO.getCountry().getCountryName());
		returnValue.setDescription(savedCityDTO.getDescription());
		returnValue.setEnabled(savedCityDTO.getEnabled());
		returnValue.setPublicId(savedCityDTO.getPublicId());
		return returnValue;
		
	}
	
/*******************************************************************************************************************/
	
	
}
