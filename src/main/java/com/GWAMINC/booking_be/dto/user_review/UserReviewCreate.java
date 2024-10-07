package com.GWAMINC.booking_be.dto.user_review;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserReviewCreate {
    private String comment;
    private Integer overallRating;
    private Long propertyId;
    private Long userId;
}
