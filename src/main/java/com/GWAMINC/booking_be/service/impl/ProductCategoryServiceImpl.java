package com.GWAMINC.booking_be.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.GWAMINC.booking_be.dto.ProductCategoryDto;
import com.GWAMINC.booking_be.entity.ProductCategory;
import com.GWAMINC.booking_be.mapper.ProductCategoryMapper;
import com.GWAMINC.booking_be.repository.ProductCategoryRepository;
import com.GWAMINC.booking_be.service.ProductCategoryService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

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

}
