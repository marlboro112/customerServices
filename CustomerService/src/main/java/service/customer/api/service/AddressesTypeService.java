package service.customer.api.service;

import service.customer.api.dto.AddressesTypeDTO;
import service.customer.api.request.AddressesTypeRequestModel;
import service.customer.api.response.AddressesTypeResponseModel;

public interface AddressesTypeService {

	 AddressesTypeDTO getAddressTypeByPublicId(String publicId);
	 AddressesTypeResponseModel addAddressesType (AddressesTypeRequestModel type);

}
