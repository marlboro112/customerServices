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

import service.customer.api.dto.AddressesTypeDTO;
import service.customer.api.entity.AddressesTypeEntity;
import service.customer.api.repository.AddressesTypeRepository;
import service.customer.api.request.AddressesTypeRequestModel;
import service.customer.api.response.AddressesTypeResponseModel;
import service.customer.api.response.SuperUserAddressesTypeResponseModel;

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
	//Update AddressesType by publicId
	@Override
	public AddressesTypeResponseModel updateAddressesType(AddressesTypeRequestModel type, String publicId) {
		AddressesTypeDTO addressesTypeDTO = getAddressTypeByPublicId(publicId);
		Date currentDate = new Date();
		addressesTypeDTO.setDescription(type.getDescription());
		addressesTypeDTO.setModifiedBy(type.getLogedInUserPublicId());
		addressesTypeDTO.setModified(currentDate);
		addressesTypeDTO.setName(type.getName());
		AddressesTypeEntity addressesTypeEntity = addressesTypeRepository.findByPublicId(publicId);
		BeanUtils.copyProperties(addressesTypeDTO, addressesTypeEntity);
		
		AddressesTypeEntity savedaddressesTypeEntity = addressesTypeRepository.save(addressesTypeEntity);
		AddressesTypeDTO savedaddressesTypeDTO = new AddressesTypeDTO();
		BeanUtils.copyProperties(savedaddressesTypeEntity, savedaddressesTypeDTO);
		AddressesTypeResponseModel returnValue = new AddressesTypeResponseModel();
		BeanUtils.copyProperties(savedaddressesTypeDTO, returnValue);
		
		return returnValue;
	}
/**********************************************************************************************************************/
	// Get Active AddressesType List
	@Override
	public List<AddressesTypeResponseModel> getAddressesTypeList() {
		Iterable<AddressesTypeEntity> addressesTypeEntitys = addressesTypeRepository.findAllActiveAddressesType();
		List<AddressesTypeDTO> addressesTypeDTOs = new ArrayList<AddressesTypeDTO>();
		List<AddressesTypeResponseModel> returnValue = new ArrayList<AddressesTypeResponseModel>();
		ModelMapper modelMapper = new ModelMapper();
		for(AddressesTypeEntity addressesTypeEntity : addressesTypeEntitys) {
			AddressesTypeDTO addressesTypeDTO = new AddressesTypeDTO();
			addressesTypeDTO = modelMapper.map(addressesTypeEntity, AddressesTypeDTO.class);
			addressesTypeDTOs.add(addressesTypeDTO);
		}		
		for(AddressesTypeDTO addressesTypeDTO : addressesTypeDTOs) {
			AddressesTypeResponseModel addressesType = new AddressesTypeResponseModel();
			addressesType = modelMapper.map(addressesTypeDTO, AddressesTypeResponseModel.class);
			returnValue.add(addressesType);
		}
		
		return returnValue;
	}
/********************************************************************************************************************/
	// Get All AddressesType Llist for SuperUser
	@Override
	public List<SuperUserAddressesTypeResponseModel> getAllAddressesTypeList() {
		Iterable<AddressesTypeEntity> addressesTypeEntitys = addressesTypeRepository.findAll();
		List<AddressesTypeDTO> addressesTypeDTOs = new ArrayList<AddressesTypeDTO>();
		List<SuperUserAddressesTypeResponseModel> returnValue = new ArrayList<SuperUserAddressesTypeResponseModel>();
		ModelMapper modelMapper = new ModelMapper();
		for(AddressesTypeEntity addressesTypeEntity : addressesTypeEntitys) {
			AddressesTypeDTO addressesTypeDTO = new AddressesTypeDTO();
			addressesTypeDTO = modelMapper.map(addressesTypeEntity, AddressesTypeDTO.class);
			addressesTypeDTOs.add(addressesTypeDTO);
		}		
		for(AddressesTypeDTO addressesTypeDTO : addressesTypeDTOs) {
			SuperUserAddressesTypeResponseModel addressesType = new SuperUserAddressesTypeResponseModel();
			addressesType = modelMapper.map(addressesTypeDTO, SuperUserAddressesTypeResponseModel.class);
			returnValue.add(addressesType);
		}
		
		return returnValue;
	}
/*********************************************************************************************************************/

}
