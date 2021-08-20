package service.customer.api.service;

import org.springframework.stereotype.Service;

import service.customer.api.dto.AddressesTypeDTO;
import service.customer.api.request.AddressesTypeRequestModel;
import service.customer.api.response.AddressesTypeResponseModel;

@Service
public interface AddressesTypeService {

	 AddressesTypeDTO getAddressTypeByPublicId(String publicId);
	 AddressesTypeResponseModel addAddressesType (AddressesTypeRequestModel type);

}
