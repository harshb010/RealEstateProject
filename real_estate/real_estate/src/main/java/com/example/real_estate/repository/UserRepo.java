package com.example.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.real_estate.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
