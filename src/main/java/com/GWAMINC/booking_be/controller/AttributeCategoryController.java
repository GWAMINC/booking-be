package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.dto.AttributeCategoryDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;
import com.GWAMINC.booking_be.service.AttributeCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attributeCategory")
@AllArgsConstructor
public class AttributeCategoryController {
    private AttributeCategoryService attributeCategoryService;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessageDto> createAttributeCategory(@RequestBody AttributeCategoryDto attributeCategoryDto) {
        try {
            AttributeCategoryDto savedAttributeCategory = attributeCategoryService.createAttributeCategory(attributeCategoryDto);
            ResponseMessageDto response = new ResponseMessageDto("Create attribute category success", true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Create attribute category failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AttributeCategoryDto> getAttributeCategoryById(@PathVariable Long id) {
        try {
            AttributeCategoryDto attributeCategory = attributeCategoryService.getAttributeCategoryById(id);
            if (attributeCategory != null)
                return new ResponseEntity<>(attributeCategory, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponseMessageDto> updateAttributeCategoryById(@PathVariable Long id, @RequestBody AttributeCategoryDto attributeCategoryDto) {
        try {
            AttributeCategoryDto updatedAttributeCategory = attributeCategoryService.updateAttributeCategoryById(id, attributeCategoryDto);
            ResponseMessageDto response = new ResponseMessageDto("Update attribute category success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Update attribute category failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessageDto> deleteAttributeCategoryById(@PathVariable Long id) {
        try {
            attributeCategoryService.deleteAttributeCategoryById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete attribute category success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Delete attribute category failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
