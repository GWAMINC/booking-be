package com.GWAMINC.booking_be.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.GWAMINC.booking_be.dto.CategoryDto;
import com.GWAMINC.booking_be.entity.Category;
import com.GWAMINC.booking_be.mapper.CategoryMapper;
import com.GWAMINC.booking_be.repository.CategoryRepository;
import com.GWAMINC.booking_be.service.impl.ProductCategoryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductCategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private ProductCategoryServiceImpl productCategoryService;

    private Category category;
    private CategoryDto categoryDto;

    @BeforeEach
    public void init() {
        category = new Category(1L, "name");
        categoryDto = CategoryMapper.mapToDto(category);
    }

    @Test
    public void createCategorySuccessfully() {
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryDto savedCategory = productCategoryService.createCategory(categoryDto);

        assertThat(savedCategory).isNotNull();
    }

    @Test
    public void getCategoryByIdSuccessfully() {
        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));

        CategoryDto categoryDto1 = productCategoryService.getCategoryById(category.getId());

        assertThat(categoryDto1).isNotNull();
    }

    @Test
    public void deleteCategoryByIdSuccessfully() {
        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));

        assertAll(() -> productCategoryService.deleteCategoryById(category.getId()));
    }

    @Test
    public void updateCategoryByIdSuccessfully() {
        when(categoryRepository.findById(category.getId())).thenReturn(Optional.of(category));
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        CategoryDto updateReturn = productCategoryService.updateCategoryById(category.getId(), categoryDto);

        assertThat(updateReturn).isNotNull();
    }
}
