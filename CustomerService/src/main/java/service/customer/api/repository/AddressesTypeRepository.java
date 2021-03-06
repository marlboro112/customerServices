package service.customer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import service.customer.api.entity.AddressesTypeEntity;

@Repository
public interface AddressesTypeRepository extends JpaRepository<AddressesTypeEntity, Long> {
	
	AddressesTypeEntity findByPublicId (String publicId);
	AddressesTypeEntity findByName (String type);
	@Query("SELECT c FROM AddressesTypeEntity c WHERE c.deleted = false ")
    Iterable<AddressesTypeEntity> findAllActiveAddressesType();

}
