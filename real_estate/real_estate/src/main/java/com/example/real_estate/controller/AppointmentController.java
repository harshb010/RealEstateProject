package com.example.real_estate.controller;

import java.sql.Date;
import java.util.List;
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
import com.example.real_estate.customexception.NotFoundException;
import com.example.real_estate.dto.ErrorResponse;
import com.example.real_estate.entities.Appointment;
import com.example.real_estate.service.AppointmentService;


@CrossOrigin("*")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/add")
	public ResponseEntity<?> registerdAppointment(@RequestBody Appointment appointment) {
		Appointment createdAppointment = appointmentService.create(appointment);
		return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllAppointments() {
		try {
			return new ResponseEntity<>(appointmentService.fetchAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("Appointment Fetching is failed", e.getMessage()),
					HttpStatus.BAD_REQUEST);
		}

	}
	@GetMapping("/{appointmentId}")
	public ResponseEntity<?> getInquiryById(@PathVariable("appointmentId") Integer id) {
		try {
			return  ResponseEntity.ok(appointmentService.fetchById(id));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce=
		    new ErrorResponse("Appointment Fetching is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{appointmentId}")
	public ResponseEntity<?> updatePropertyById(@PathVariable("appointmentId") Integer id,
			@RequestBody Appointment updateAppointment) {
		try {
			Appointment existingAppointment=appointmentService.fetchById(id);
			
			return  ResponseEntity.ok(appointmentService.update(updateAppointment, existingAppointment));
			
		} catch (Exception e) {
			
			ErrorResponse errorResponce= new ErrorResponse("Appointment updation is failed", e.getMessage());
			return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/delete/{appointmentId}")
	public ResponseEntity<?>deleteAppointmentById(@PathVariable ("appointmentId") Integer id)
	{ try {
		Appointment existingAppointment=appointmentService.fetchById(id);
		return ResponseEntity.ok(appointmentService.delete(existingAppointment));
				
	} catch (Exception e) {

		ErrorResponse errorResponce= new ErrorResponse("Appointment deletion is failead", e.getMessage());
		return new ResponseEntity<>(errorResponce,HttpStatus.BAD_REQUEST);
		
	}
		
	}
	@GetMapping("/getbydate/{appointmentDate}")
	public ResponseEntity<?> getPropertyByCityName(@PathVariable("appointmentDate") Date appointmentDate){
		try {
			ResponseEntity res = null;
			List<Appointment> foundAppointment = appointmentService.fetchAppointmentByAppointmentDate(appointmentDate);
			if(foundAppointment != null) {
				return res.ok(foundAppointment);
			
			}else {
				throw new NotFoundException("Invalid Appointment Date..");
			}
		
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponse("fetching Appointment By Date failed.", e.getMessage()),HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
