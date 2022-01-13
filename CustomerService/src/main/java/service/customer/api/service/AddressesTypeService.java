package service.customer.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import service.customer.api.dto.AddressesTypeDTO;
import service.customer.api.request.AddressesTypeRequestModel;
import service.customer.api.response.AddressesTypeResponseModel;
import service.customer.api.response.SuperUserAddressesTypeResponseModel;

@Service
public interface AddressesTypeService {

	//Get AddressesType by publicId and return DTO for internal use
	AddressesTypeDTO getAddressTypeByPublicId(String publicId);
	//Add new AddressesType info
	AddressesTypeResponseModel addAddressesType (AddressesTypeRequestModel type);
	//Delete AddressesType by publicId
    Boolean deleteAddressesType(String publicId, String logedInUserPublicId);
	//Disable AddressesType by publicId
    Boolean disableAddressesType(String publicId, String logedInUserPublicId);
	//Enable AddressesType by publicId
    Boolean enableAddressesType(String publicId, String logedInUserPublicId);
	//Update Country info by publicId
	AddressesTypeResponseModel updateAddressesType(AddressesTypeRequestModel type, String publicId);
	// Get Active AddressesType List
	List<AddressesTypeResponseModel> getAddressesTypeList();
	// Get All AddressesType Llist for SuperUser
	List<SuperUserAddressesTypeResponseModel> getAllAddressesTypeList();


}
