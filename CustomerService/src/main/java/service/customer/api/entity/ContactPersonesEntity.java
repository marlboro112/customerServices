package service.customer.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "ContactPersones")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ContactPersonesEntity extends BaseEntity {

	private static final long serialVersionUID = -8978700084998791272L;
	
	@Column(name = "fullName", length = 100, nullable = false)
	private String fullName;

	@Column(name = "phoneNumber", length = 100, nullable = false)
	private String phoneNumber;

	@Column(name = "mobileNumber", length = 100, nullable = false)
	private String mobileNumber;

	@Column(name = "email", length = 150, nullable = false)
	private String email;

	@Column(name = "position", length = 150, nullable = false)
	private String position;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
	

}
