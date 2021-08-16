package service.customer.api.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CountryDTO extends BaseDTO {

	private static final long serialVersionUID = 361840965165560370L;
	
	private String countryName;
	private List<CityDTO> cities;
	private AddressesDTO addresses;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<CityDTO> getCities() {
		return cities;
	}
	public void setCities(List<CityDTO> cities) {
		this.cities = cities;
	}
	public AddressesDTO getAddresses() {
		return addresses;
	}
	public void setAddresses(AddressesDTO addresses) {
		this.addresses = addresses;
	}
	
}
