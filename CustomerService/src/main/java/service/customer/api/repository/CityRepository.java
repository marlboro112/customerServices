package service.customer.api.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import service.customer.api.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
	
	CityEntity findCityByPublicId (String publicId);
	CityEntity findByCityName (String cityName);
	
	@Query("SELECT c FROM CityEntity c WHERE c.country.id = :countryId and c.deleted = false")
	Collection<CityEntity> getActiveCityListByCountry(@Param ("countryId") Long countryId);
	
	@Query("SELECT c FROM CityEntity c WHERE c.country.id = :countryId")
	Collection<CityEntity> getAllCityListByCountry(@Param ("countryId") Long countryId);

}
