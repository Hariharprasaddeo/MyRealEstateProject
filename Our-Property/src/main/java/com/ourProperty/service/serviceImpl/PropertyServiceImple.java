package com.ourProperty.service.serviceImpl;


import com.ourProperty.entity.Property;
import com.ourProperty.exception.EntityNotFoundException;
import com.ourProperty.payload.PropertyDto;
import com.ourProperty.repository.PropertyRepository;
import com.ourProperty.service.PropertyService;
import com.ourProperty.util.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImple implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyMapper propertyMapper;

    // Create operation
    @Override
    public PropertyDto saveProperty(PropertyDto propertyDto) {
        Property property = propertyMapper.dtoToEntity(propertyDto);
        property.setStatus("newstatus");
        Property savedProperty = propertyRepository.save(property);
        return propertyMapper.entityToDto(savedProperty);

    }

    @Override
    public PropertyDto updatePropertyStatus(Long id, String newStatus) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property not found")
                );
        property.setStatus("pending");
        Property updatedProperty = propertyRepository.save(property);
        return propertyMapper.entityToDto(updatedProperty);
    }

    @Override
    public String findPropertyById(long id) {
        Property property = propertyRepository.findById(id).get();
        return property.getStatus();
    }
}

