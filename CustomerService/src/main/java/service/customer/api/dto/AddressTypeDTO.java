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
public class AddressTypeDTO extends BaseDTO {

	private static final long serialVersionUID = -7838460570095495906L;
	
	private String name;	

}
