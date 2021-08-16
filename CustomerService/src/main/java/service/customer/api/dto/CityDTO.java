package service.customer.api.dto;

import org.springframework.stereotype.Component;

@Component
public class CityDTO extends BaseDTO {

	private static final long serialVersionUID = 2188210647881530085L;
	
	private String cityName;
	private CountryDTO country;
	private AddressesDTO addresses;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public CountryDTO getCountry() {
		return country;
	}
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
	public AddressesDTO getAddresses() {
		return addresses;
	}
	public void setAddresses(AddressesDTO addresses) {
		this.addresses = addresses;
	}
	
	
}
