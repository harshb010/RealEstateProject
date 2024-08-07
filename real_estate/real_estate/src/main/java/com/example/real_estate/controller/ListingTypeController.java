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
import com.example.real_estate.entities.ListingType;
import com.example.real_estate.entities.Property;
import com.example.real_estate.entities.ListingType.propertyType;
import com.example.real_estate.service.ListingTypeService;


@CrossOrigin("*")
@RestController
@RequestMapping("/listingtype")
public class ListingTypeController {

	@Autowired
	private ListingTypeService listingTypeService;
	
	@PostMapping("/add")
	public ResponseEntity<?> registerdListingType(@RequestBody ListingType listingtype) {
		ListingType createdListingType = listingTypeService.create(listingtype);
		return new ResponseEntity<>(createdListingType, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllListingType() {
		try {
			return new ResponseEntity<>(listingTypeService.fetchAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("Listing Type Fetching is failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getListingTypeById(@PathVariable("id") Integer id) {
		try {
			return  ResponseEntity.ok(listingTypeService.fetchById(id));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce=
		    new ErrorResponse("Listing Type Fetching is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateListingTypeById(@PathVariable("id") Integer id,
			@RequestBody ListingType updateListingType) {
		try {
			ListingType existingListingType=listingTypeService.fetchById(id);
			
			return  ResponseEntity.ok(listingTypeService.update(updateListingType, existingListingType));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce= new ErrorResponse("Listing Type updation is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?>deleteListingTypeById(@PathVariable ("id") Integer id)
	{ try {
		ListingType existingListingType=listingTypeService.fetchById(id);
		return ResponseEntity.ok(listingTypeService.delete(existingListingType));
				
	} catch (Exception e) {

		ErrorResponse errorResponce= new ErrorResponse("Listing Type deletion is failead", e.getMessage());
		return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		
	}
		
	}
	@GetMapping("/getbyproperty/{property}")
	public ResponseEntity<?> getListingTypeByProperty(@PathVariable("property") propertyType properties){
		try {
			ResponseEntity res = null;
			List<ListingType> foundListingType = listingTypeService.fetchListByProperty(properties);
			if(foundListingType != null) {
				return res.ok(foundListingType);
			
			}else {
				throw new NotFoundException("Invalid Property Name..");
			}
		
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("fetching listing type by property failed.", e.getMessage()),HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
