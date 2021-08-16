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
public class ContactPersonesDTO extends BaseDTO {

	private static final long serialVersionUID = -7269099800861776756L;

	private String fullName;
	private String phoneNumber;
	private String mobileNumber;
	private String email;
	private String position;
	private CustomerDTO customer;
}
