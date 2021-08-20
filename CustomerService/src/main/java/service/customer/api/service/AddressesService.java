package service.customer.api.service;

import org.springframework.stereotype.Service;

import service.customer.api.dto.AddressesDTO;
import service.customer.api.request.AddressesRequestModel;
import service.customer.api.response.AddressesResponseModel;

@Service
public interface AddressesService {
	
	AddressesDTO getAddressesByPublicId (String publicId);
	AddressesResponseModel addAddresses (AddressesRequestModel addresses);
	

}
