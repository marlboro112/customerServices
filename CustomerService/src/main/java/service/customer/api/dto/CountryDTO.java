package service.customer.api.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CountryDTO extends BaseDTO {

	private static final long serialVersionUID = 361840965165560370L;
	
	private String countryName;
	private List<CityDTO> cities;
	
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
	
}
