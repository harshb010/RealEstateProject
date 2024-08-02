package com.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestate.entities.User;

public interface userRepo extends JpaRepository<User, Integer>{

	//User findByUserName(String name);
}
