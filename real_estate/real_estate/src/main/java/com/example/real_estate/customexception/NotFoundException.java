package com.example.real_estate.customexception;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String msg)
	{
		super(msg);
	}
}
