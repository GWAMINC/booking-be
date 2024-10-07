package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.dto.user_review.UserReviewCreate;
import com.GWAMINC.booking_be.dto.user_review.UserReviewResponse;
import com.GWAMINC.booking_be.dto.user_review.UserReviewUpdate;
import com.GWAMINC.booking_be.service.UserReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-review")
@RequiredArgsConstructor
public class UserReviewController {

    private final UserReviewService userReviewService;

    @GetMapping("/{id}")
    public ResponseEntity<UserReviewResponse> getUserReviewById(
            @PathVariable long id
    ) {
        return ResponseEntity.ok(userReviewService.getUserReviewById(id));
    }

    @PostMapping("/")
    public ResponseEntity<UserReviewResponse> createUserReview(
            @RequestBody UserReviewCreate userReviewCreate
    ) {
        return ResponseEntity.ok(userReviewService.createUserReview(userReviewCreate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserReviewResponse> updateUserReview(
            @PathVariable long id,
            @RequestBody UserReviewUpdate userReviewUpdate
    ) {
        return ResponseEntity.ok(userReviewService.updateUserReview(id, userReviewUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserReview(
            @PathVariable long id
    ) {
        userReviewService.deleteUserReview(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @GetMapping("/")
    public ResponseEntity<List<UserReviewResponse>> getUserReviews() {
        return ResponseEntity.ok(userReviewService.listUserReviews());
    }


}
