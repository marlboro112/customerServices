package service.customer.api.service;

import service.customer.api.dto.AddressesDTO;
import service.customer.api.request.AddressesRequestModel;
import service.customer.api.response.AddressesResponseModel;

public interface AddressesService {
	
	AddressesDTO getAddressesByPublicId (String publicId);
	AddressesResponseModel addAddresses (AddressesRequestModel addresses);
	

}
