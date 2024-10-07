package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.service.PropertyService;
import com.GWAMINC.booking_be.dto.PropertyDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/property")
@AllArgsConstructor
public class PropertyController {
    private PropertyService propertyService;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessageDto> createProperty(@RequestBody PropertyDto propertyDto){
        try{
            PropertyDto savedProperty = propertyService.createProperty(propertyDto);
            ResponseMessageDto response = new ResponseMessageDto("Create Property Success",true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }
        catch (Exception e){
            ResponseMessageDto response = new ResponseMessageDto("Create Property Error"+e.getMessage(),false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<PropertyDto>> getAllProperties(){
        try{
            List<PropertyDto> allProperties = propertyService.getAllProperties();
            return new ResponseEntity<>(allProperties, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable Long id){
        try{
            PropertyDto property = propertyService.getPropertyById(id);
            if(property != null){
                return new ResponseEntity<>(property, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<ResponseMessageDto> updatePropertyById(@PathVariable Long id, @RequestBody PropertyDto propertyDto){
        try{
            PropertyDto updatedProperty = propertyService.updateProperty(id, propertyDto);
            ResponseMessageDto response = new ResponseMessageDto("Update Property Success",true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            ResponseMessageDto response = new ResponseMessageDto("Update Property Error"+e.getMessage(),false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ResponseMessageDto> deletePropertyById(@PathVariable Long id){
        try{
            propertyService.deletePropertyById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete Property Success",true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            ResponseMessageDto response = new ResponseMessageDto("Delete Property Error"+e.getMessage(),false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
