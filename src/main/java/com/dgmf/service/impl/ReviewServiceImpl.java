package com.dgmf.service.impl;

import com.dgmf.entity.Company;
import com.dgmf.entity.Review;
import com.dgmf.repository.ReviewRepository;
import com.dgmf.service.CompanyService;
import com.dgmf.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    @Override
    public List<Review> getAllReviewsByCompanyId(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReviewByCompanyId(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);

        if(company != null) {
            review.setCompany(company);
            reviewRepository.save(review);

            return true;
        }

        return false;
    }

    @Override
    public Review getReviewByCompanyId(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReviewByCompanyId(
            Long companyId, Long reviewId, Review review
    ) {
        Company company = companyService.getCompanyById(companyId);

        if(company != null) {
            review.setCompany(company);
            review.setId(reviewId);
            reviewRepository.save(review);

            return true;
        }

        return false;
    }

    @Override
    public boolean deleteReviewByCompanyId(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) != null
                && reviewRepository.existsById(reviewId)
        ) {
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            // Remove all the Bidirectional References Between Review and Company
            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompanyById(companyId, company);

            // Finally, Delete the Review from the DB
            reviewRepository.deleteById(reviewId);

            return true;
        }
        return false;
    }
}
