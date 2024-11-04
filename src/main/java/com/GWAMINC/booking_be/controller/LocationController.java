package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.dto.CountryDto;
import com.GWAMINC.booking_be.service.LocationService;
import com.GWAMINC.booking_be.dto.LocationDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@AllArgsConstructor
public class LocationController {
    private LocationService locationService;

    @PostMapping("/create")
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {
        try {
            LocationDto savedLocation = locationService.createLocation(locationDto);
            return new ResponseEntity<>(savedLocation, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Create location failed: " + e.getMessage(), false);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<LocationDto>> getAllLocations() {
        try {
            List<LocationDto> allLocations = locationService.getAllLocations();
            return new ResponseEntity<>(allLocations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable Long id) {
        try {
            LocationDto location = locationService.getLocationById(id);
            if (location != null)
                return new ResponseEntity<>(location, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<ResponseMessageDto> updateLocationById(@PathVariable Long id, @RequestBody LocationDto locationDto) {
        try {
            LocationDto updatedLocation = locationService.updateLocationById(id, locationDto);
            ResponseMessageDto response = new ResponseMessageDto("Update location success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Update location failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ResponseMessageDto> deleteLocationById(@PathVariable Long id) {
        try {
            locationService.deleteLocationById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete location success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Delete location failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
