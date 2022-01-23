package service.customer.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import service.customer.api.dto.CityDTO;
import service.customer.api.dto.CountryDTO;
import service.customer.api.entity.CityEntity;
import service.customer.api.repository.CityRepository;
import service.customer.api.request.CityRequestModel;
import service.customer.api.response.CityResponseModel;
import service.customer.api.response.SuperUserCityResponseModel;

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

	// Add City Info
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
	// Update City info
	@Override
	public CityResponseModel updateCity(CityRequestModel city, String publicId) {
		Date currentDate = new Date();
		Gson gson = new Gson();
		CityDTO cityDTO = getCityByPublicId(publicId);
		cityDTO.setDescription(city.getDescription());
		cityDTO.setModifiedBy(city.getLogedInUserPublicId());
		cityDTO.setModified(currentDate);
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
	//Get Active City list for selected Country
	@Override
	public List<CityResponseModel> getActiveCityListByCountry(String countryPublicId) {
		CountryDTO countryDTO = countryService.getCountryByPublicId(countryPublicId);
		Long countryId = countryDTO.getId();
		Iterable<CityEntity> cityEntitys = cityRepository.getActiveCityListByCountry(countryId);
		
		List<CityDTO> cityDTOs = new ArrayList<CityDTO>();
		List<CityResponseModel> returnValue = new ArrayList<CityResponseModel>();
		ModelMapper modelMapper = new ModelMapper();
		for(CityEntity cityEntity : cityEntitys) {
			CityDTO cityDTO = new CityDTO();
			cityDTO = modelMapper.map(cityEntity, CityDTO.class);
			cityDTOs.add(cityDTO);
		}		
		for(CityDTO cityDTO : cityDTOs) {
			CityResponseModel city = new CityResponseModel();
			city = modelMapper.map(cityDTO, CityResponseModel.class);
			returnValue.add(city);
		}
		
		return returnValue;
	}

/*****************************************************************************************************************/
	//Get All City list by Country for Super User
	@Override
	public List<SuperUserCityResponseModel> getAllCityListByCountry(String countryPublicId) {
		CountryDTO countryDTO = countryService.getCountryByPublicId(countryPublicId);
		Long countryId = countryDTO.getId();
        Iterable<CityEntity> cityEntitys = cityRepository.getAllCityListByCountry(countryId);		
		List<CityDTO> cityDTOs = new ArrayList<CityDTO>();
		List<SuperUserCityResponseModel> returnValue = new ArrayList<SuperUserCityResponseModel>();
		ModelMapper modelMapper = new ModelMapper();
		for(CityEntity cityEntity : cityEntitys) {
			CityDTO cityDTO = new CityDTO();
			cityDTO = modelMapper.map(cityEntity, CityDTO.class);
			cityDTOs.add(cityDTO);
		}		
		for(CityDTO cityDTO : cityDTOs) {
			SuperUserCityResponseModel city = new SuperUserCityResponseModel();
			city = modelMapper.map(cityDTO, SuperUserCityResponseModel.class);
			returnValue.add(city);
		}
		
		return returnValue;
	}
	
/**********************************************************************************************************************/
	//Disable City Info by pubicId
	@Override
	public Boolean disableCity(String publicId, String logedInUserPublicId) {
		try {
			Date currentDate = new Date();
			ModelMapper modelMapper = new ModelMapper();
			CityDTO cityDTO = getCityByPublicId(publicId);
			cityDTO.setEnabled(false);
			cityDTO.setModified(currentDate);
			cityDTO.setModifiedBy(logedInUserPublicId);
			CityEntity cityEntity = modelMapper.map(cityDTO, CityEntity.class);
			cityRepository.save(cityEntity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
		
/**********************************************************************************************************************/
	//Enable City Info by pubicId
	@Override
	public Boolean enableCity(String publicId, String logedInUserPublicId) {
		try {
			Date currentDate = new Date();
			ModelMapper modelMapper = new ModelMapper();
			CityDTO cityDTO = getCityByPublicId(publicId);
			cityDTO.setEnabled(true);
			cityDTO.setModified(currentDate);
			cityDTO.setModifiedBy(logedInUserPublicId);
			CityEntity cityEntity = modelMapper.map(cityDTO, CityEntity.class);
			cityRepository.save(cityEntity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}	
	
/**********************************************************************************************************************/
	//Delete City Info by pubicId
	@Override
	public Boolean deleteCity(String publicId, String logedInUserPublicId) {
		try {
			Date currentDate = new Date();
			ModelMapper modelMapper = new ModelMapper();
			CityDTO cityDTO = getCityByPublicId(publicId);
			cityDTO.setEnabled(false);
			cityDTO.setDeleted(true);
			cityDTO.setDeletedBy(logedInUserPublicId);
			cityDTO.setModified(currentDate);
			cityDTO.setModifiedBy(logedInUserPublicId);
			CityEntity cityEntity = modelMapper.map(cityDTO, CityEntity.class);
			cityRepository.save(cityEntity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
/*************************************************************************************************************************/
			
}
