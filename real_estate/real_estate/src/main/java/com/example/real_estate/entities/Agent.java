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
@Table(name ="agent")
public class Agent {

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
	
	//@Size(max =10)

	private Long contact;
	
	@Column(unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;
	
	private String password;

	public Agent() {
		super();
	}

	public Agent(int id, @NotBlank @Size(max = 50) String firstName, @NotBlank @Size(max = 50) String lastName,
			@NotBlank @Size(max = 50) String licenseNo, Long contact,
			@Email @NotBlank @Size(max = 100) String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.licenseNo = licenseNo;
		this.contact = contact;
		this.email = email;
		this.password=password;
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
	@Override
	public String toString() {
		return "Agent [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", licenseNo=" + licenseNo
				+ ", contact=" + contact + ", email=" + email + " password=" +password+"]";
	}

	
	
	
	
}
