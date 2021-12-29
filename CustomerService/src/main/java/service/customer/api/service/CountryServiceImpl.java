package service.customer.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import service.customer.api.dto.CountryDTO;
import service.customer.api.entity.CountryEntity;
import service.customer.api.repository.CountryRepository;
import service.customer.api.request.CountryRequestModel;
import service.customer.api.response.CountryResponseModel;
import service.customer.api.response.SuperUserCountryResponseModel;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	CountryRepository countryRepository;

/*****************************************************************************************************************/
	// Get Country by public id and return as DTO for internal use
	@Override
	public CountryDTO getCountryByPublicId(String publicId) {
		CountryEntity countryEntity = countryRepository.findByPublicId(publicId);
		if(countryEntity == null || countryEntity.getDeleted() == true) throw new RuntimeException(publicId);
		Gson gson = new Gson();
		String temp = gson.toJson(countryEntity);
		CountryDTO countryDTO = gson.fromJson(temp, CountryDTO.class);
		return countryDTO;
	}

/*******************************************************************************************************************/
	// Add new Country to database. Use for Super User.
	@Override
	public CountryResponseModel addCountry(CountryRequestModel country) {
		CountryEntity checkStoredcountryEntity = countryRepository.findByCountryName(country.getCountryName());
		if (checkStoredcountryEntity != null) throw new RuntimeException(country.getCountryName());
		CountryDTO countryDTO = new CountryDTO();
		Gson gson = new Gson();
		Date currentDate = new Date();
		countryDTO.setPublicId(UUID.randomUUID().toString());
		countryDTO.setDescription(country.getDescription());
		countryDTO.setCreatedBy(country.getLogedInUserPublicId());
		countryDTO.setCreated(currentDate);
		countryDTO.setModifiedBy(country.getLogedInUserPublicId());
		countryDTO.setModified(currentDate);
		countryDTO.setDeleted(false);
		countryDTO.setDeletedBy("Not deleted yet");
		countryDTO.setEnabled(true);
		countryDTO.setCountryName(country.getCountryName());
		String temp = gson.toJson(countryDTO);
		CountryEntity countryEntity = gson.fromJson(temp, CountryEntity.class);
		CountryEntity savedCountryEntity = countryRepository.save(countryEntity);
		temp = gson.toJson(savedCountryEntity);
		CountryDTO savedCountryDTO = gson.fromJson(temp, CountryDTO.class);
		temp = gson.toJson(savedCountryDTO);
		CountryResponseModel returnValue = gson.fromJson(temp, CountryResponseModel.class);		
		return returnValue;
	}
	
/**********************************************************************************************************************/
	// Update Country information. Use for Super User
	@Override
	public CountryResponseModel updateCountry(CountryRequestModel country, String publicId) {
		CountryDTO countryDTO = getCountryByPublicId(publicId);
		Date currentDate = new Date();
		countryDTO.setDescription(country.getDescription());
		countryDTO.setModifiedBy(country.getLogedInUserPublicId());
		countryDTO.setModified(currentDate);
		countryDTO.setCountryName(country.getCountryName());
		CountryEntity countryEntity = countryRepository.findByPublicId(publicId);
		BeanUtils.copyProperties(countryDTO, countryEntity);
		
		CountryEntity savedCountryEntity = countryRepository.save(countryEntity);
		CountryDTO savedCountryDTO = new CountryDTO();
		BeanUtils.copyProperties(savedCountryEntity, savedCountryDTO);
		CountryResponseModel returnValue = new CountryResponseModel();
		BeanUtils.copyProperties(savedCountryDTO, returnValue);
		
		return returnValue;
	}
/**********************************************************************************************************************/
	// Delete Country info by publicId
	@Override
	public Boolean deleteCountry(String publicId,String logedInUserPublicId) {
		try {
			Date currentDate = new Date();
			ModelMapper modelMapper = new ModelMapper();
			CountryDTO countryDTO = getCountryByPublicId(publicId);
			countryDTO.setDeleted(true);
			countryDTO.setDeletedBy(logedInUserPublicId);
			countryDTO.setEnabled(false);
			countryDTO.setModified(currentDate);
			countryDTO.setModifiedBy(logedInUserPublicId);
			CountryEntity countryEntity = modelMapper.map(countryDTO, CountryEntity.class);
			countryRepository.save(countryEntity);
		} catch (Exception e) {
			return false;
		}

		return true;
	}	
/***********************************************************************************************************************/
	// Disable Country info by publicId
	@Override
	public Boolean disableCountry(String publicId, String logedInUserPublicId) {
		try {
			Date currentDate = new Date();
			ModelMapper modelMapper = new ModelMapper();
			CountryDTO countryDTO = getCountryByPublicId(publicId);
			countryDTO.setEnabled(false);
			countryDTO.setModified(currentDate);
			countryDTO.setModifiedBy(logedInUserPublicId);
			CountryEntity countryEntity = modelMapper.map(countryDTO, CountryEntity.class);
			countryRepository.save(countryEntity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
/***************************************************************************************************************/
	// Get Active Country List
	@Override
	public List<CountryResponseModel> getCountryList() {
		Iterable<CountryEntity> countryEntitys = countryRepository.findAllActiveCountry();
		List<CountryDTO> countryDTOs = new ArrayList<CountryDTO>();
		List<CountryResponseModel> returnValue = new ArrayList<CountryResponseModel>();
		ModelMapper modelMapper = new ModelMapper();
		for(CountryEntity countryEntity : countryEntitys) {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO = modelMapper.map(countryEntity, CountryDTO.class);
			countryDTOs.add(countryDTO);
		}		
		for(CountryDTO countryDTO : countryDTOs) {
			CountryResponseModel country = new CountryResponseModel();
			country = modelMapper.map(countryDTO, CountryResponseModel.class);
			returnValue.add(country);
		}
		
		return returnValue;
	}

/****************************************************************************************************************/
	//Get All country list for SuperUser
	@Override
	public List<SuperUserCountryResponseModel> getAllCountryList() {
		Iterable<CountryEntity> countryEntitys = countryRepository.findAll();
		List<CountryDTO> countryDTOs = new ArrayList<CountryDTO>();
		List<SuperUserCountryResponseModel> returnValue = new ArrayList<SuperUserCountryResponseModel>();
		ModelMapper modelMapper = new ModelMapper();
		for(CountryEntity countryEntity : countryEntitys) {
			CountryDTO countryDTO = new CountryDTO();
			countryDTO = modelMapper.map(countryEntity, CountryDTO.class);
			countryDTOs.add(countryDTO);
		}		
		for(CountryDTO countryDTO : countryDTOs) {
			SuperUserCountryResponseModel country = new SuperUserCountryResponseModel();
			country = modelMapper.map(countryDTO, SuperUserCountryResponseModel.class);
			returnValue.add(country);
		}
		
		return returnValue;
	}
/********************************************************************************************************************/
	//Enable Country info by publicId
	@Override
	public Boolean enableCountry(String publicId, String logedInUserPublicId) {
		try {
			Date currentDate = new Date();
			ModelMapper modelMapper = new ModelMapper();
			CountryDTO countryDTO = getCountryByPublicId(publicId);
			countryDTO.setEnabled(true);
			countryDTO.setModified(currentDate);
			countryDTO.setModifiedBy(logedInUserPublicId);
			CountryEntity countryEntity = modelMapper.map(countryDTO, CountryEntity.class);
			countryRepository.save(countryEntity);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
/**********************************************************************************************************************/

}
