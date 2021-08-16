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
public class CustomerDTO extends BaseDTO {

	private static final long serialVersionUID = 4501159034067295285L;
	
	private String customerName;
	private List<AddressesDTO> addresses;
	private List<ContactPersonesDTO> contactPersones;

}
