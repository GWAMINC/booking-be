package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.dto.PlaceTypeDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;
import com.GWAMINC.booking_be.service.PlaceTypeService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/placeType")
@AllArgsConstructor
public class PlaceTypeController {
    private PlaceTypeService placeTypeService;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessageDto> createPlaceType(@RequestBody PlaceTypeDto placeTypeDto) {
        try {
            PlaceTypeDto savedPlaceType = placeTypeService.createPlaceType(placeTypeDto);
            ResponseMessageDto response = new ResponseMessageDto("Create place type success", true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Create place type failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PlaceTypeDto>> getAllPlaceTypes() {
        try {
            List<PlaceTypeDto> placeTypeDtos = placeTypeService.getAllPlaceTypes();
            return new ResponseEntity<>(placeTypeDtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PlaceTypeDto> getPlaceTypeById(@PathVariable Long id) {
        try {
            PlaceTypeDto placeType = placeTypeService.getPlaceTypeById(id);

            if (placeType != null)
                return new ResponseEntity<>(placeType, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ResponseMessageDto> deletePlaceTypeById(@PathVariable Long id) {
        try {
            placeTypeService.deletePlaceTypeById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete placeType succesfully", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Delete place type failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<ResponseMessageDto> updateById(@PathVariable Long id,
            @RequestBody PlaceTypeDto placeTypeDto) {
        try {
            placeTypeService.updatePlaceTypeById(id, placeTypeDto);
            ResponseMessageDto response = new ResponseMessageDto("Update placeType successfully", true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Update place type failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
