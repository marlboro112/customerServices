package service.customer.api.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import service.customer.api.dto.ContactPersonesDTO;
import service.customer.api.entity.ContactPersonesEntity;
import service.customer.api.repository.ContactPersonesRepository;
import service.customer.api.request.ContactPersonesRequestModel;
import service.customer.api.response.ContactPersonesResponseModel;

public class ContactPersonesServiceImpl implements ContactPersonesService {
	
	@Autowired
	ContactPersonesRepository contactPersonesRepository;
	
	@Autowired
	CityService cityService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	AddressesTypeService addressesTypeService;
	
	@Autowired
	CustomerService customerService;
	
/***********************************************************************************************************/

	// Get Contact Persons by public id and return DTO for internal use
	@Override
	public ContactPersonesDTO getContactPersonesByPublicId(String publicId) {
		ContactPersonesEntity contactPersonesEntity = contactPersonesRepository.findByPublicId(publicId);
		if(contactPersonesEntity == null || contactPersonesEntity.getDeleted() == true) throw new RuntimeException(publicId);
		Gson gson = new Gson();
		String temp = gson.toJson(contactPersonesEntity);
		ContactPersonesDTO contactPersonesDTO = gson.fromJson(temp,ContactPersonesDTO.class);
		return 	contactPersonesDTO;	
	}
	
/***********************************************************************************************************/

	// Add new Contact Persons to Database
	@Override
	public ContactPersonesResponseModel addContactPersones(ContactPersonesRequestModel contactPersones) {
		ContactPersonesDTO contactPersonesDTO = new ContactPersonesDTO();
		Gson gson = new Gson();
		Date currentDate = new Date();
		
		contactPersonesDTO.setPublicId(UUID.randomUUID().toString());
		contactPersonesDTO.setDescription(contactPersones.getDescription());
		contactPersonesDTO.setCreatedBy(contactPersones.getLogedInUserPublicId());
		contactPersonesDTO.setCreated(currentDate);
		contactPersonesDTO.setModifiedBy(contactPersones.getLogedInUserPublicId());
		contactPersonesDTO.setModified(currentDate);
		contactPersonesDTO.setDeleted(false);
		contactPersonesDTO.setDeletedBy("Not Deleted Yet");
		contactPersonesDTO.setEnabled(true);
		contactPersonesDTO.setCustomer(customerService.getCustomerByPublicId(contactPersones.getCustomerPublicId()));
		contactPersonesDTO.setEmail(contactPersones.getEmail());
		contactPersonesDTO.setFullName(contactPersones.getFullName());
		contactPersonesDTO.setMobileNumber(contactPersones.getMobileNumber());
		contactPersonesDTO.setPhoneNumber(contactPersones.getPhoneNumber());
		contactPersonesDTO.setPosition(contactPersones.getPosition());
		
		String temp = gson.toJson(contactPersonesDTO);
		ContactPersonesEntity contactPersonesEntity = gson.fromJson(temp, ContactPersonesEntity.class);
		ContactPersonesEntity savedcontactPersonesEntity = contactPersonesRepository.save(contactPersonesEntity);
		temp = gson.toJson(savedcontactPersonesEntity);
		ContactPersonesDTO savedcontactPersonesDTO = gson.fromJson(temp, ContactPersonesDTO.class);
		
		ContactPersonesResponseModel returnValue = new ContactPersonesResponseModel();
		returnValue.setFullName(savedcontactPersonesDTO.getFullName());
		returnValue.setMobileNumber(savedcontactPersonesDTO.getMobileNumber());
		returnValue.setPhoneNumber(savedcontactPersonesDTO.getPhoneNumber());
		returnValue.setEmail(savedcontactPersonesDTO.getEmail());
		returnValue.setPosition(savedcontactPersonesDTO.getPosition());
		returnValue.setPublicId(savedcontactPersonesDTO.getPublicId());
		returnValue.setCustomerName(savedcontactPersonesDTO.getCustomer().getCustomerName());
		
		return returnValue;
		
	}

}
