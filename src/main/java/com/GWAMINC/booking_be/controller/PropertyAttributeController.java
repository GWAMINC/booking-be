package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.dto.AttributeCategoryDto;
import com.GWAMINC.booking_be.dto.AttributeDto;
import com.GWAMINC.booking_be.dto.PropertyAttributeDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;
import com.GWAMINC.booking_be.service.PropertyAttributeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property-attribute")
@AllArgsConstructor
public class PropertyAttributeController {
    private PropertyAttributeService propertyAttributeService;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessageDto> createPropertyAttribute(@RequestBody PropertyAttributeDto propertyAttributeDto) {
        try {
            PropertyAttributeDto savedPropertyAttribute = propertyAttributeService.createPropertyAttribute(propertyAttributeDto);
            ResponseMessageDto response = new ResponseMessageDto("Create property attribute success", true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Create property attribute failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PropertyAttributeDto> getPropertyAttributeById(@PathVariable Long id) {
        try {
            PropertyAttributeDto propertyAttribute = propertyAttributeService.getById(id);
            if (propertyAttribute != null)
                return new ResponseEntity<>(propertyAttribute, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponseMessageDto> updatePropertyAttributeById(@PathVariable Long id, @RequestBody PropertyAttributeDto propertyAttributeDto) {
        try {
            PropertyAttributeDto updatedPropertyAttribute = propertyAttributeService.updatePropertyAttributeById(id, propertyAttributeDto);
            ResponseMessageDto response = new ResponseMessageDto("Update property attribute success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Update property attribute failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessageDto> deletePropertyAttributeById(@PathVariable Long id) {
        try {
            propertyAttributeService.deletePropertyAttributeById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete property attribute success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Delete property attribute failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/attribute/create")
    public ResponseEntity<AttributeDto> createAttribute(@RequestBody AttributeDto attributeDto) {
        try {
            AttributeDto savedAttribute = propertyAttributeService.createAttribute(attributeDto);
            ResponseMessageDto response = new ResponseMessageDto("Create attribute success", true);
            return new ResponseEntity<>(savedAttribute, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Create attribute failed: " + e.getMessage(), false);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/attribute/getById/{id}")
    public ResponseEntity<AttributeDto> getAttributeById(@PathVariable Long id) {
        try {
            AttributeDto attribute = propertyAttributeService.getAttributeById(id);

            if (attribute != null)
                return new ResponseEntity<>(attribute, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/attribute/getAllByPropertyId/{id}")
    public ResponseEntity<List<AttributeDto>> getAllAttributeByPropertyId(@PathVariable Long id) {
        try {
            List<AttributeDto> propertyAttributes = propertyAttributeService.getAllAttributeByPropertyId(id);
            return new ResponseEntity<>(propertyAttributes, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/attribute/getAll")
    public ResponseEntity<List<AttributeDto>> getAllAttributes() {
        try {
            List<AttributeDto> attributes = propertyAttributeService.getAllAttributes();
            return new ResponseEntity<>(attributes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/attribute/update/{id}")
    public ResponseEntity<ResponseMessageDto> updateAttributeById(@PathVariable Long id, @RequestBody AttributeDto attributeDto) {
        try {
            AttributeDto updatedAttribute = propertyAttributeService.updateAttributeById(id, attributeDto);
            ResponseMessageDto response = new ResponseMessageDto("Update attribute success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Update attribute failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/attribute/delete/{id}")
    public ResponseEntity<ResponseMessageDto> deleteAttributeById(@PathVariable Long id) {
        try {
            propertyAttributeService.deleteAttributeById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete attribute success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Delete attribute failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/category/create")
    public ResponseEntity<AttributeCategoryDto> createAttributeCategory(@RequestBody AttributeCategoryDto attributeCategoryDto) {
        try {
            AttributeCategoryDto savedAttributeCategory = propertyAttributeService.createAttributeCategory(attributeCategoryDto);
            ResponseMessageDto response = new ResponseMessageDto("Create attribute category success", true);
            return new ResponseEntity<>(savedAttributeCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Create attribute category failed: " + e.getMessage(), false);
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/category/getById/{id}")
    public ResponseEntity<AttributeCategoryDto> getAttributeCategoryById(@PathVariable Long id) {
        try {
            AttributeCategoryDto attributeCategory = propertyAttributeService.getAttributeCategoryById(id);
            if (attributeCategory != null)
                return new ResponseEntity<>(attributeCategory, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/category/getAll")
    public ResponseEntity<List<AttributeCategoryDto>> getAllAttributeCategories() {
        try {
            List<AttributeCategoryDto> attributeCategories = propertyAttributeService.getAllAttributeCategories();
            return new ResponseEntity<>(attributeCategories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/category/update/{id}")
    public ResponseEntity<ResponseMessageDto> updateAttributeCategoryById(@PathVariable Long id, @RequestBody AttributeCategoryDto attributeCategoryDto) {
        try {
            AttributeCategoryDto updatedAttributeCategory = propertyAttributeService.updateAttributeCategoryById(id, attributeCategoryDto);
            ResponseMessageDto response = new ResponseMessageDto("Update attribute category success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Update attribute category failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<ResponseMessageDto> deleteAttributeCategoryById(@PathVariable Long id) {
        try {
            propertyAttributeService.deleteAttributeCategoryById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete attribute category success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Delete attribute category failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
