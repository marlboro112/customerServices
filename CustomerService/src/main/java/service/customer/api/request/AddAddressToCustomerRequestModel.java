package service.customer.api.request;

public class AddAddressToCustomerRequestModel {

	private String customerPublicId;	
	private AddressRequestModel address;
	
	public String getCustomerPublicId() {
		return customerPublicId;
	}
	public void setCustomerPublicId(String customerPublicId) {
		this.customerPublicId = customerPublicId;
	}
	public AddressRequestModel getAddress() {
		return address;
	}
	public void setAddress(AddressRequestModel address) {
		this.address = address;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((customerPublicId == null) ? 0 : customerPublicId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddAddressToCustomerRequestModel other = (AddAddressToCustomerRequestModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (customerPublicId == null) {
			if (other.customerPublicId != null)
				return false;
		} else if (!customerPublicId.equals(other.customerPublicId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AddAddressToCustomerRequestModel [customerPublicId=" + customerPublicId + ", address=" + address + "]";
	}
	public AddAddressToCustomerRequestModel(String customerPublicId, AddressRequestModel address) {
		super();
		this.customerPublicId = customerPublicId;
		this.address = address;
	}
	public AddAddressToCustomerRequestModel() {
		super();
	}
	
	
	
	
	
}
