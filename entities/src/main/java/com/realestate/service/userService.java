package com.realestate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.realestate.entities.User;
import com.realestate.repository.userRepo;

@Service
public class userService {

	@Autowired
	private userRepo userRepoRef;
	
	public ResponseEntity<?> addUser(User userRef)
	{
		try {
			
			return new ResponseEntity<>(userRepoRef.save(userRef),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Unable to Add ",HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> getAllUser()
	{
		try {
			
			return new ResponseEntity<>(userRepoRef.findAll(),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("User Not Found ",HttpStatus.BAD_REQUEST);
		}
	}
	
//	public ResponseEntity<?> getUserByName(String name)
//	{
//		try {
//			
//			return new ResponseEntity<>(userRepoRef.findByUserName(name),HttpStatus.OK);
//			
//		} catch (Exception e) {
//			return new ResponseEntity<>("User Not Found ",HttpStatus.NOT_FOUND);
//		}
//	}
	
	public ResponseEntity<?> updateUser(User UpdatedUser, Integer id)
	{
		try {
			
			User user = userRepoRef.findById(id).orElseThrow();
			user.firstName = UpdatedUser.firstName;
			user.email = UpdatedUser.email;
			user.address = UpdatedUser.address;
			user.businessName = UpdatedUser.businessName;
			user.contact = UpdatedUser.contact;
			user.lastName = UpdatedUser.lastName;
			
			return new ResponseEntity<>(userRepoRef.save(user),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("User Already Exist ",HttpStatus.BAD_REQUEST);
		}
	}
	public ResponseEntity<?> deleteUser(Integer id)
	{
		try {
			
			User user = userRepoRef.findById(id).orElseThrow();
			userRepoRef.delete(user);
			return new ResponseEntity<>("User Deleted ",HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>("User Not Found ",HttpStatus.NOT_FOUND);
		}
	}
}
