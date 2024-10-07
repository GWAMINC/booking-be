package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.dto.review_component.ReviewComponentCreate;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentResponse;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentUpdate;
import com.GWAMINC.booking_be.service.UserReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review-component")
@RequiredArgsConstructor
public class ReviewComponentController {

    private final UserReviewService userReviewService;

    @PostMapping
    public ResponseEntity<ReviewComponentResponse> createReviewComponent(
            @RequestBody ReviewComponentCreate reviewComponentCreate
    ){
        return ResponseEntity.ok(userReviewService.createReviewComponent(reviewComponentCreate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewComponentResponse> getReviewComponentById(
            @PathVariable("id") Long id
    ){
        return ResponseEntity.ok(userReviewService.getReviewComponentById(id));
    }

    @GetMapping
    public ResponseEntity<List<ReviewComponentResponse>> getAllReviewComponent(){
        return ResponseEntity.ok(userReviewService.listReviewComponent());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewComponentResponse> updateReviewComponent(
            @RequestBody ReviewComponentUpdate reviewComponentUpdate,
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(userReviewService.updateReviewComponent(id, reviewComponentUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReviewComponent(
            @PathVariable Long id
    ) {
        userReviewService.deleteReviewComponentById(id);
        return ResponseEntity.ok("Delete successfully");
    }
}
