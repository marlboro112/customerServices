package service.customer.api.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerDTO extends BaseDTO {

	private static final long serialVersionUID = 4501159034067295285L;
	
	private String customerName;
	private List<AddressesDTO> addresses;
	private List<ContactPersonesDTO> contactPersones;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<AddressesDTO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressesDTO> addresses) {
		this.addresses = addresses;
	}
	public List<ContactPersonesDTO> getContactPersones() {
		return contactPersones;
	}
	public void setContactPersones(List<ContactPersonesDTO> contactPersones) {
		this.contactPersones = contactPersones;
	}
	
}
