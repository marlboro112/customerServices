package service.customer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import service.customer.api.entity.AddressesTypeEntity;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressesTypeEntity, Long> {

}
