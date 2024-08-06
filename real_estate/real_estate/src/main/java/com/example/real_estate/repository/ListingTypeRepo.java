package com.example.real_estate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate.entities.ListingType;
import com.example.real_estate.entities.ListingType.propertyType;

public interface ListingTypeRepo extends JpaRepository<ListingType, Integer>{

	List<ListingType> findByProperty(propertyType properties);
}
