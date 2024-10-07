package com.GWAMINC.booking_be.dto.review_component;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewComponentCreate {
    public String componentName;
}
