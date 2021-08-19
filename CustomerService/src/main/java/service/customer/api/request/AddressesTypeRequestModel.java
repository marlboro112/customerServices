package service.customer.api.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class AddressesTypeRequestModel {
	
	private String name;
	private String description;
	private String logedInUserPublicId;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogedInUserPublicId() {
		return logedInUserPublicId;
	}

	public void setLogedInUserPublicId(String logedInUserPublicId) {
		this.logedInUserPublicId = logedInUserPublicId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
