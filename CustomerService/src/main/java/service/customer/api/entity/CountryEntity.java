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
@Table(name = "Country")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CountryEntity extends BaseEntity {

 	private static final long serialVersionUID = 5014728347366907523L;
	@Column(name = "countryName", length = 250, nullable = false, unique = true)
	private String countryName;

	@OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
	private List<CityEntity> cities;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<CityEntity> getCities() {
		return cities;
	}

	public void setCities(List<CityEntity> cities) {
		this.cities = cities;
	}
	
	

}
