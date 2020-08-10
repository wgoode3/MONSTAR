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
	
	// return true if a review already exists for this user and this drink
	public Boolean reviewExists(Review r) {
		List<Review> matches = reviewRepo.findMatchingReviews(r.getUser().getId(), r.getDrink().getId());
		return matches.size() > 0;
	}
	
	public Review create(Review r) {
		return reviewRepo.save(r);
	}

}
