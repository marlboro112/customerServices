package service.customer.api.response;

import java.util.Date;

public class SuperUserCountryResponseModel {

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
        private String countryName;
        
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getPublicId() {
            return publicId;
        }
        public void setPublicId(String publicId) {
            this.publicId = publicId;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getCreatedBy() {
            return createdBy;
        }
        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }
        public Date getCreated() {
            return created;
        }
        public void setCreated(Date created) {
            this.created = created;
        }
        public String getModifiedBy() {
            return modifiedBy;
        }
        public void setModifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
        }
        public Date getModified() {
            return modified;
        }
        public void setModified(Date modified) {
            this.modified = modified;
        }
        public Boolean getDeleted() {
            return deleted;
        }
        public void setDeleted(Boolean deleted) {
            this.deleted = deleted;
        }
        public String getDeletedBy() {
            return deletedBy;
        }
        public void setDeletedBy(String deletedBy) {
            this.deletedBy = deletedBy;
        }
        public Boolean getEnabled() {
            return enabled;
        }
        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }
        public Long getVersion() {
            return version;
        }
        public void setVersion(Long version) {
            this.version = version;
        }
        public String getCountryName() {
            return countryName;
        }
        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        
    
}
