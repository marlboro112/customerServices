package service.customer.api.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import service.customer.api.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	CustomerEntity findByPublicId (String piblicId);
	CustomerEntity findByCustomerName(String customerName);
	@Query("SELECT c FROM CustomerEntity c WHERE c.deleted = false ")
	Collection<CustomerEntity> findAllActiveCustomers();

}
