package com.digwijay.propertymanagement.service;

import com.digwijay.propertymanagement.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {

    PropertyDTO saveProperty(PropertyDTO propertyDTO);

    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO getPropertyById(Long propertyId);

    List<PropertyDTO> getAllProperties();

    void deleteProperty(Long propertyId);
}
