package service.customer.api.request;

public class AddressRequestModel {
	
	private String streetName;
	private String postCode;
	private String cityPublicId;
	private String countryPublicId;
	private String typePublicId;
	private String description;
	
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getCityPublicId() {
		return cityPublicId;
	}
	public void setCityPublicId(String cityPublicId) {
		this.cityPublicId = cityPublicId;
	}
	public String getCountryPublicId() {
		return countryPublicId;
	}
	public void setCountryPublicId(String countryPublicId) {
		this.countryPublicId = countryPublicId;
	}
	public String getTypePublicId() {
		return typePublicId;
	}
	public void setTypePublicId(String typePublicId) {
		this.typePublicId = typePublicId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityPublicId == null) ? 0 : cityPublicId.hashCode());
		result = prime * result + ((countryPublicId == null) ? 0 : countryPublicId.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((streetName == null) ? 0 : streetName.hashCode());
		result = prime * result + ((typePublicId == null) ? 0 : typePublicId.hashCode());
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
		AddressRequestModel other = (AddressRequestModel) obj;
		if (cityPublicId == null) {
			if (other.cityPublicId != null)
				return false;
		} else if (!cityPublicId.equals(other.cityPublicId))
			return false;
		if (countryPublicId == null) {
			if (other.countryPublicId != null)
				return false;
		} else if (!countryPublicId.equals(other.countryPublicId))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		if (typePublicId == null) {
			if (other.typePublicId != null)
				return false;
		} else if (!typePublicId.equals(other.typePublicId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AddressRequestModel [streetName=" + streetName + ", postCode=" + postCode + ", cityPublicId="
				+ cityPublicId + ", countryPublicId=" + countryPublicId + ", typePublicId=" + typePublicId
				+ ", description=" + description + "]";
	}
	public AddressRequestModel(String streetName, String postCode, String cityPublicId, String countryPublicId,
			String typePublicId, String description) {
		super();
		this.streetName = streetName;
		this.postCode = postCode;
		this.cityPublicId = cityPublicId;
		this.countryPublicId = countryPublicId;
		this.typePublicId = typePublicId;
		this.description = description;
	}
	public AddressRequestModel() {
		super();

	}
	
	

}
