package com.digwijay.propertymanagement.controller;

import com.digwijay.propertymanagement.dto.PropertyDTO;
import com.digwijay.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> save(@RequestBody PropertyDTO propertyDTO){
        PropertyDTO savedPropertyDTO = propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<>(savedPropertyDTO, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties(){
        List<PropertyDTO> props = propertyService.getAllProperties();
        return new ResponseEntity<>(props, HttpStatus.OK);
    }

    @DeleteMapping ("/properties/{propertyId}")
    public ResponseEntity<String> deleteProperty( @PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        return new ResponseEntity<>("Property deleted successfully", HttpStatus.OK);
    }


    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        PropertyDTO p = propertyService.updateProperty(propertyDTO, propertyId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> getPropertyById(@PathVariable Long propertyId){
        PropertyDTO p = propertyService.getPropertyById(propertyId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PatchMapping("/properties/update-description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        PropertyDTO p = propertyService.updatePropertyDescription(propertyDTO, propertyId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PatchMapping("/properties/update-price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        PropertyDTO p = propertyService.updatePropertyPrice(propertyDTO, propertyId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }
}
