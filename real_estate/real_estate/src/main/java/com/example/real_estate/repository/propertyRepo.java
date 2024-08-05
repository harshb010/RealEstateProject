package com.example.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate.entities.Property;

public interface propertyRepo extends JpaRepository<Property, Integer> {

}
