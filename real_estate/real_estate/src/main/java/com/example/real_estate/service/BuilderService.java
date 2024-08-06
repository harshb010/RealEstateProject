package com.example.real_estate.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.real_estate.customexception.UserNotFoundException;
import com.example.real_estate.entities.Builder;
import com.example.real_estate.repository.BuilderRepo;


@Service
public class BuilderService implements CrudServices<Builder, Integer>{

	@Autowired
	private BuilderRepo builderRepo;
	
	@Override
	public  Builder create(Builder builder) {
		return builderRepo.save(builder);
	}

	@Override
	public List<Builder> fetchAll() {
		
		return builderRepo.findAll();
	}

	@Override
	public Builder fetchById(Integer id) {
		return builderRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Invalid id"));
	}

	@Override
	public Builder update(Builder updatedUser, Builder existingUser) {
		existingUser.setFirstName(updatedUser.getFirstName());
		existingUser.setLastName(updatedUser.getLastName());
		existingUser.setContact(updatedUser.getContact());
		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setPassword(updatedUser.getPassword());
		return builderRepo.save(existingUser);
	}

	@Override
	public String delete(Builder builder) {
		builderRepo.delete(builder);
		return builder.getId() + "deleted";
	}

	
	
//	public Agent fetchAgentByAgentName(String name) {
//		return agentRepo.findByAgentName(name);
//	}
}
