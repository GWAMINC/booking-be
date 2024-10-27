package com.GWAMINC.booking_be.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.GWAMINC.booking_be.dto.CategoryDto;
import com.GWAMINC.booking_be.dto.ProductCategoryDto;
import com.GWAMINC.booking_be.entity.Category;
import com.GWAMINC.booking_be.entity.ProductCategory;
import com.GWAMINC.booking_be.mapper.CategoryMapper;
import com.GWAMINC.booking_be.mapper.ProductCategoryMapper;
import com.GWAMINC.booking_be.repository.CategoryRepository;
import com.GWAMINC.booking_be.repository.ProductCategoryRepository;
import com.GWAMINC.booking_be.service.ProductCategoryService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductCategoryDto createProductCategory(ProductCategoryDto productCategoryDto) {
        ProductCategory productEntity = ProductCategoryMapper.mapToEntity(productCategoryDto);
        return ProductCategoryMapper.mapToDto(productCategoryRepository.save(productEntity));
    }

    @Override
    public List<ProductCategoryDto> getAllProductCategories() {
        return productCategoryRepository
                .findAll()
                .stream()
                .map(ProductCategoryMapper::mapToDto)
                .toList();
    }

    @Override
    public ProductCategoryDto getProductCategoryById(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id).orElse(null);
        if (productCategory == null)
            return null;
        return ProductCategoryMapper.mapToDto(productCategory);
    }

    @Override
    public void deleteProductCategoryById(Long id) {
        productCategoryRepository.deleteById(id);
    }

    @Override
    public void updateProductCategoryById(Long id, ProductCategoryDto productCategoryDto) {
        ProductCategory oldProductCategory = productCategoryRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("productCategory with id [%d] not found".formatted(id)));

        ProductCategory newProductCategory = ProductCategoryMapper.mapToEntity(productCategoryDto);
        newProductCategory.setId(oldProductCategory.getId());

        productCategoryRepository.save(newProductCategory);
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToEntity(categoryDto);
        return CategoryMapper.mapToDto(categoryRepository.save(category));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> CategoryMapper.mapToDto(category))
                .collect(Collectors.toList());

    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id [%d] not found".formatted(id)));

        return CategoryMapper.mapToDto(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category with id [%d] not found".formatted(id)));

        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto updateCategoryById(Long id, CategoryDto categoryDto) {
        Category oldCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Place type with id [%d] not found".formatted(id)));

        Category newCategory = CategoryMapper.mapToEntity(categoryDto);
        newCategory.setId(oldCategory.getId());

        return CategoryMapper.mapToDto(categoryRepository.save(newCategory));
    }
}
