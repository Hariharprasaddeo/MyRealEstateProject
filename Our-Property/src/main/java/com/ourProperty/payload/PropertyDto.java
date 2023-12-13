package com.ourProperty.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDto {

    private Long id;
    private String apartmentType;
    private int bhkType;
    private int floor;
    private int totalFloor;
    private int propertyAge;
    private String facingZone;
    private double builtUpArea;
    private String status;

    // Constructors, getters, and setters

    // You can generate constructors, getters, and setters using your IDE or write them manually.

}

