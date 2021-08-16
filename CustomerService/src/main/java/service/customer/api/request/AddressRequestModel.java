package service.customer.api.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuppressWarnings("unused")
public class AddressRequestModel {
	
	private String streetName;
	private String postCode;
	private String cityPublicId;
	private String countryPublicId;
	private String typePublicId;
	private String description;

}
