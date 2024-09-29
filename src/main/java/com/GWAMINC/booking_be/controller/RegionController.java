package com.GWAMINC.booking_be.controller;
import com.GWAMINC.booking_be.dto.RegionDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;
import com.GWAMINC.booking_be.service.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAll")
    public  ResponseEntity<List<RegionDto>> getAllRegions() {
        try {
            List<RegionDto> allRegions= regionService.getAllRegions();
            ResponseMessageDto response = new ResponseMessageDto("Get all regions success", true);
            return new ResponseEntity<>(allRegions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<RegionDto> getCountryById(@PathVariable Long id) {
        try {
            RegionDto regionDto = regionService.getRegionById(id);

            if (regionDto != null)
                return new ResponseEntity<>(regionDto, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<ResponseMessageDto> updateRegionById(@PathVariable Long id, @RequestBody RegionDto regionDto) {
        try {
            RegionDto updatedRegion = regionService.updateRegionById(id, regionDto);
            ResponseMessageDto response = new ResponseMessageDto("Update region success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Update region failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ResponseMessageDto> deleteRegionById(@PathVariable Long id) {
        try {
            regionService.deleteRegionById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete region success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Delete region failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
