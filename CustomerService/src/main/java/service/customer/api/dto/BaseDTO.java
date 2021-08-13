package service.customer.api.dto;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuppressWarnings("unused")
public class BaseDTO implements Serializable {

	private static final long serialVersionUID = -3187156760589320548L;
	
	
	private Long id;
	private String publicId;
	private String description;
	private String createdBy;
	private Date created;
	private String modifiedBy;
	private Date modified;
	private Boolean deleted;
	private String deletedBy;
	private Boolean enabled;
	private Long version;
	
	

}
