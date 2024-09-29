package com.GWAMINC.booking_be.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.GWAMINC.booking_be.dto.CategoryDto;
import com.GWAMINC.booking_be.entity.Category;
import com.GWAMINC.booking_be.mapper.CategoryMapper;
import com.GWAMINC.booking_be.repository.CategoryRepository;
import com.GWAMINC.booking_be.service.CategoryService;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

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
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null)
            return null;
        return CategoryMapper.mapToDto(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategoryById(Long id, CategoryDto categoryDto) {
        Category oldCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Place type with id [%d] not found".formatted(id)));

        Category newCategory = CategoryMapper.mapToEntity(categoryDto);
        newCategory.setId(oldCategory.getId());
        categoryRepository.save(newCategory);
    }

}
