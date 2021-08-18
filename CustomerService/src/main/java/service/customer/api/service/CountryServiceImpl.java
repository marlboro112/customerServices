package service.customer.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import service.customer.api.dto.CountryDTO;
import service.customer.api.entity.CountryEntity;
import service.customer.api.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	CountryRepository countryRepository;

/*****************************************************************************************************************/
	// Get Country by public id and return as DTO for internal use
	@Override
	public CountryDTO getCountryByPublicId(String publicId) {
		CountryEntity countryEntity = countryRepository.findCountryByPublicId(publicId);
		if(countryEntity == null || countryEntity.getDeleted() == true) throw new RuntimeException(publicId);
		Gson gson = new Gson();
		String temp = gson.toJson(countryEntity);
		CountryDTO countryDTO = gson.fromJson(temp, CountryDTO.class);
		return countryDTO;
	}

/*******************************************************************************************************************/
	
	
	
}
