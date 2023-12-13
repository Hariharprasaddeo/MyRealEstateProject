package com.ourProperty.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
