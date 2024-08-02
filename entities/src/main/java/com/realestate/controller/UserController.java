package com.realestate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.entities.User;
import com.realestate.service.userService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private userService userServiceRef;
	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User userRef)
	{
		return userServiceRef.addUser(userRef);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getUser()
	{
		return userServiceRef.getAllUser();
	}
	
//	@GetMapping("/read/{name}")
//	public ResponseEntity<?> getUserByName(@PathVariable String name)
//	{
//		return userServiceRef.getUserByName(name);
//	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User userRef, @PathVariable Integer id)
	{
		return userServiceRef.updateUser(userRef, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id)
	{
		return userServiceRef.deleteUser(id);
	}

}
