package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.component_rating.ComponentRatingCreate;
import com.GWAMINC.booking_be.dto.component_rating.ComponentRatingResponse;
import com.GWAMINC.booking_be.dto.component_rating.ComponentRatingUpdate;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentCreate;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentResponse;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentUpdate;
import com.GWAMINC.booking_be.entity.ComponentRating;
import com.GWAMINC.booking_be.entity.ReviewComponent;

public class ComponentRatingMapper {
    public static ComponentRating createToEntity(ComponentRatingCreate create) {
        return ComponentRating.builder()
                .rating(create.getRating())
                .build();
    }

    public static ComponentRatingResponse entityToResponse(ComponentRating entity) {
        return ComponentRatingResponse.builder()
                .rating(entity.getRating())
                .reviewComponent(ReviewComponentMapper.entityToResponse(entity.getComponent()))
                .userReview(UserReviewMapper.entityToResponse(entity.getReview()))
                .build();
    }

    public static void updateToEntity(ComponentRating entity, ComponentRatingUpdate update) {
        if(update.getRating() != null) {
            entity.setRating(update.getRating());
        }
    }
}
