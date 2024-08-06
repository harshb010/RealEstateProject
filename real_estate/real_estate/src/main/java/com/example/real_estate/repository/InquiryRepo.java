package com.example.real_estate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate.entities.Inquiry;
import com.example.real_estate.entities.Inquiry.enquiryStatus;

public interface InquiryRepo extends JpaRepository<Inquiry, Integer> {

	List<Inquiry> findByStatus(enquiryStatus status);
}
