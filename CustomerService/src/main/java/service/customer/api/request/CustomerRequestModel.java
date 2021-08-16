package service.customer.api.request;

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
public class CustomerRequestModel {
	
	private String customerName;
	private String description;
	private List<AddressRequestModel> addresses;
	private List<ContactPersonRequestModel> contactPersones;

}
