package com.GWAMINC.booking_be.dto.user_review;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
public class UserReviewCreate {
    private String comment;
    private Integer overallRating;
    private Long propertyId;
    private Long userId;
    private Date reviewDate;
}
