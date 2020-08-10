package com.hygogg.monstar.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hygogg.monstar.models.Review;


public interface ReviewRepository extends CrudRepository<Review, Long> {
	
	@Query(value="SELECT * FROM reviews WHERE user_id = ?1 and drink_id = ?2", nativeQuery=true)
	List<Review> findMatchingReviews(Long user_id, Long drink_id);
	
}
