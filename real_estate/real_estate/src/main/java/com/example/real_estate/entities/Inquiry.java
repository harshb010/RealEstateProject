package com.example.real_estate.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "inquiries")
public class Inquiry {

	public enum enquiryStatus{
		NEW, RESPONDED, CLOSED
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enquiryId;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Agent agent;
	
	@ManyToOne
	private Builder builder;
	
	private Date enquiryDate;
	
	@Enumerated(EnumType.STRING)
	private enquiryStatus status;
	
	private String enquiryDetails;

	public Inquiry() {
		super();
	}

	public Inquiry(int enquiryId, User user, Agent agent, Builder builder, Date enquiryDate, enquiryStatus status,
			String enquiryDetails) {
		super();
		this.enquiryId = enquiryId;
		this.user = user;
		this.agent = agent;
		this.builder = builder;
		this.enquiryDate = enquiryDate;
		this.status = status;
		this.enquiryDetails = enquiryDetails;
	}

	public int getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Builder getBuilder() {
		return builder;
	}

	public void setBuilder(Builder builder) {
		this.builder = builder;
	}

	public Date getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	public enquiryStatus getStatus() {
		return status;
	}

	public void setStatus(enquiryStatus status) {
		this.status = status;
	}

	public String getEnquiryDetails() {
		return enquiryDetails;
	}

	public void setEnquiryDetails(String enquiryDetails) {
		this.enquiryDetails = enquiryDetails;
	}

	@Override
	public String toString() {
		return "Inquiry [enquiryId=" + enquiryId + ", agent=" + agent + ", enquiryDate=" + enquiryDate
				+ ", enquiryDetails=" + enquiryDetails + "]";
	}
	
	
}
