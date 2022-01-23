package service.customer.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "Customer")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerEntity extends BaseEntity {

	private static final long serialVersionUID = -739362568570612378L;
	
	@Column(name = "customerName", length = 250, nullable = false, unique = true)
	private String customerName;
	
	@Column(name = "taxIDorPIN", length = 250, nullable = false, unique = true)
	private String taxIDorPIN;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<ContactPersonesEntity> contactPersones;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<AddressesEntity> addresses;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTaxIDorPIN() {
		return taxIDorPIN;
	}

	public void setTaxIDorPIN(String taxIDorPIN) {
		this.taxIDorPIN = taxIDorPIN;
	}

	public List<ContactPersonesEntity> getContactPersones() {
		return contactPersones;
	}

	public void setContactPersones(List<ContactPersonesEntity> contactPersones) {
		this.contactPersones = contactPersones;
	}

	public List<AddressesEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressesEntity> addresses) {
		this.addresses = addresses;
	}
	
	

}
