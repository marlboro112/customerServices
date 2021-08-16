package service.customer.api.dto;

import org.springframework.stereotype.Component;

@Component
public class AddressesDTO extends BaseDTO {
	
	private static final long serialVersionUID = 2098187008698763964L;
	
	private String streetName;
	private String postCode;
	private AddressesTypeDTO type;
	private CityDTO city;
	private CountryDTO country;
	private CustomerDTO customer;
	
	
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
	public AddressesTypeDTO getType() {
		return type;
	}
	public void setType(AddressesTypeDTO type) {
		this.type = type;
	}
	public CityDTO getCity() {
		return city;
	}
	public void setCity(CityDTO city) {
		this.city = city;
	}
	public CountryDTO getCountry() {
		return country;
	}
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	

}
