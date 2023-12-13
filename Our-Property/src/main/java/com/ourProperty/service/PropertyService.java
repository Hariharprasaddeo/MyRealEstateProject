package com.ourProperty.service;

import com.ourProperty.payload.PropertyDto;

public interface PropertyService {

     PropertyDto saveProperty(PropertyDto propertyDto);

     PropertyDto updatePropertyStatus(Long id, String newStatus);

     String findPropertyById(long id);

}
