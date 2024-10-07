package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.review_component.ReviewComponentCreate;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentResponse;
import com.GWAMINC.booking_be.dto.review_component.ReviewComponentUpdate;
import com.GWAMINC.booking_be.entity.ReviewComponent;

public class ReviewComponentMapper {
    public static ReviewComponent createToEntity(ReviewComponentCreate create) {
        return ReviewComponent.builder()
                .componentName(create.getComponentName())
                .build();
    }

    public static ReviewComponentResponse entityToResponse(ReviewComponent entity) {
        return ReviewComponentResponse.builder()
                .id(entity.getId())
                .componentName(entity.getComponentName())
                .build();
    }

    public static void updateToEntity(ReviewComponent entity, ReviewComponentUpdate update) {
        if (update.getComponentName() != null) {
            entity.setComponentName(update.getComponentName());
        }
    }
}
