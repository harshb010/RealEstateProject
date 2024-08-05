package com.example.real_estate.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="appointments")
public class Appointment {

	public enum AppointmentStatus{
		SCHEDULED,COMPLETED,CANCELLED
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointmentId;
	
	@ManyToOne
	private Agent agent;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Property property;
	
	private Date appointmentDate;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;

	public Appointment() {
		super();
	}

	public Appointment(int appointmentId, Agent agent, User user, Property property, Date appointmentDate,
			AppointmentStatus status) {
		super();
		this.appointmentId = appointmentId;
		this.agent = agent;
		this.user = user;
		this.property = property;
		this.appointmentDate = appointmentDate;
		this.status = status;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", agent=" + agent + ", property=" + property
				+ ", appointmentDate=" + appointmentDate + "]";
	}
	
	
}
