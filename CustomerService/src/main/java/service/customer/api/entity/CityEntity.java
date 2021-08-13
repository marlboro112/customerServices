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
@Table(name = "City")
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CityEntity extends BaseEntity {

	private static final long serialVersionUID = -2233276274843147499L;
	
	@Column(name = "cityName", length = 250, nullable = false, unique = true)
	private String cityName;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private CountryEntity country;

}
