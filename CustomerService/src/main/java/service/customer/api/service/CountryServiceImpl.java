package service.customer.api.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import service.customer.api.dto.CountryDTO;
import service.customer.api.entity.CountryEntity;
import service.customer.api.repository.CountryRepository;
import service.customer.api.request.CountryRequestModel;
import service.customer.api.response.CountryResponseModel;

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
	// Add new Country to database. Use for Administrator.
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
	
}
