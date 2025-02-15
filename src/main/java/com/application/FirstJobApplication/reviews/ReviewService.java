package com.application.FirstJobApplication.reviews;

import java.util.List;


public interface ReviewService {

    boolean addReview( Review review, Long companyId);
    List<Review> getAllReviews(Long companyId);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review review);
    boolean deletedReview(Long companyId, Long reviewId);
}
