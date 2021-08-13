package service.customer.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ContactPersones")
@Getter
@Setter
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

}
