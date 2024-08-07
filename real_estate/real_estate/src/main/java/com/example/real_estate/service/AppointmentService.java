package com.example.real_estate.service;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.real_estate.customexception.NotFoundException;
import com.example.real_estate.entities.Appointment;
import com.example.real_estate.repository.AppointmentRepo;


@Service
public class AppointmentService implements CrudServices<Appointment, Integer> {

	@Autowired
	public AppointmentRepo appointmentRepo; 
	
	@Override
	public Appointment create(Appointment appointment) {
			return appointmentRepo.save(appointment);
	}

	@Override
	public List<Appointment> fetchAll() {
		return appointmentRepo.findAll();
	}

	@Override
	public Appointment fetchById(Integer id) {
		return appointmentRepo.findById(id).orElseThrow(()->  new NotFoundException("Invalid Id"));
	}

	@Override
	public Appointment update(Appointment updatedAppointment, Appointment existingAppointment) {
		existingAppointment.setAppointmentDate(updatedAppointment.getAppointmentDate());
		existingAppointment.setStatus(updatedAppointment.getStatus());
		return appointmentRepo.save(existingAppointment);
	}

	@Override
	public String delete(Appointment appointment) {
		appointmentRepo.delete(appointment);
		return appointment.getAppointmentId() + " deleted";
	}

	public List<Appointment> fetchAppointmentByAppointmentDate(Date appointmentDate) {
		return appointmentRepo.findByAppointmentDate(appointmentDate);
	}
}
