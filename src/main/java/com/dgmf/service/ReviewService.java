package com.dgmf.service;

import com.dgmf.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviewsByCompanyId(Long companyId);
}
