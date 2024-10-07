package com.GWAMINC.booking_be.service;

import com.GWAMINC.booking_be.dto.component_rating.ComponentRatingCreate;
import com.GWAMINC.booking_be.dto.component_rating.ComponentRatingResponse;
import com.GWAMINC.booking_be.dto.component_rating.ComponentRatingUpdate;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentCreate;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentResponse;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentUpdate;
import com.GWAMINC.booking_be.dto.user_review.UserReviewCreate;
import com.GWAMINC.booking_be.dto.user_review.UserReviewResponse;
import com.GWAMINC.booking_be.dto.user_review.UserReviewUpdate;

import java.util.List;

public interface UserReviewService {
    UserReviewResponse createUserReview(UserReviewCreate userReviewCreate);
    UserReviewResponse getUserReviewById(long id);
    UserReviewResponse updateUserReview(long id, UserReviewUpdate userReviewUpdate);
    void deleteUserReview(long id);
    List<UserReviewResponse> listUserReviews();


    ReviewComponentResponse createReviewComponent(ReviewComponentCreate reviewComponentCreate);
    ReviewComponentResponse updateReviewComponent(Long id, ReviewComponentUpdate reviewComponentUpdate);
    ReviewComponentResponse getReviewComponentById(Long id);
    void deleteReviewComponentById(Long id);
    List<ReviewComponentResponse> listReviewComponent();

    ComponentRatingResponse createComponentRating(ComponentRatingCreate componentRatingCreate);
    ComponentRatingResponse updateComponentRating(Long id, ComponentRatingUpdate componentRatingUpdate);
    ComponentRatingResponse getComponentRatingById(Long id);
    void deleteComponentRatingById(Long id);
    List<ComponentRatingResponse> listComponentRating();
}
