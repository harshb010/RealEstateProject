package com.example.real_estate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.real_estate.customexception.NotFoundException;
import com.example.real_estate.dto.ErrorResponse;
import com.example.real_estate.entities.Property;
import com.example.real_estate.service.PropertyService;

@CrossOrigin("*")
@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@PostMapping("/add")
	public ResponseEntity<?> registerdProperty(@RequestBody Property property) {
		Property createdProperty = propertyService.create(property);
		return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllProperty() {
		try {
			return new ResponseEntity<>(propertyService.fetchAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("Property Fetching is failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/{propertyId}")
	public ResponseEntity<?> getPropertyById(@PathVariable("propertyId") Integer id) {
		try {
			return  ResponseEntity.ok(propertyService.fetchById(id));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce=
		    new ErrorResponse("Property Fetching is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{propertyId}")
	public ResponseEntity<?> updatePropertyById(@PathVariable("propertyId") Integer id,
			@RequestBody Property updateProperty) {
		try {
			Property existingProperty=propertyService.fetchById(id);
			
			return  ResponseEntity.ok(propertyService.update(updateProperty, existingProperty));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce= new ErrorResponse("Property updation is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{propertyId}")
	public ResponseEntity<?>deletePropertyById(@PathVariable ("propertyId") Integer id)
	{ try {
		Property existingProperty=propertyService.fetchById(id);
		return ResponseEntity.ok(propertyService.delete(existingProperty));
				
	} catch (Exception e) {

		ErrorResponse errorResponce= new ErrorResponse("Property deletion is failead", e.getMessage());
		return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		
	}
		
	}
	@GetMapping("/getbyCityName/{city}")
	public ResponseEntity<?> getPropertyByCityName(@PathVariable("city") String city){
		try {
			ResponseEntity res = null;
			List<Property> foundProperty = propertyService.fetchPropertyByCityName(city);
			if(foundProperty != null) {
				return res.ok(foundProperty);
			
			}else {
				throw new NotFoundException("Invalid City Name..");
			}
		
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("fetching property by cityname failed.", e.getMessage()),HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
