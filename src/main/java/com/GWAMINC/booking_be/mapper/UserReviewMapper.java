package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.user_review.UserReviewCreate;
import com.GWAMINC.booking_be.dto.user_review.UserReviewResponse;
import com.GWAMINC.booking_be.dto.user_review.UserReviewUpdate;
import com.GWAMINC.booking_be.entity.UserReview;

public class UserReviewMapper {
    public static UserReview createToEntity(UserReviewCreate create) {
        return UserReview.builder()
                .comment(create.getComment())
                .overallRating(create.getOverallRating())
                .reviewDate(create.getReviewDate())
                .build();
    }

    public static void updateToEntity(UserReview entity, UserReviewUpdate update) {
        if (update.getComment() != null) {
            entity.setComment(update.getComment());
        }
        if (update.getOverallRating() != null) {
            entity.setOverallRating(update.getOverallRating());
        }
    }

    public static UserReviewResponse entityToResponse(UserReview entity) {
        return UserReviewResponse.builder()
                .id(entity.getId())
                .comment(entity.getComment())
                .overallRating(entity.getOverallRating())
                .user(entity.getUser())
                .property(entity.getProperty())
                .reviewDate(entity.getReviewDate())
                .build();
    }
}
