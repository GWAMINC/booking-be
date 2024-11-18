package com.GWAMINC.booking_be.controller;

import com.GWAMINC.booking_be.service.CountryService;
import com.GWAMINC.booking_be.dto.CountryDto;
import com.GWAMINC.booking_be.dto.ResponseMessageDto;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
@RequestMapping("/api/country")
@AllArgsConstructor
public class CountryController {
    private CountryService countryService;

    @PostMapping("/create")
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {
        try {
            CountryDto savedCountry = countryService.createCountry(countryDto);
            return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Create country failed: " + e.getMessage(), false);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<CountryDto>> getAllCountries() {
        try {
            List<CountryDto> allCountries = countryService.getAllCountries();
            return new ResponseEntity<>(allCountries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable Long id) {
        try {
            CountryDto country = countryService.getCountryById(id);

            if (country != null)
                return new ResponseEntity<>(country, HttpStatus.FOUND);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByRegionId/{regionId}")
    public ResponseEntity<List<CountryDto>> getCountriesByRegionId(@PathVariable Long regionId) {
        try {
            List<CountryDto> countries = countryService.getCountriesByRegionId(regionId);
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/updateById/{id}")
    public ResponseEntity<ResponseMessageDto> updateCountryById(@PathVariable Long id, @RequestBody CountryDto countryDto) {
        try {
            CountryDto updatedCountry = countryService.updateCountryById(id, countryDto);
            ResponseMessageDto response = new ResponseMessageDto("Update country success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Update country failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<ResponseMessageDto> deleteCountryById(@PathVariable Long id) {
        try {
            countryService.deleteCountryById(id);
            ResponseMessageDto response = new ResponseMessageDto("Delete country success", true);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            ResponseMessageDto response = new ResponseMessageDto("Delete country failed: " + e.getMessage(), false);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
