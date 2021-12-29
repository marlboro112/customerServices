package service.customer.api.service;

import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import service.customer.api.dto.AddressesTypeDTO;
import service.customer.api.entity.AddressesTypeEntity;
import service.customer.api.repository.AddressesTypeRepository;
import service.customer.api.request.AddressesTypeRequestModel;
import service.customer.api.response.AddressesTypeResponseModel;

@Service
public class AddressesTypeServiceImpl implements AddressesTypeService {

	@Autowired
	AddressesTypeRepository addressesTypeRepository;

/**************************************************************************************************************************/
	
	// Get Addresses Type by public id and return as DTO for internal use
	@Override
	public AddressesTypeDTO getAddressTypeByPublicId(String publicId) {
	
		AddressesTypeEntity addressesTypeEntity = addressesTypeRepository.findByPublicId(publicId);
		if(addressesTypeEntity == null || addressesTypeEntity.getDeleted() == true) throw new RuntimeException(publicId);
		Gson gson = new Gson();
		String temp = gson.toJson(addressesTypeEntity);
		AddressesTypeDTO addressesTypeDTO = gson.fromJson(temp,AddressesTypeDTO.class);
		return 	addressesTypeDTO;	
	}
	
/****************************************************************************************************************************/

	// Add new Address Type to Database
	@Override
	public AddressesTypeResponseModel addAddressesType (AddressesTypeRequestModel type) {
		AddressesTypeEntity checkStoredAddressesTypeEntity = addressesTypeRepository.findByName(type.getName());
		if (checkStoredAddressesTypeEntity != null) throw new RuntimeException(type.getName());
		AddressesTypeDTO addressesTypeDTO = new AddressesTypeDTO();
		Gson gson = new Gson();
		Date currentDate = new Date();
		
		addressesTypeDTO.setPublicId(UUID.randomUUID().toString());
		addressesTypeDTO.setDescription(type.getDescription());
		addressesTypeDTO.setCreatedBy(type.getLogedInUserPublicId());
		addressesTypeDTO.setCreated(currentDate);
		addressesTypeDTO.setModifiedBy(type.getLogedInUserPublicId());
		addressesTypeDTO.setModified(currentDate);
		addressesTypeDTO.setDeleted(false);
		addressesTypeDTO.setDeletedBy("Not Deleted Yet");
		addressesTypeDTO.setEnabled(true);
		addressesTypeDTO.setName(type.getName());
		
		String temp = gson.toJson(addressesTypeDTO);
		AddressesTypeEntity addressesTypeEntity = gson.fromJson(temp, AddressesTypeEntity.class);
		AddressesTypeEntity savedAddressesTypeEntity = addressesTypeRepository.save(addressesTypeEntity);
		temp = gson.toJson(savedAddressesTypeEntity);
		AddressesTypeDTO savedAddressesTypeDTO = gson.fromJson(temp, AddressesTypeDTO.class);
		
		AddressesTypeResponseModel returnValue = new AddressesTypeResponseModel();
		returnValue.setName(savedAddressesTypeDTO.getName());
		returnValue.setDescription(savedAddressesTypeDTO.getDescription());
		returnValue.setEnabled(savedAddressesTypeDTO.getEnabled());
		returnValue.setPublicId(savedAddressesTypeDTO.getPublicId());
		
		return returnValue;	
		
	}

/***************************************************************************************************************************/
	// Delete AddressesType by publicId
	@Override
	public Boolean deleteAddressesType(String publicId, String logedInUserPublicId) {
		try {
			Date currentDate = new Date();
			ModelMapper modelMapper = new ModelMapper();
			AddressesTypeDTO addressesTypeDTO = getAddressTypeByPublicId(publicId);
			addressesTypeDTO.setDeleted(true);
			addressesTypeDTO.setDeletedBy(logedInUserPublicId);
			addressesTypeDTO.setEnabled(false);
			addressesTypeDTO.setModified(currentDate);
			addressesTypeDTO.setModifiedBy(logedInUserPublicId);
			AddressesTypeEntity addressesTypeEntity = modelMapper.map(addressesTypeDTO, AddressesTypeEntity.class);
			addressesTypeRepository.save(addressesTypeEntity);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
/********************************************************************************************************************/
	// Disbale AddressesType by publicId
	@Override
	public Boolean disableAddressesType(String publicId, String logedInUserPublicId) {
		try {
			Date currentDate = new Date();
			ModelMapper modelMapper = new ModelMapper();
			AddressesTypeDTO addressesTypeDTO = getAddressTypeByPublicId(publicId);
			addressesTypeDTO.setEnabled(false);
			addressesTypeDTO.setModified(currentDate);
			addressesTypeDTO.setModifiedBy(logedInUserPublicId);
			AddressesTypeEntity addressesTypeEntity = modelMapper.map(addressesTypeDTO, AddressesTypeEntity.class);
			addressesTypeRepository.save(addressesTypeEntity);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
/**************************************************************************************************************************/
	// Enable AddressesType by publicId
	@Override
	public Boolean enableAddressesType(String publicId, String logedInUserPublicId) {
		try {
			Date currentDate = new Date();
			ModelMapper modelMapper = new ModelMapper();
			AddressesTypeDTO addressesTypeDTO = getAddressTypeByPublicId(publicId);
			addressesTypeDTO.setEnabled(true);
			addressesTypeDTO.setModified(currentDate);
			addressesTypeDTO.setModifiedBy(logedInUserPublicId);
			AddressesTypeEntity addressesTypeEntity = modelMapper.map(addressesTypeDTO, AddressesTypeEntity.class);
			addressesTypeRepository.save(addressesTypeEntity);
		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
/*********************************************************************************************************************************/


	

}
