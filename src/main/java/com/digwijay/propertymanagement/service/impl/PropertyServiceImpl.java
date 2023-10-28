package com.digwijay.propertymanagement.service.impl;

import com.digwijay.propertymanagement.converter.PropertyConverter;
import com.digwijay.propertymanagement.dto.PropertyDTO;
import com.digwijay.propertymanagement.entity.PropertyEntity;
import com.digwijay.propertymanagement.repository.PropertyRepository;
import com.digwijay.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity =propertyConverter.dtoToEntity(propertyDTO);

        PropertyEntity savedPropertyEntity = propertyRepository.save(propertyEntity);

        return propertyConverter.entityToDto(savedPropertyEntity);
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> p = propertyRepository.findById(propertyId);
        if(p.isPresent()){
            PropertyEntity prop = p.get();
            prop.setTitle(propertyDTO.getTitle());
            prop.setDescription(propertyDTO.getDescription());
            prop.setOwnerName(propertyDTO.getOwnerName());
            prop.setOwnerEmail(propertyDTO.getOwnerEmail());
            prop.setPrice(propertyDTO.getPrice());
            prop.setAddress(propertyDTO.getAddress());

            PropertyEntity updatedProperty =propertyRepository.save(prop);
            return propertyConverter.entityToDto(updatedProperty);
        }

        return null;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> p = propertyRepository.findById(propertyId);
        if(p.isPresent()){
            PropertyEntity prop = p.get();

            prop.setDescription(propertyDTO.getDescription());

            PropertyEntity updatedProperty =propertyRepository.save(prop);
            return propertyConverter.entityToDto(updatedProperty);
        }

        return null;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> p = propertyRepository.findById(propertyId);
        if(p.isPresent()){
            PropertyEntity prop = p.get();

            prop.setPrice(propertyDTO.getPrice());

            PropertyEntity updatedProperty =propertyRepository.save(prop);
            return propertyConverter.entityToDto(updatedProperty);
        }

        return null;
    }

    @Override
    public PropertyDTO getPropertyById(Long propertyId) {
        Optional<PropertyEntity> p = propertyRepository.findById(propertyId);
        if(p.isPresent()){
            PropertyEntity prop = p.get();
            return propertyConverter.entityToDto(prop);
        }
        return null;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> props = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();
        for (PropertyEntity p : props ) {
            propList.add(propertyConverter.entityToDto(p));
        }
        return propList;
    }

    @Override
    public void deleteProperty(Long propertyId) {

        propertyRepository.deleteById(propertyId);

    }
}
