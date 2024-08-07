package com.example.real_estate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.real_estate.customexception.NotFoundException;
import com.example.real_estate.entities.Property;
import com.example.real_estate.repository.PropertyRepo;


@Service
public class PropertyService implements CrudServices<Property, Integer> {

	@Autowired
	public PropertyRepo propertyRepo; 
	
	@Override
	public Property create(Property property) {
		return propertyRepo.save(property);
	}

	@Override
	public List<Property> fetchAll() {
		return propertyRepo.findAll();
		
	}

	@Override
	public Property fetchById(Integer id) {
		
		return propertyRepo.findById(id).orElseThrow(() -> new NotFoundException("Invalid id"));
	}

	@Override
	public Property update(Property updatedProperty, Property existingProperty) {
		
		existingProperty.setBathrooms(updatedProperty.getBathrooms());
		existingProperty.setBedrooms(updatedProperty.getBedrooms());
		existingProperty.setBuildingSize(updatedProperty.getBuildingSize());
		existingProperty.setCity(updatedProperty.getCity());
		existingProperty.setListingType(updatedProperty.getListingType());
		existingProperty.setLotSize(updatedProperty.getLotSize());
		existingProperty.setPhotos(updatedProperty.getPhotos());
		existingProperty.setPrice(updatedProperty.getPrice());
//		existingProperty.setpropertyType(updatedProperty.getPropertyType());
		existingProperty.setState(updatedProperty.getState());
		existingProperty.setStatus(updatedProperty.getStatus());
		existingProperty.setStreetAddress(updatedProperty.getStreetAddress());
		existingProperty.setYearBuilt(updatedProperty.getYearBuilt());
		existingProperty.setZipcode(updatedProperty.getZipcode());

		return propertyRepo.save(existingProperty);
	}

	@Override
	public String delete(Property property) {
		propertyRepo.delete(property);
		return property.getPropertyId() + "deleted";
	}
	
	
	public List<Property> fetchPropertyByCityName(String city) {
		return propertyRepo.findByCity(city);
	}

}
