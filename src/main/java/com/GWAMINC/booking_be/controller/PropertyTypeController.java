package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.service.PropertyService;
import com.GWAMINC.booking_be.dto.PropertyTypeDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/propertytype")
@AllArgsConstructor
public class PropertyTypeController {

    private PropertyService propertyTypeService;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessageDto> createPropertyType(@RequestBody PropertyTypeDto propertyTypeDto) {
        try{
            PropertyTypeDto savedPropertyType = propertyTypeService.createPropertyType(propertyTypeDto);
            ResponseMessageDto response = new ResponseMessageDto("Create propertyType success",true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            ResponseMessageDto response = new ResponseMessageDto("Create propertyType failed"+e.getMessage(),false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PropertyTypeDto>> getAllPropertyTypes() {
        try{
            List<PropertyTypeDto> allPropertyTypes = propertyTypeService.getAllPropertyTypes();
            return new ResponseEntity<>(allPropertyTypes, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PropertyTypeDto> getPropertyTypeById(@PathVariable Long id) {
        try{
            PropertyTypeDto propertyType = propertyTypeService.getPropertyTypeById(id);

            if(propertyType != null){
                return new ResponseEntity<>(propertyType,HttpStatus.FOUND);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<ResponseMessageDto> updatePropertyTypeById(@RequestBody PropertyTypeDto propertyTypeDto, @PathVariable Long id) {
        try{
            PropertyTypeDto updatedPropertyType = propertyTypeService.updatePropertyType(id, propertyTypeDto);
            ResponseMessageDto response = new ResponseMessageDto("Update propertyType success",true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            ResponseMessageDto response = new ResponseMessageDto("Update propertyType failed"+e.getMessage(),false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ResponseMessageDto> deletePropertyTypeById(@PathVariable Long id) {
        try{
            propertyTypeService.deletePropertyTypeById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete propertyType success",true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            ResponseMessageDto response = new ResponseMessageDto("Delete propertyType failed"+e.getMessage(),false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
