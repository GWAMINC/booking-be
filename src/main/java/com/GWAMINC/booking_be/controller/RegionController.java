package com.GWAMINC.booking_be.controller;


import com.GWAMINC.booking_be.dto.RegionDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;
import com.GWAMINC.booking_be.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/region")
@AllArgsConstructor
public class RegionController {
    private RegionService regionService;

    @PostMapping("/create")
    public ResponseEntity<ResponseMessageDto> createRegion(@RequestBody RegionDto regionDto) {
        try {
            RegionDto savedRegion = regionService.createRegion(regionDto);
            ResponseMessageDto response = new ResponseMessageDto("Create region success", true);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Create region failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
