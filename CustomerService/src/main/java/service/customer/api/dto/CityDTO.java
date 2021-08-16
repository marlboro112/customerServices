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
public class CityDTO extends BaseDTO {

	private static final long serialVersionUID = 2188210647881530085L;
	
	private String cityName;
	private CountryDTO country;
	private AddressesDTO addresses;
	

}
