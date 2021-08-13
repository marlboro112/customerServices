package service.customer.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Customer")
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CustomerEntity extends BaseEntity {

	private static final long serialVersionUID = -739362568570612378L;
	
	@Column(name = "customerName", length = 250, nullable = false, unique = true)
	private String customerName;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<ContactPersonesEntity> contactPersones;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<AddressesEntity> addresses;

}
