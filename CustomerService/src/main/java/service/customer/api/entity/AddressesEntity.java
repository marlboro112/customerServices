package service.customer.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Addresses")
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AddressesEntity extends BaseEntity {

	private static final long serialVersionUID = 7744649654492846505L;
	
	@Column(name = "streetName", length = 250, nullable = false)
	private String streetName;

	@Column(name = "postCode", length = 15, nullable = false)
	private String postCode;

	@OneToOne
	@JoinColumn(name = "type_id")
	private AddressesTypeEntity type;

	@OneToOne
	@JoinColumn(name = "city_id")
	private CityEntity city;

	@OneToOne
	@JoinColumn(name = "country_id")
	private CountryEntity country;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private CustomerEntity customer;

}
