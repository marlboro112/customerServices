package service.customer.api.dto;

import org.springframework.stereotype.Component;

@Component
public class CountryDTO extends BaseDTO {

	private static final long serialVersionUID = 361840965165560370L;
	
	private String countryName;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
