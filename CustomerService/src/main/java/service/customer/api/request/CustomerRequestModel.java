package service.customer.api.request;

import java.util.List;


public class CustomerRequestModel {
	
	private String customerName;
	private String description;
	private String LogedInUserPublicId;
	private List<AddressRequestModel> addresses;
	private List<ContactPersonRequestModel> contactPersones;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogedInUserPublicId() {
		return LogedInUserPublicId;
	}
	public void setLogedInUserPublicId(String logedInUserPublicId) {
		LogedInUserPublicId = logedInUserPublicId;
	}
	public List<AddressRequestModel> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressRequestModel> addresses) {
		this.addresses = addresses;
	}
	public List<ContactPersonRequestModel> getContactPersones() {
		return contactPersones;
	}
	public void setContactPersones(List<ContactPersonRequestModel> contactPersones) {
		this.contactPersones = contactPersones;
	}
	
	
	

}
