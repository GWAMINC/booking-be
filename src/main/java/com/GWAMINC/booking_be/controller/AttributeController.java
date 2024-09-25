package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.dto.AttributeDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;
import com.GWAMINC.booking_be.service.AttributeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attribute")
@AllArgsConstructor
public class AttributeController {
    private AttributeService attributeService;
    @PostMapping("/create")
    public ResponseEntity<ResponseMessageDto> createAttribute(@RequestBody AttributeDto attributeDto) {
        try {
            AttributeDto savedAttribute = attributeService.createAttribute(attributeDto);
            ResponseMessageDto response = new ResponseMessageDto("Create attribute success", true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Create attribute failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<AttributeDto> getAttributeById(@PathVariable Long id) {
        try {
            AttributeDto attribute = attributeService.getAttributeById(id);

            if (attribute != null)
                return new ResponseEntity<>(attribute, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<ResponseMessageDto> updateAttributeById(@PathVariable Long id, @RequestBody AttributeDto attributeDto) {
        try {
            AttributeDto updatedAttribute = attributeService.updateAttributeById(id, attributeDto);
            ResponseMessageDto response = new ResponseMessageDto("Update attribute success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Update attribute failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessageDto> deleteAttributeById(@PathVariable Long id) {
        try {
            attributeService.deleteAttributeById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete attribute success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Delete attribute failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
