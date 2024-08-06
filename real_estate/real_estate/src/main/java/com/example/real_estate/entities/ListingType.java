package com.example.real_estate.entities;

import com.example.real_estate.entities.Property.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "listing")
public class ListingType {

	public enum propertyType{
		RESIDENTIAL,COMMERCIAL,INDUSTRIAL
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Agent agent;
	
	@ManyToOne
	private Property property;
	
	private String listingDate; //date when the property was listed
	
	@Enumerated(EnumType.STRING)
	private Status status; //e.g. Active
	
	@Enumerated(EnumType.STRING)
	private propertyType properties;
	
	public ListingType() {
		super();
	}

	public ListingType(int id, Agent agent, Property property, String listingDate, Status status,propertyType properties) {
		super();
		this.id = id;
		this.agent = agent;
		this.property = property;
		this.listingDate = listingDate;
		this.status = status;
		this.properties= properties;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getListingDate() {
		return listingDate;
	}

	public void setListingDate(String listingDate) {
		this.listingDate = listingDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public propertyType getProperties() {
		return properties;
	}

	public void setPropertyType(propertyType properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "ListingType [id=" + id + ", agent=" + agent + ", property=" + property + ", listingDate=" + listingDate
				+ ", status=" + status + ", Properties= "+properties+"]";
	}
	
	
}
