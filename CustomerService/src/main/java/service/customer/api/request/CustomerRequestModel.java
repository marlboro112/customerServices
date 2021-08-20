package service.customer.api.request;

import java.util.List;


public class CustomerRequestModel {
	
	private String customerName;
	private String description;
	private String logedInUserPublicId;
	private List<AddressesRequestModel> addresses;
	private List<ContactPersonesRequestModel> contactPersones;
	
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
	public List<AddressesRequestModel> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressesRequestModel> addresses) {
		this.addresses = addresses;
	}
	public List<ContactPersonesRequestModel> getContactPersones() {
		return contactPersones;
	}
	public void setContactPersones(List<ContactPersonesRequestModel> contactPersones) {
		this.contactPersones = contactPersones;
	}
	public String getLogedInUserPublicId() {
		return logedInUserPublicId;
	}
	public void setLogedInUserPublicId(String logedInUserPublicId) {
		this.logedInUserPublicId = logedInUserPublicId;
	}
	
	
	

}
