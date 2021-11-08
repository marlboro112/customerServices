package service.customer.api.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddAddressToCustomerRequestModel {

	private String customerPublicId;	
	private List<AddressesRequestModel> addresses;
	
	public String getCustomerPublicId() {
		return customerPublicId;
	}
	public void setCustomerPublicId(String customerPublicId) {
		this.customerPublicId = customerPublicId;
	}
	public List<AddressesRequestModel> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressesRequestModel> addresses) {
		this.addresses = addresses;
	}
	
	
	
}
