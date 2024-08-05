package com.example.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate.entities.ListingType;

public interface ListingTypeRepo extends JpaRepository<ListingType, Integer>{

}
