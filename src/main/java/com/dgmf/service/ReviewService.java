package com.dgmf.service;

import com.dgmf.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsByCompanyId(Long companyId);
    Boolean addReviewByCompanyId(Long companyId, Review review);
    Review getReviewByCompanyId(Long companyId, Long reviewId);
    Boolean updateReviewByCompanyId(
            Long companyId, Long reviewId, Review review
    );
}
