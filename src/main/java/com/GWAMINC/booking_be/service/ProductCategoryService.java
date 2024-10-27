package com.GWAMINC.booking_be.service;

import java.util.List;

import com.GWAMINC.booking_be.dto.CategoryDto;
import com.GWAMINC.booking_be.dto.ProductCategoryDto;

public interface ProductCategoryService {
    // product category
    ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto);

    List<ProductCategoryDto> getAllProductCategories();

    ProductCategoryDto getProductCategoryById(Long id);

    void deleteProductCategoryById(Long id);

    void updateProductCategoryById(Long id, ProductCategoryDto productCategoryDto);

    // category
    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(Long id);

    void deleteCategoryById(Long id);

    CategoryDto updateCategoryById(Long id, CategoryDto categoryDto);
}
