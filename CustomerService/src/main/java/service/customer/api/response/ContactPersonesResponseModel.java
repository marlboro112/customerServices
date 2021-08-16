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
public class ContactPersonesResponseModel {
	
	private String publicId;
	private String fullName;
	private String phoneNumber;
	private String mobileNumber;
	private String email;
	private String position;
	private String description;

}
