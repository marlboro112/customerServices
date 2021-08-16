package service.customer.api.request;

public class CustomerUpdateRequestModel {
	
	private String customerName;
	private String description;
	private Boolean enabled;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
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
		CustomerUpdateRequestModel other = (CustomerUpdateRequestModel) obj;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CustomerUpdateRequestModel [customerName=" + customerName + ", description=" + description
				+ ", enabled=" + enabled + "]";
	}
	public CustomerUpdateRequestModel(String customerName, String description, Boolean enabled) {
		super();
		this.customerName = customerName;
		this.description = description;
		this.enabled = enabled;
	}
	public CustomerUpdateRequestModel() {
		super();
	}
	
	

}
