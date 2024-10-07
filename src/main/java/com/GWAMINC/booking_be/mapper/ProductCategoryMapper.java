package com.GWAMINC.booking_be.mapper;

import com.GWAMINC.booking_be.dto.ProductCategoryDto;
import com.GWAMINC.booking_be.entity.ProductCategory;

public class ProductCategoryMapper {
    public static ProductCategoryDto mapToDto(ProductCategory productCategory) {
        return new ProductCategoryDto(
                productCategory.getId(),
                PropertyMapper.mapToDto(productCategory.getProperty()),
                CategoryMapper.mapToDto(productCategory.getCategory()));
    }

    public static ProductCategory mapToEntity(ProductCategoryDto productCategoryDto) {
        return new ProductCategory(
                productCategoryDto.getId(),
                PropertyMapper.mapToEntity(productCategoryDto.getProperty()),
                CategoryMapper.mapToEntity(productCategoryDto.getCategory()));
    }
}
