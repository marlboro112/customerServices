package service.customer.api.response;

import java.util.List;

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
public class CustomerDetailsResponseModel {
	
	private String publicId;
	private String customerName;
	private String description;
	private Boolean enabled;
	private List<AddressesResponseModel> addresses;
	private List<ContactPersonesResponseModel> contactPersones;

}
