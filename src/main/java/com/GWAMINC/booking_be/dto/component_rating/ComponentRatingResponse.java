package com.GWAMINC.booking_be.dto.component_rating;

import com.GWAMINC.booking_be.dto.review_component.ReviewComponentResponse;
import com.GWAMINC.booking_be.dto.user_review.UserReviewResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComponentRatingResponse {
    private Long id;
    private ReviewComponentResponse reviewComponent;
    private UserReviewResponse userReview;
    private Integer rating;
}
