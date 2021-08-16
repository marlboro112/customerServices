package service.customer.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import service.customer.api.entity.ContactPersonesEntity;

@Repository
public interface ContactPersonesRepository extends JpaRepository<ContactPersonesEntity, Long> {

}
