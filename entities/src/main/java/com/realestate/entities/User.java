package com.realestate.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int userId;
	
	@NotBlank(message = " First Name is Mandatory")
	public String firstName;
	
	@NotNull
	public String lastName;
	
	@NotNull
	public  String address;
	
	@NotNull
	public long contact;
	
	@NotNull
	public String email;
	
	@NotNull
	public String password;
	
	@NotNull
	public String role;
	
	public String businessName;
	public String regNo;
	
	public User() {
		super();
	}

	public User(int userId, String firstName, String lastName, String address, long contact, String email,
			String password, String role, String businessName, String regNo) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.role = role;
		this.businessName = businessName;
		this.regNo = regNo;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", contact=" + contact + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", businessName=" + businessName + ", regNo=" + regNo + "]";
	}

}
