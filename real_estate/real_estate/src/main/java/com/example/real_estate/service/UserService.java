package com.example.real_estate.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.real_estate.customexception.UserNotFoundException;
import com.example.real_estate.entities.User;
import com.example.real_estate.repository.UserRepo;

@Service
public class UserService implements CrudServices<User, Integer> {


	@Autowired
	private UserRepo userRepo;
	
	@Override
	public  User create(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> fetchAll() {
		
		return userRepo.findAll();
	}

	@Override
	public User fetchById(Integer id) {
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Invalid id"));
	}

	@Override
	public User update(User updatedUser, User existingUser) {
		existingUser.setFirstName(updatedUser.getFirstName());
		existingUser.setLastName(updatedUser.getLastName());
		existingUser.setContact(updatedUser.getContact());
		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setPassword(updatedUser.getPassword());
		return userRepo.save(existingUser);
	}

	@Override
	public String delete(User user) {
		userRepo.delete(user);
		return user.getId() + "deleted";
	}
	
//	public Agent fetchAgentByAgentName(String name) {
//		return agentRepo.findByAgentName(name);
//	}
	}



