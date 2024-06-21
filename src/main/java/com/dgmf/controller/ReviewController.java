package com.dgmf.controller;

import com.dgmf.entity.Review;
import com.dgmf.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies/{companyId}")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    // Get All Reviews By Company Id REST API
    @GetMapping("reviews")
    public ResponseEntity<List<Review>> getAllReviewsByCompanyId(
            @PathVariable("companyId") Long companyId
    ) {
        return ResponseEntity.ok(reviewService.getAllReviewsByCompanyId(companyId));
    }
}
