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
@RequestMapping("/api/place-type")
@AllArgsConstructor
public class PlaceTypeController {
    private PlaceTypeService placeTypeService;

    @PostMapping("/create")
    public ResponseEntity<?> createPlaceType(@RequestBody PlaceTypeDto placeTypeDto) {
        try {
            PlaceTypeDto savedPlaceType = placeTypeService.createPlaceType(placeTypeDto);
            return new ResponseEntity<>(savedPlaceType, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto res = new ResponseMessageDto(e.getMessage(), false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllPlaceTypes() {
        try {
            List<PlaceTypeDto> placeTypeDtos = placeTypeService.getAllPlaceTypes();
            return new ResponseEntity<>(placeTypeDtos, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto res = new ResponseMessageDto(e.getMessage(), false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getPlaceTypeById(@PathVariable Long id) {
        try {
            PlaceTypeDto placeType = placeTypeService.getPlaceTypeById(id);
            return new ResponseEntity<>(placeType, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto res = new ResponseMessageDto(e.getMessage(), false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ResponseMessageDto> deletePlaceTypeById(@PathVariable Long id) {
        try {
            placeTypeService.deletePlaceTypeById(id);
            ResponseMessageDto res = new ResponseMessageDto("Delete place type successfully", true);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto res = new ResponseMessageDto(e.getMessage(), false);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<ResponseMessageDto> updateById(@PathVariable Long id,
            @RequestBody PlaceTypeDto placeTypeDto) {
        try {
            placeTypeService.updatePlaceTypeById(id, placeTypeDto);
            ResponseMessageDto res = new ResponseMessageDto("Update place type successfully", true);
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto res = new ResponseMessageDto(e.getMessage(), true);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }
}
