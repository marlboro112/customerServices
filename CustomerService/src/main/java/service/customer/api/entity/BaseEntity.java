package service.customer.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -9179911404260638814L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "publicId", length = 255, nullable = false, unique = true)
	private UUID publicId;

	@Column(name = "description", length = 250)
	private String description;

	@Column(name = "createdBy", length = 255, nullable = false)
	private String createdBy;

	@Column(name = "created", length = 30, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "modifiedBy", length = 255, nullable = false)
	private String modifiedBy;

	@Column(name = "modified", length = 30, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@Column(name = "deleted", length = 10, nullable = false, columnDefinition = "BOOLEAN")
	private Boolean deleted;

	@Column(name = "deletedBy", length = 255)
	private String deletedBy;

	@Column(name = "enabled", length = 10, nullable = false, columnDefinition = "BOOLEAN")
	private Boolean enabled;

	@Version
	@Column(name = "version", nullable = false, columnDefinition = "integer DEFAULT 0")
	private Long version;

}
