package service.customer.api.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import service.customer.api.dto.AddressesDTO;
import service.customer.api.entity.AddressesEntity;
import service.customer.api.repository.AddressesRepository;
import service.customer.api.request.AddressesRequestModel;
import service.customer.api.response.AddressesResponseModel;

@Service
public class AddressesServiceImpl implements AddressesService {

	@Autowired
	AddressesRepository addressesRepository;
	
	@Autowired
	CityService cityService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	AddressesTypeService addressesTypeService;
	
	@Autowired
	CustomerService customerService;
	
	
/***********************************************************************************************/
	// Get addresses by public id and return as DTO for internal use
	@Override
	public AddressesDTO getAddressesByPublicId(String publicId) {
		AddressesEntity addressesEntity = addressesRepository.findByPublicId(publicId);
		if(addressesEntity == null || addressesEntity.getDeleted() == true) throw new RuntimeException(publicId);
		Gson gson = new Gson();
		String temp = gson.toJson(addressesEntity);
		AddressesDTO addressesDTO = gson.fromJson(temp,AddressesDTO.class);
		return 	addressesDTO;	
	}
	

/**************************************************************************************************/

	// Add new addresses to Database
	@Override
	public AddressesResponseModel addAddresses(AddressesRequestModel addresses) {
		AddressesDTO addressesDTO = new AddressesDTO();
		Gson gson = new Gson();
		Date currentDate = new Date();
		
		addressesDTO.setPublicId(UUID.randomUUID().toString());
		addressesDTO.setDescription(addresses.getDescription());
		addressesDTO.setCreatedBy(addresses.getLogedInUserPublicId());
		addressesDTO.setCreated(currentDate);
		addressesDTO.setModifiedBy(addresses.getLogedInUserPublicId());
		addressesDTO.setModified(currentDate);
		addressesDTO.setDeleted(false);
		addressesDTO.setDeletedBy("Not Deleted Yet");
		addressesDTO.setEnabled(true);
		addressesDTO.setStreetName(addresses.getStreetName());
		addressesDTO.setCity(cityService.getCityByPublicId(addresses.getCityPublicId()));
		addressesDTO.setCountry(countryService.getCountryByPublicId(addresses.getCountryPublicId()));
		addressesDTO.setType(addressesTypeService.getAddressTypeByPublicId(addresses.getTypePublicId()));		
		
		String temp = gson.toJson(addressesDTO);
		AddressesEntity addressesEntity = gson.fromJson(temp, AddressesEntity.class);
		AddressesEntity savedAddressesEntity = addressesRepository.save(addressesEntity);
		temp = gson.toJson(savedAddressesEntity);
		AddressesDTO savedAddressesDTO = gson.fromJson(temp, AddressesDTO.class);
		
		AddressesResponseModel returnValue = new AddressesResponseModel();
		returnValue.setPublicId(savedAddressesDTO.getPublicId());
		returnValue.setStreetName(savedAddressesDTO.getStreetName());
		returnValue.setPostCode(savedAddressesDTO.getPostCode());
		returnValue.setTypeName(savedAddressesDTO.getType().getName());
		returnValue.setDescription(savedAddressesDTO.getDescription());
		returnValue.setCity(savedAddressesDTO.getCity().getCityName());
		returnValue.setCountry(savedAddressesDTO.getCountry().getCountryName());
		returnValue.setCustomerName(savedAddressesDTO.getCustomer().getCustomerName());
		
		return returnValue;
	}

/**************************************************************************************************/
}
