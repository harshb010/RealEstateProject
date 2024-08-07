package com.example.real_estate.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate.entities.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

	List<Appointment> findByAppointmentDate(Date appointmentDate);
}
