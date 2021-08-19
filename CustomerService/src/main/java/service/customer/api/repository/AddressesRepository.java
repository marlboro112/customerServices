package service.customer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import service.customer.api.entity.AddressesEntity;

@Repository
public interface AddressesRepository extends JpaRepository<AddressesEntity, Long> {
	

}
