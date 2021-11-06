package service.customer.api.response;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SuperUserCustomerResponseModel {
	
	private Long id;
	private String publicId;
	private String customerName;
	private String description;
	private String createdBy;
	private Date created;
	private String modifiedBy;
	private Date modified;
	private Boolean deleted;
	private String deletedBy;
	private Boolean enabled;
	private Long version;
	private List<SuperUserAddressesResponseModel> addresses;
	private List<SuperUserContactPersonesResponseModel> contactPersones;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPublicId() {
		return publicId;
	}
	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}
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
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	public String getDeletedBy() {
		return deletedBy;
	}
	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public List<SuperUserAddressesResponseModel> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<SuperUserAddressesResponseModel> addresses) {
		this.addresses = addresses;
	}
	public List<SuperUserContactPersonesResponseModel> getContactPersones() {
		return contactPersones;
	}
	public void setContactPersones(List<SuperUserContactPersonesResponseModel> contactPersones) {
		this.contactPersones = contactPersones;
	}
	
	

}
