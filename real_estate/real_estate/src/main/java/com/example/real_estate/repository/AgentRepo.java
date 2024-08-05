package com.example.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate.entities.Agent;

public interface AgentRepo extends JpaRepository<Agent, Integer> {

	//Agent findByAgentName(String name);

}
