package service.customer.api.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerRequestModel {
	
	private String customerName;
	private String taxIDorPIN;
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
	public String getTaxIDorPIN() {
		return taxIDorPIN;
	}
	public void setTaxIDorPIN(String taxIDorPIN) {
		this.taxIDorPIN = taxIDorPIN;
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
