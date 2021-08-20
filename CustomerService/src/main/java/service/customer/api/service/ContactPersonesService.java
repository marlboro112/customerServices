package service.customer.api.service;

import org.springframework.stereotype.Service;

import service.customer.api.dto.ContactPersonesDTO;
import service.customer.api.request.ContactPersonesRequestModel;
import service.customer.api.response.ContactPersonesResponseModel;

@Service
public interface ContactPersonesService {
	
	ContactPersonesDTO getContactPersonesByPublicId (String publicId);
	ContactPersonesResponseModel addContactPersones(ContactPersonesRequestModel contactPersones);

}
