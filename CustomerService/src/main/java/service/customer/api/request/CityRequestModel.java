package service.customer.api.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CityRequestModel {
	
	private String cityName;
	private String description;
	private String logedInUserPublicId;
	private String countryPublicId;
	
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
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
	public String getCountryPublicId() {
		return countryPublicId;
	}
	public void setCountryPublicId(String countryPublicId) {
		this.countryPublicId = countryPublicId;
	}
	
	

}
