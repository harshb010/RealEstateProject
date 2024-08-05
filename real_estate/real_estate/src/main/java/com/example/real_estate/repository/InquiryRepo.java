package com.example.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate.entities.Inquiry;

public interface InquiryRepo extends JpaRepository<Inquiry, Integer> {

}
