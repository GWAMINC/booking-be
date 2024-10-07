package com.GWAMINC.booking_be.dto.user_review;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserReviewUpdate {
    private String comment;
    private Integer overallRating;
}
