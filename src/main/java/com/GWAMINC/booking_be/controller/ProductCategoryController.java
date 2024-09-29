package com.GWAMINC.booking_be.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GWAMINC.booking_be.dto.ProductCategoryDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;
import com.GWAMINC.booking_be.service.ProductCategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/productCategory")
@AllArgsConstructor
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @PostMapping("/create")
    public ResponseEntity<ProductCategoryDto> createProductCategory(
            @RequestBody ProductCategoryDto productCategoryDto) {
        try {
            ProductCategoryDto savedProductCategory = productCategoryService.createProductCategory(productCategoryDto);
            return new ResponseEntity<>(savedProductCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Exception", e.getMessage());

            return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductCategoryDto>> getAllProductCategories() {
        try {
            List<ProductCategoryDto> productCategoryDtos = productCategoryService.getAllProductCategories();
            return new ResponseEntity<>(productCategoryDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ProductCategoryDto> getProductCategoryById(@PathVariable Long id) {
        try {
            ProductCategoryDto productCategory = productCategoryService.getProductCategoryById(id);

            if (productCategory == null)
                return new ResponseEntity<>(productCategory, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ResponseMessageDto> deleteProductCategoryById(@PathVariable Long id) {
        try {
            productCategoryService.deleteProductCategoryById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete productCategory succesfully", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Delete productCategory failed: " + e.getMessage(),
                    false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<ResponseMessageDto> updateProductCategoryById(@PathVariable Long id,
            @RequestBody ProductCategoryDto productCategoryDto) {
        try {
            productCategoryService.updateProductCategoryById(id, productCategoryDto);
            ResponseMessageDto response = new ResponseMessageDto("Update productCategory successfully", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Update productCategory failed: " + e.getMessage(),
                    false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
