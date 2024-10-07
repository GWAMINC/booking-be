package com.GWAMINC.booking_be.dto.user_review;

import com.GWAMINC.booking_be.entity.Property;
import com.GWAMINC.booking_be.entity.UserAccount;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserReviewResponse {
    private Long id;
    private Property property;
    private UserAccount user;
    private Integer overallRating;
    private String comment;
    private Date reviewDate;
}
