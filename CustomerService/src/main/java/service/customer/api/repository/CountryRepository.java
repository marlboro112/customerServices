package service.customer.api.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import service.customer.api.entity.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
	
	CountryEntity findByPublicId(String publicId);
	CountryEntity findByCountryName(String countryName); 
	
	@Query("SELECT c FROM CountryEntity c WHERE c.deleted = false ")
	Collection<CountryEntity> findAllActiveCountry();

}
