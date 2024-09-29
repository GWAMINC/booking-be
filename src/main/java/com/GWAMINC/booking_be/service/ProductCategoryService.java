package com.GWAMINC.booking_be.service;

import java.util.List;

import com.GWAMINC.booking_be.dto.ProductCategoryDto;

public interface ProductCategoryService {
    ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto);

    List<ProductCategoryDto> getAllProductCategories();

    ProductCategoryDto getProductCategoryById(Long id);

    void deleteProductCategoryById(Long id);

    void updateProductCategoryById(Long id, ProductCategoryDto productCategoryDto);
}
