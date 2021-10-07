package service.customer.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.customer.api.dto.AddressesDTO;
import service.customer.api.dto.AddressesTypeDTO;
import service.customer.api.dto.CityDTO;
import service.customer.api.dto.ContactPersonesDTO;
import service.customer.api.dto.CountryDTO;
import service.customer.api.dto.CustomerDTO;
import service.customer.api.entity.CustomerEntity;
import service.customer.api.repository.CustomerRepository;
import service.customer.api.request.AddressesRequestModel;
import service.customer.api.request.ContactPersonesRequestModel;
import service.customer.api.request.CustomerRequestModel;
import service.customer.api.request.CustomerUpdateRequestModel;
import service.customer.api.response.CustomerDetailsResponseModel;
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
		ModelMapper modelMapper = new ModelMapper();
		CustomerEntity checkStoredCustomer  = customerRepository.findByCustomerName(customer.getCustomerName());
		if(checkStoredCustomer != null) throw new RuntimeException("Customer already availbale");
		
		customerDTO.setPublicId(UUID.randomUUID().toString());		
		customerDTO.setCreated(currentData);
		customerDTO.setCreatedBy(customer.getLogedInUserPublicId());
		customerDTO.setModified(currentData);
		customerDTO.setModifiedBy(customer.getLogedInUserPublicId());
		customerDTO.setDeleted(false);
		customerDTO.setDeletedBy("Not Deleted Yet");
		customerDTO.setEnabled(true);
		customerDTO.setCustomerName(customer.getCustomerName());
		customerDTO.setDescription(customer.getDescription());
		
		//Get Customer Contact Persons and add to Customer Info
				for (int i = 0; i < customer.getContactPersones().size(); i++) {
					
					ContactPersonesRequestModel contactPersones = customer.getContactPersones().get(i);
					ContactPersonesDTO contactPersonDTO = new ContactPersonesDTO();
					BeanUtils.copyProperties(contactPersones, contactPersonDTO);
					contactPersonDTO.setCustomer(customerDTO);
					contactPersonDTO.setPublicId(UUID.randomUUID().toString());
					contactPersonDTO.setCreated(currentData);
					contactPersonDTO.setCreatedBy(customer.getLogedInUserPublicId());
					contactPersonDTO.setModified(currentData);
					contactPersonDTO.setModifiedBy(customer.getLogedInUserPublicId());
					contactPersonDTO.setDeleted(false);
					contactPersonDTO.setDeletedBy("Not Deleted Yet");
					contactPersonDTO.setEnabled(true);
					contactPersonDTOS.add(i, contactPersonDTO);
				}
				
		//Get Customer Addresses and add to Customer Info
				for (int i = 0; i < customer.getAddresses().size(); i++) {
					
					AddressesRequestModel address = customer.getAddresses().get(i);
					AddressesDTO addressesDTO = new AddressesDTO();
					BeanUtils.copyProperties(address, addressesDTO);
					addressesDTO.setCustomer(customerDTO);
					addressesDTO.setPublicId(UUID.randomUUID().toString());
					addressesDTO.setCreated(currentData);
					addressesDTO.setCreatedBy(customer.getLogedInUserPublicId());
					addressesDTO.setModified(currentData);
					addressesDTO.setModifiedBy(customer.getLogedInUserPublicId());
					addressesDTO.setDeleted(false);
					addressesDTO.setDeletedBy("Not Deleted Yet");
					addressesDTO.setEnabled(true);
					AddressesTypeDTO addressTypeDTO = addressesTypeService.getAddressTypeByPublicId(address.getTypePublicId());
					addressesDTO.setType(addressTypeDTO);
					CityDTO cityDTO = cityService.getCityByPublicId(address.getCityPublicId());
					addressesDTO.setCity(cityDTO);
					CountryDTO countryDTO = countryService.getCountryByPublicId(address.getCountryPublicId());
					addressesDTO.setCountry(countryDTO);
					addressesDTOS.add(i, addressesDTO);
		
				}		
				
		customerDTO.setAddresses(addressesDTOS);
		customerDTO.setContactPersones(contactPersonDTOS);
		
		
		CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);
		

		CustomerEntity savedCustomerEntity = customerRepository.save(customerEntity);
		CustomerDTO savedCustomerDTO = modelMapper.map(savedCustomerEntity, CustomerDTO.class);

		CustomerResponseModel returnValue = modelMapper.map(savedCustomerDTO, CustomerResponseModel.class);
		
		return returnValue;
	}
	
/*****************************************************************************************************************************/

	//Get Customer by public id and return DTO for internal use	
	@Override
	public CustomerDTO getCustomerByPublicId(String publicId) {
		ModelMapper modelMapper = new ModelMapper();
		CustomerEntity customerEntity = customerRepository.findByPublicId(publicId);
		if(customerEntity == null) throw new RuntimeException(publicId);
		CustomerDTO returnValue = modelMapper.map(customerEntity, CustomerDTO.class);
		return returnValue;
	}

/**************************************************************************************************************************/

	// Find Customer by Public ID
	@Override
	public CustomerDetailsResponseModel findCustomerByPublicId(String publicId) {
		ModelMapper modelMapper = new ModelMapper();
		CustomerDTO customerDTO = getCustomerByPublicId(publicId);
		if(customerDTO == null || customerDTO.getDeleted() == true) throw new RuntimeException(publicId);
		CustomerDetailsResponseModel returnValue = modelMapper.map(customerDTO, CustomerDetailsResponseModel.class);
		return returnValue;
	}
			
/**************************************************************************************************************************/
	
	// Update Customer
	@Override
	public CustomerResponseModel updateCustomer (CustomerUpdateRequestModel customer, String publicId) {
		Date currentData = new Date();
		ModelMapper modelMapper = new ModelMapper();
		CustomerDTO customerDTO = getCustomerByPublicId(publicId);
		BeanUtils.copyProperties(customer, customerDTO);
		customerDTO.setModified(currentData);
		customerDTO.setModifiedBy(customer.getLogedInUserPublicId());
		
		CustomerEntity customerEntity = modelMapper.map(customerDTO, CustomerEntity.class);		
		CustomerEntity savedCustomerEntity = customerRepository.save(customerEntity);
		
		CustomerDTO savedCustomerDTO = modelMapper.map(savedCustomerEntity, CustomerDTO.class);
		
		CustomerResponseModel returnValue = modelMapper.map(savedCustomerDTO, CustomerResponseModel.class);		
		
		return returnValue;
	}

	
/*************************************************************************************************************************/

	@Override
	public List<CustomerResponseModel> getCustomerList() {
		Iterable<CustomerEntity> customerEntitys = customerRepository.findAllActiveCustomers();
		List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
		List<CustomerResponseModel> returnValue = new ArrayList<CustomerResponseModel>();
		ModelMapper modelMapper = new ModelMapper();
		for(CustomerEntity customerEntity : customerEntitys) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO = modelMapper.map(customerEntity, CustomerDTO.class);
			customerDTOs.add(customerDTO);
		}		
		for(CustomerDTO customerDTO : customerDTOs) {
			CustomerResponseModel customer = new CustomerResponseModel();
			customer = modelMapper.map(customerDTO, CustomerResponseModel.class);
			returnValue.add(customer);
		}
		
		return returnValue;
	}
}
