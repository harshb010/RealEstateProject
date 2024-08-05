package com.example.real_estate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.real_estate.customexception.AgentNotFoundException;
import com.example.real_estate.entities.Agent;
import com.example.real_estate.repository.AgentRepo;

@Service
public class AgentService implements CrudServices<Agent, Integer> {
	
	@Autowired
	private AgentRepo agentRepo;
	
	@Override
	public  Agent create(Agent agent) {
		return agentRepo.save(agent);
	}

	@Override
	public List<Agent> fetchAll() {
		
		return agentRepo.findAll();
	}

	@Override
	public Agent fetchById(Integer id) {
		return agentRepo.findById(id).orElseThrow(() -> new AgentNotFoundException("Invalid id"));
	}

	@Override
	public Agent update(Agent updatedAgent, Agent existingAgent) {
		existingAgent.setFirstName(updatedAgent.getFirstName());
		existingAgent.setLastName(updatedAgent.getLastName());
		existingAgent.setContact(updatedAgent.getContact());
		existingAgent.setEmail(updatedAgent.getEmail());
		return agentRepo.save(existingAgent);
	}

	@Override
	public String delete(Agent Agent) {
		agentRepo.delete(Agent);
		return Agent.getId() + "deleted";
	}
	
//	public Agent fetchAgentByAgentName(String name) {
//		return agentRepo.findByAgentName(name);
//	}
	}

