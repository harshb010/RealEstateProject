package com.example.real_estate.entities;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="property")
public class Property {

//	 public enum PropertyType {
//
//			RESIDENTIAL,COMMERCIAL,INDUSTRIAL
//		}

		public enum ListingType {
			
			FOR_SALE, SOLD
		}

	  public enum Status{
			ACTIVE, UNDER_CONTRACT, CLOSED
		}
	 
	  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyId;
	
	@NotBlank
	private String streetAddress; 
	
	@NotBlank
	public String city;
	
	@NotNull
	private int zipcode;
	
	@NotBlank
	private String state;
	
//	 @Enumerated(EnumType.STRING)
//	 @NotNull
//	 private PropertyType propertyType;
	 
	 @Enumerated(EnumType.STRING)
	 @NotNull
	 private ListingType listingType;
	 
	 @Enumerated(EnumType.STRING)
	  @NotNull
	  private Status status;
	 
	 @NotNull
	 private BigDecimal price;
	 
	 @Column(name = "lot_size")
	    private BigDecimal lotSize;

	  @Column(name = "building_size")
	  private BigDecimal buildingSize;

	  private Integer bedrooms;

	  private Integer bathrooms;

	  @Column(name = "year_built")
	  private Integer yearBuilt;

	  @Column(columnDefinition = "TEXT")
	    private String photos;
	  
	  @Column(name = "agent_id")
	  private int agentId;

	 
	public Property() {
		super();
	}

	public Property(int propertyId, @NotBlank String streetAddress, @NotBlank String city, @NotBlank int zipcode,
			@NotBlank String state, ListingType listingType, @NotBlank BigDecimal price,
			BigDecimal lotSize, BigDecimal buildingSize, Integer bedrooms, Integer bathrooms, Integer yearBuilt,
			String photos, Status status, int agentId) {
		super();
		this.propertyId = propertyId;
		this.streetAddress = streetAddress;
		this.city = city;
		this.zipcode = zipcode;
		this.state = state;
//		this.propertyType = propertyType;
		this.listingType = listingType;
		this.price = price;
		this.lotSize = lotSize;
		this.buildingSize = buildingSize;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.yearBuilt = yearBuilt;
		this.photos = photos;
		this.status = status;
		this.agentId = agentId;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

//	public PropertyType getPropertyType() {
//		return propertyType;
//	}
//
//	public void setPropertyType(PropertyType propertyType) {
//		this.propertyType = propertyType;
//	}

	public ListingType getListingType() {
		return listingType;
	}

	public void setListingType(ListingType listingType) {
		this.listingType = listingType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getLotSize() {
		return lotSize;
	}

	public void setLotSize(BigDecimal lotSize) {
		this.lotSize = lotSize;
	}

	public BigDecimal getBuildingSize() {
		return buildingSize;
	}

	public void setBuildingSize(BigDecimal buildingSize) {
		this.buildingSize = buildingSize;
	}

	public Integer getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	public Integer getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}

	public Integer getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(Integer yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", zipcode=" + zipcode + ", state=" + state + ", price=" + price + ", lotSize=" + lotSize
				+ ", buildingSize=" + buildingSize + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms
				+ ", yearBuilt=" + yearBuilt + ", photos=" + photos + ", agentId=" + agentId + "]";
	}
	  
	  
}
