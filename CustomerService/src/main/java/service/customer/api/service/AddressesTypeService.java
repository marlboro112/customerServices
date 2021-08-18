package service.customer.api.service;

import service.customer.api.dto.AddressesTypeDTO;

public interface AddressesTypeService {

	 AddressesTypeDTO getAddressTypeByPublicId(String publicId);
	

}
