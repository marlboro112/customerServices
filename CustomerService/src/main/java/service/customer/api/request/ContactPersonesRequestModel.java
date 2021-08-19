package service.customer.api.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ContactPersonesRequestModel {
	
	private String fullName;
	private String phoneNumber;
	private String mobileNumber;
	private String email;
	private String position;
	private String description;
	private String logedInUserPublicId;
	private String customerPublicId;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLogedInUserPublicId() {
		return logedInUserPublicId;
	}
	public void setLogedInUserPublicId(String logedInUserPublicId) {
		this.logedInUserPublicId = logedInUserPublicId;
	}
	public String getCustomerPublicId() {
		return customerPublicId;
	}
	public void setCustomerPublicId(String customerPublicId) {
		this.customerPublicId = customerPublicId;
	}
	
	
}
