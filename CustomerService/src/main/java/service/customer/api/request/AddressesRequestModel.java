package service.customer.api.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressesRequestModel {
	
	private String streetName;
	private String postCode;
	private String cityPublicId;
	private String countryPublicId;
	private String typePublicId;
	private String description;
	private String logedInUserPublicId;
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCityPublicId() {
		return cityPublicId;
	}
	public void setCityPublicId(String cityPublicId) {
		this.cityPublicId = cityPublicId;
	}
	public String getCountryPublicId() {
		return countryPublicId;
	}
	public void setCountryPublicId(String countryPublicId) {
		this.countryPublicId = countryPublicId;
	}
	public String getTypePublicId() {
		return typePublicId;
	}
	public void setTypePublicId(String typePublicId) {
		this.typePublicId = typePublicId;
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
	
	
}
