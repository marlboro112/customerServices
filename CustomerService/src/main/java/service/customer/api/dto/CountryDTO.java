package service.customer.api.dto;

import java.util.List;

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
public class CountryDTO extends BaseDTO {

	private static final long serialVersionUID = 361840965165560370L;
	
	private String countryName;
	private List<CityDTO> cities;
	private AddressesDTO addresses;

}
