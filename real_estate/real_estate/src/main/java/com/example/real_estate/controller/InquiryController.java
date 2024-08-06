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
import com.example.real_estate.entities.Inquiry;
import com.example.real_estate.entities.Inquiry.enquiryStatus;
import com.example.real_estate.service.InquiryService;


@CrossOrigin("*")
@RestController
@RequestMapping("/enquiry")
public class InquiryController {
	
	@Autowired
	private InquiryService inquiryService;

	@PostMapping("/add")
	public ResponseEntity<?> registerdInquiry(@RequestBody Inquiry inquiry) {
		Inquiry createdInquiry = inquiryService.create(inquiry);
		return new ResponseEntity<>(createdInquiry, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllInquiries() {
		try {
			return new ResponseEntity<>(inquiryService.fetchAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("Inquiry Fetching is failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/{enquiryId}")
	public ResponseEntity<?> getInquiryById(@PathVariable("enquiryId") Integer id) {
		try {
			return  ResponseEntity.ok(inquiryService.fetchById(id));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce=
		    new ErrorResponse("Inquiry Fetching is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{enquiryId}")
	public ResponseEntity<?> updatePropertyById(@PathVariable("enquiryId") Integer id,
			@RequestBody Inquiry updateInquiry) {
		try {
			Inquiry existingInquiry=inquiryService.fetchById(id);
			
			return  ResponseEntity.ok(inquiryService.update(updateInquiry, existingInquiry));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce= new ErrorResponse("Inquiry updation is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{enquiryId}")
	public ResponseEntity<?>deletePropertyById(@PathVariable ("enquiryId") Integer id)
	{ try {
		Inquiry existingProperty=inquiryService.fetchById(id);
		return ResponseEntity.ok(inquiryService.delete(existingProperty));
				
	} catch (Exception e) {

		ErrorResponse errorResponce= new ErrorResponse("Inquiry deletion is failead", e.getMessage());
		return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		
	}
		
	}
	@GetMapping("/getbystatus/{status}")
	public ResponseEntity<?> getPropertyByCityName(@PathVariable("status") enquiryStatus status){
		try {
			ResponseEntity res = null;
			List<Inquiry> foundInquiry = inquiryService.fetchInquiryByStatus(status);
			if(foundInquiry != null) {
				return res.ok(foundInquiry);
			
			}else {
				throw new NotFoundException("Invalid Status..");
			}
		
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("fetching Inquiry by status failed.", e.getMessage()),HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
