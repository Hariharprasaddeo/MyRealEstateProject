package com.ourProperty.util;


import com.ourProperty.entity.Property;
import com.ourProperty.payload.PropertyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PropertyMapper {

    PropertyDto entityToDto(Property property);

    @Mapping(target = "id", ignore = true)    // Ignore id during mapping (assuming it's generated)
    Property dtoToEntity(PropertyDto propertyDto);

}
