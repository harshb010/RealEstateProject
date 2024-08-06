package com.example.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate.entities.Property;
import java.util.List;


public interface PropertyRepo extends JpaRepository<Property, Integer> {

	List<Property> findByCity(String city);
}
