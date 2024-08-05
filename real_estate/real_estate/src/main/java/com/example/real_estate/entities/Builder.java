package com.example.real_estate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "builder")
public class Builder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@Size(max=50)
	private String firstName;
	
	@NotBlank
	@Size(max=50)
	private String lastName;
	
	@NotBlank
	@Size(max=50)
	private String licenseNo;
	
	@Size(max =10)
	@Column(unique = true)
	private Long contact;
	
	@Column(unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String businessName;

	public Builder() {
		super();
	}

	public Builder(int id, @NotBlank @Size(max = 50) String firstName, @NotBlank @Size(max = 50) String lastName,
			@NotBlank @Size(max = 50) String licenseNo, @Size(max = 10) Long contact,
			@Email @NotBlank @Size(max = 100) String email, @NotBlank String password, @NotBlank String businessName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.licenseNo = licenseNo;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.businessName = businessName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Override
	public String toString() {
		return "Builder [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", licenseNo=" + licenseNo
				+ ", contact=" + contact + ", email=" + email + ", password=" + password + ", businessName="
				+ businessName + "]";
	}
	
	
}
