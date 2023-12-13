package com.ourProperty.Controller;


import com.ourProperty.payload.PropertyDto;
import com.ourProperty.payload.PropertyStatusUpdate;
import com.ourProperty.service.PropertyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }


    // Create operation with Dto
    @PostMapping
    public ResponseEntity<PropertyDto> saveProperty(@RequestBody PropertyDto propertyDto) {
        PropertyDto createdProperty = propertyService.saveProperty(propertyDto);
        return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PropertyDto> updatePropertyStatus(
            @PathVariable Long id,
            @RequestBody PropertyStatusUpdate action) {

        PropertyDto updatedPropertyDTO = propertyService.updatePropertyStatus(id, action.getStatus());
        return new ResponseEntity<>(updatedPropertyDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getProperty(@PathVariable("id") long id) {
        String status = getPropertyStatusFromDatabase(id);  // Replace this with your logic to retrieve property status from the database

        if ("Approved".equals(status)) {    // This end-point should only be accessible if the property status is "Approved"
            return ResponseEntity.ok("Property Details: {\"status\" : \"Approved\"}");
        }else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body("Access denied. Property status must be Approved.");
        }
    }
    // Replace this with your logic to retrieve property status from the database
    private  String getPropertyStatusFromDatabase(long id){

        // Simulating retrieving the status from a database
       return propertyService.findPropertyById(id);  // Replace with your actual implementation

    }
}


