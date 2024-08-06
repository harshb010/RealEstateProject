package com.example.real_estate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.real_estate.customexception.NotFoundException;
import com.example.real_estate.entities.ListingType;
import com.example.real_estate.entities.ListingType.propertyType;
import com.example.real_estate.repository.ListingTypeRepo;


@Service
public class ListingTypeService implements CrudServices<ListingType, Integer>{

	@Autowired
	public ListingTypeRepo listingTypeRepo; 
	
	@Override
	public ListingType create(ListingType listingtype) {
		return listingTypeRepo.save(listingtype);
	}

	@Override
	public List<ListingType> fetchAll() {
		return listingTypeRepo.findAll();
	}

	@Override
	public ListingType fetchById(Integer id) {
		return listingTypeRepo.findById(id).orElseThrow(() -> new NotFoundException("Invalid id"));
	}

	@Override
	public ListingType update(ListingType updatedList, ListingType existingList) {
		
		existingList.setListingDate(updatedList.getListingDate());
		existingList.setStatus(updatedList.getStatus());
		return listingTypeRepo.save(existingList);
	}

	@Override
	public String delete(ListingType listingtype) {
		listingTypeRepo.delete(listingtype);
		return listingtype.getId() + " deleted";	
	}
	
	public List<ListingType> fetchListByProperty(propertyType properties) {
		return listingTypeRepo.findByProperty(properties);
	}

}
