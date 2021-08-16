package service.customer.api.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuppressWarnings("unused")
public class AddressesDTO extends BaseDTO {
	
	private static final long serialVersionUID = 2098187008698763964L;
	
	private String streetName;
	private String postCode;
	private AddressTypeDTO type;
	private CityDTO city;
	private CountryDTO country;
	private CustomerDTO customer;

}
