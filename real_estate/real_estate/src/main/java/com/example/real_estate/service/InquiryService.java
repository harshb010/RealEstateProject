package com.example.real_estate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.real_estate.customexception.NotFoundException;
import com.example.real_estate.entities.Inquiry;
import com.example.real_estate.entities.Inquiry.enquiryStatus;
import com.example.real_estate.repository.InquiryRepo;

@Service
public class InquiryService implements CrudServices<Inquiry, Integer> {

	@Autowired
	public InquiryRepo inquiryRepo; 
	
	@Override
	public Inquiry create(Inquiry inquiry) {
		return inquiryRepo.save(inquiry);
	}

	@Override
	public List<Inquiry> fetchAll() {
		return inquiryRepo.findAll();
	}

	@Override
	public Inquiry fetchById(Integer id) {
		return inquiryRepo.findById(id).orElseThrow(() -> new NotFoundException("Invalid id"));
	}

	@Override
	public Inquiry update(Inquiry updatedInquiry, Inquiry existingInquiry) {
		
		existingInquiry.setEnquiryDate(updatedInquiry.getEnquiryDate());
		existingInquiry.setEnquiryDetails(updatedInquiry.getEnquiryDetails());
		existingInquiry.setStatus(updatedInquiry.getStatus());
		return inquiryRepo.save(existingInquiry);
	}

	@Override
	public String delete(Inquiry inquiry) {
		inquiryRepo.delete(inquiry);
		return inquiry.getEnquiryId() + " deleted";
	}

	public List<Inquiry> fetchInquiryByStatus(enquiryStatus status) {
		return inquiryRepo.findByStatus(status);
	}
}
