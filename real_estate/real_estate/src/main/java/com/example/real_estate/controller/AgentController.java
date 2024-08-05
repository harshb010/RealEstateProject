package com.example.real_estate.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.real_estate.customexception.AgentNotFoundException;
import com.example.real_estate.dto.ErrorResponse;
import com.example.real_estate.entities.Agent;
import com.example.real_estate.service.AgentService;


@RestController
@RequestMapping("/agent")
public class AgentController {

	@Autowired
	private AgentService agentService;

	@PostMapping("/add")
	public ResponseEntity<?> registerdUser(@RequestBody Agent agent) {
		Agent createdAgent = agentService.create(agent);
		return new ResponseEntity<>(createdAgent, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllAgents() {
		try {
			return new ResponseEntity<>(agentService.fetchAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("Agent Fetching is failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/{agentId}")
	public ResponseEntity<?> getUserById(@PathVariable("agentId") Integer id) {
		try {
			return  ResponseEntity.ok(agentService.fetchById(id));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce=
		    new ErrorResponse("User Fetching is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{agentId}")
	public ResponseEntity<?> updateuserById(@PathVariable("agentId") Integer id,
			@RequestBody Agent updateUser) {
		try {
			Agent existingUser=agentService.fetchById(id);
			
			return  ResponseEntity.ok(agentService.update(updateUser, existingUser));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce= new ErrorResponse("User updation is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{agentId}")
	public ResponseEntity<?>deleteUserById(@PathVariable ("agentId") Integer id)
	{ try {
		Agent existingUser=agentService.fetchById(id);
		return ResponseEntity.ok(agentService.delete(existingUser));
				
	} catch (Exception e) {

		ErrorResponse errorResponce= new ErrorResponse("User deletion is failead", e.getMessage());
		return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		
	}
		
	}
//	@GetMapping("/getbyName/{name}")
//	public ResponseEntity<?> getUserByUserName(@PathVariable String name){
//		try {
//			ResponseEntity res = null;
//			Agent foundUser = agentService.fetchAgentByAgentName(name);
//			if(foundUser != null) {
//				return res.ok(foundUser);
//			
//			}else {
//				throw new AgentNotFoundException("Invalid Username..");
//			}
//		
//		} catch (Exception e) {
//			return new ResponseEntity<>(new ErrorResponse("fetching user by username failed.", e.getMessage()),HttpStatus.BAD_REQUEST);
//		}
//		
//		
//	}
}
