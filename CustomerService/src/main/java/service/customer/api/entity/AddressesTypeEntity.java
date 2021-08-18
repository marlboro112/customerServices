package service.customer.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "AddressesType")
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AddressesTypeEntity extends BaseEntity {

	private static final long serialVersionUID = 6757751530246647755L;
	
	@Column(name = "name", length = 250, nullable = false, unique = true)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
