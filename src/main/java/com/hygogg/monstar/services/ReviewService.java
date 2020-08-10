package com.hygogg.monstar.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hygogg.monstar.models.Review;
import com.hygogg.monstar.repositories.ReviewRepository;


@Service
public class ReviewService {
	
	private final ReviewRepository reviewRepo;
	
	public ReviewService(ReviewRepository reviewRepo) {
		this.reviewRepo = reviewRepo;
	}
	
	// return null if a review already exists for this user and this drink
	public Review create(Review r) {
		List<Review> matches = reviewRepo.findMatchingReviews(r.getUser().getId(), r.getDrink().getId());
		if(matches.size() > 0) {
			return null;
		}
		return reviewRepo.save(r);
	}

}
