package service.customer.api.response;

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
public class AddressesResponseModel {

	private String publicId;
	private String streetName;
	private String description;
	private String postCode;
	private String typeName;
	private String city;
	private String country;
}
