package service.customer.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import service.customer.api.dto.AddressesDTO;
import service.customer.api.dto.AddressesTypeDTO;
import service.customer.api.dto.CityDTO;
import service.customer.api.dto.ContactPersonesDTO;
import service.customer.api.dto.CountryDTO;
import service.customer.api.dto.CustomerDTO;
import service.customer.api.entity.CustomerEntity;
import service.customer.api.repository.CustomerRepository;
import service.customer.api.request.AddressRequestModel;
import service.customer.api.request.ContactPersonRequestModel;
import service.customer.api.request.CustomerRequestModel;
import service.customer.api.response.CustomerResponseModel;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressesTypeService addressesTypeService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	CityService cityService;
	
/**************************************************************************************************************************/
	// Create New Customer
	@Override
	public CustomerResponseModel createCustomer(CustomerRequestModel customer) {
		
		CustomerDTO customerDTO = new CustomerDTO();
		List<ContactPersonesDTO> contactPersonDTOS = new ArrayList<ContactPersonesDTO>();
		List<AddressesDTO> addressesDTOS = new ArrayList<AddressesDTO>();
		Date currentData = new Date();
		Gson gson = new Gson();
		CustomerEntity checkStoredCustomer  = customerRepository.findByCustomerName(customer.getCustomerName());
		if(checkStoredCustomer != null) throw new RuntimeException("Customer already availbale");
		
		customerDTO.setPublicId(UUID.randomUUID());		
		customerDTO.setCreated(currentData);
		customerDTO.setCreatedBy(customer.getLogedInUserPublicId());
		customerDTO.setModified(currentData);
		customerDTO.setModifiedBy(customer.getLogedInUserPublicId());
		customerDTO.setDeleted(false);
		customerDTO.setEnabled(true);
		customerDTO.setCustomerName(customer.getCustomerName());
		customerDTO.setDescription(customer.getDescription());
		
		//Get Customer Contact Persons and add to Customer Info
				for (int i = 0; i < customer.getContactPersones().size(); i++) {
					
					ContactPersonRequestModel contactPersones = customer.getContactPersones().get(i);
					ContactPersonesDTO contactPersonDTO = new ContactPersonesDTO();
					BeanUtils.copyProperties(contactPersones, contactPersonDTO);
					contactPersonDTO.setCustomer(customerDTO);
					contactPersonDTO.setPublicId(UUID.randomUUID());
					contactPersonDTO.setCreated(currentData);
					contactPersonDTO.setCreatedBy(customer.getLogedInUserPublicId());
					contactPersonDTO.setModified(currentData);
					contactPersonDTO.setModifiedBy(customer.getLogedInUserPublicId());
					contactPersonDTO.setDeleted(false);
					contactPersonDTO.setEnabled(true);
					contactPersonDTOS.add(i, contactPersonDTO);
				}
				
		//Get Customer Addresses and add to Customer Info
				for (int i = 0; i < customer.getAddresses().size(); i++) {
					
					AddressRequestModel address = customer.getAddresses().get(i);
					AddressesDTO addressesDTO = new AddressesDTO();
					BeanUtils.copyProperties(address, addressesDTO);
					addressesDTO.setCustomer(customerDTO);
					addressesDTO.setPublicId(UUID.randomUUID());
					addressesDTO.setCreated(currentData);
					addressesDTO.setCreatedBy(customer.getLogedInUserPublicId());
					addressesDTO.setModified(currentData);
					addressesDTO.setModifiedBy(customer.getLogedInUserPublicId());
					addressesDTO.setDeleted(false);
					addressesDTO.setEnabled(true);
					AddressesTypeDTO addressTypeDTO = addressesTypeService.getAddressType(address.getTypePublicId());
					addressesDTO.setType(addressTypeDTO);
					CityDTO cityDTO = cityService.getCity(address.getCityPublicId());
					addressesDTO.setCity(cityDTO);
					CountryDTO countryDTO = countryService.getCountry(address.getCountryPublicId());
					addressesDTO.setCountry(countryDTO);
					addressesDTOS.add(i, addressesDTO);
		
				}		
				
		customerDTO.setAddresses(addressesDTOS);
		customerDTO.setContactPersones(contactPersonDTOS);
		
		String temp = gson.toJson(customerDTO);
		CustomerEntity customerEntity = gson.fromJson(temp,CustomerEntity.class);
		customerRepository.save(customerEntity);
		
		temp = gson.toJson(customerEntity);
		CustomerResponseModel returnValue = gson.fromJson(temp, CustomerResponseModel.class);
		
		return returnValue;
	}
	
/**************************************************************************************************************************/

}
