package service.customer.api.service;

import service.customer.api.dto.ContactPersonesDTO;
import service.customer.api.request.ContactPersonesRequestModel;
import service.customer.api.response.ContactPersonesResponseModel;

public interface ContactPersonesService {
	
	ContactPersonesDTO getContactPersonesByPublicId (String publicId);
	ContactPersonesResponseModel addContactPersones(ContactPersonesRequestModel contactPersones);

}
