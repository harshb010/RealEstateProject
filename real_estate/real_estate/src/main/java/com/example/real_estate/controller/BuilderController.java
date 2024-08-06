package com.example.real_estate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.real_estate.dto.ErrorResponse;
import com.example.real_estate.entities.Builder;
import com.example.real_estate.service.BuilderService;


@CrossOrigin("*")
@RestController
@RequestMapping("/builder")
public class BuilderController {

	@Autowired
	private BuilderService builderService;

	@PostMapping("/add")
	public ResponseEntity<?> registerdBuilder(@RequestBody Builder builder) {
		Builder createdUser = builderService.create(builder);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllBuilders() {
		try {
			return new ResponseEntity<>(builderService.fetchAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("Builder Fetching is failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/{builderId}")
	public ResponseEntity<?> getUserById(@PathVariable("builderId") Integer id) {
		try {
			return  ResponseEntity.ok(builderService.fetchById(id));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce=
		    new ErrorResponse("Builder Fetching is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{builderId}")
	public ResponseEntity<?> updateBuilderById(@PathVariable("builderId") Integer id,
			@RequestBody Builder updateUser) {
		try {
			Builder existingUser=builderService.fetchById(id);
			
			return  ResponseEntity.ok(builderService.update(updateUser, existingUser));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce= new ErrorResponse("Builder updation is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{builderId}")
	public ResponseEntity<?>deleteBuilderById(@PathVariable ("builderId") Integer id)
	{ try {
		Builder existingUser=builderService.fetchById(id);
		return ResponseEntity.ok(builderService.delete(existingUser));
				
	} catch (Exception e) {

		ErrorResponse errorResponce= new ErrorResponse("Builder deletion is failead", e.getMessage());
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


