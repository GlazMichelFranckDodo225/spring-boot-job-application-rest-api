package com.dgmf.controller;

import com.dgmf.entity.Review;
import com.dgmf.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies/{companyId}/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    // Get All Reviews By Company Id REST API
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviewsByCompanyId(
            @PathVariable("companyId") Long companyId
    ) {
        return ResponseEntity.ok(reviewService.getAllReviewsByCompanyId(companyId));
    }

    // Add Review By Company Id REST API
    @PostMapping
    public ResponseEntity<String> addReviewByCompanyId(
            @PathVariable("companyId") Long companyId,
            @RequestBody Review review
    ) {
        boolean isReviewSaved = reviewService.addReviewByCompanyId(companyId, review);

        if(isReviewSaved) {
            return new ResponseEntity<>(
                    "Review Added Successfully", HttpStatus.CREATED
            );
        }

        return new ResponseEntity<>(
                "Review Not Saved", HttpStatus.NOT_FOUND
        );

    }

    // Get Review By Company Id REST API
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewByCompanyId(
            @PathVariable("companyId") Long companyId,
            @PathVariable("reviewId") Long reviewId
    ) {
        Review review = reviewService.getReviewByCompanyId(companyId, reviewId);

        if(review == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(review);
    }

    // Update Review By Company Id REST API
    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReviewByCompanyId(
            @PathVariable("companyId") Long companyId,
            @PathVariable("reviewId") Long reviewId,
            @RequestBody Review review
    ) {
        boolean isReviewUpdated = reviewService.updateReviewByCompanyId(
                companyId, reviewId, review
        );

        if(isReviewUpdated) {
            return ResponseEntity.ok("Review Updated Successfully");
        }

        return new ResponseEntity<>(
                "Review Not Updated", HttpStatus.NOT_FOUND
        );

    }

    // Delete Review By Company Id REST API
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(
            @PathVariable("companyId") Long companyId,
            @PathVariable("reviewId") Long reviewId
    ) {
        boolean isReviewDeleted = reviewService.deleteReviewByCompanyId(
                companyId, reviewId
        );

        if(isReviewDeleted) {
            return ResponseEntity.ok("Review Deleted Successfully");
        }

        return new ResponseEntity<>(
                "Review Not Deleted", HttpStatus.NOT_FOUND
        );
    }
}
