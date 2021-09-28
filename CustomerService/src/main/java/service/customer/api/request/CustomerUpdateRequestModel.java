package service.customer.api.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerUpdateRequestModel {
	
	private String logedInUserPublicId;
	private String customerName;
	private String description;
	private Boolean enabled;
	
	
	public String getLogedInUserPublicId() {
		return logedInUserPublicId;
	}
	public void setLogedInUserPublicId(String logedInUserPublicId) {
		this.logedInUserPublicId = logedInUserPublicId;
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
