package com.inditex.endpoint.domain.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.inditex.endpoint.domain.entities.Price;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	
	// Retrieve the Price matching with passed parameters from the persistence layer
	@Query("select p from Price p  " +
			"where ?1 >= p.start_date " +
			"and ?1 <= p.end_date " +
			"and p.product_id = ?2 " +
			"and p.brand_id = ?3 " +
			"order by p.priority")
	Optional<Price> findPrice(LocalDateTime applicationDate, Integer productId, Integer brandId);

}
