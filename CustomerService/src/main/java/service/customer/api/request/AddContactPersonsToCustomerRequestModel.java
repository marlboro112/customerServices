package service.customer.api.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddContactPersonsToCustomerRequestModel {
	
	private String customerPublicId;
	private List<ContactPersonesRequestModel> contactPersons;
	
	public String getCustomerPublicId() {
		return customerPublicId;
	}
	public void setCustomerPublicId(String customerPublicId) {
		this.customerPublicId = customerPublicId;
	}
	public List<ContactPersonesRequestModel> getContactPersons() {
		return contactPersons;
	}
	public void setContactPersons(List<ContactPersonesRequestModel> contactPersons) {
		this.contactPersons = contactPersons;
	}
	
	
	

}
