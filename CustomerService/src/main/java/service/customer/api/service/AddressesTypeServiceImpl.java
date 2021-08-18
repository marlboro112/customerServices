package service.customer.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import service.customer.api.dto.AddressesTypeDTO;
import service.customer.api.entity.AddressesTypeEntity;
import service.customer.api.repository.AddressesTypeRepository;

@Service
public class AddressesTypeServiceImpl implements AddressesTypeService {

	@Autowired
	AddressesTypeRepository addressesTypeRepositroy;

/**************************************************************************************************************************/
	
	// Get Addresses Type by public id and return as DTO for internal use
	@Override
	public AddressesTypeDTO getAddressTypeByPublicId(String publicId) {
	
		AddressesTypeEntity addressesTypeEntity = addressesTypeRepositroy.findAddressesTypeByPublicId(publicId);
		if(addressesTypeEntity == null || addressesTypeEntity.getDeleted() == true) throw new RuntimeException(publicId);
		Gson gson = new Gson();
		String temp = gson.toJson(addressesTypeEntity);
		AddressesTypeDTO addressesTypeDTO = gson.fromJson(temp,AddressesTypeDTO.class);
		return 	addressesTypeDTO;	
	}
	
/****************************************************************************************************************************/

	

}
