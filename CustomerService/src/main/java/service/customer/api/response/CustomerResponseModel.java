package service.customer.api.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerResponseModel {
	
	private String publicId;
	private String customerName;
	private String description;
	private Boolean enabled;
	
	
	public String getPublicId() {
		return publicId;
	}
	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}
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
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
