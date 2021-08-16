package service.customer.api.dto;

import org.springframework.stereotype.Component;

@Component
public class AddressesTypeDTO extends BaseDTO {

	private static final long serialVersionUID = -7838460570095495906L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
