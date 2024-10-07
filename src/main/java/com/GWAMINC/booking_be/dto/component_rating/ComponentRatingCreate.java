package com.GWAMINC.booking_be.dto.component_rating;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ComponentRatingCreate {
    private Long id;
    private Long componentId;
    private Long reviewId;
    private Integer rating;
}
