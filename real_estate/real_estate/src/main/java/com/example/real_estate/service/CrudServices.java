package com.example.real_estate.service;

import java.util.List;

public interface CrudServices<T, K> {

	  //add user
			T create(T t);
			
			//get all user
			List<T> fetchAll();
			
			//get user
			T fetchById(K k);
			
			//update user
			T update (T t1, T t2);
			
			//delete user
			 String delete(T t);
			 
}
