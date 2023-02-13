package com.example.hibernate.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OurNewexceptionHandler {

	@ExceptionHandler(Exception.class)
	ResponseEntity<String> handleexception()
	{
		ResponseEntity<String> re= new ResponseEntity<>("Got exception",HttpStatus.INTERNAL_SERVER_ERROR);
	return re;
	}
	

	@ExceptionHandler(IOException.class)
	ResponseEntity<String> handleIOexception()
	{
		ResponseEntity<String> re= new ResponseEntity<>("Got IOexception",HttpStatus.INTERNAL_SERVER_ERROR);
	return re;
	}
	
	@ExceptionHandler(ClassNotFoundException.class)
	ResponseEntity<String> handleClassNotFoundexception()
	{
		ResponseEntity<String> re= new ResponseEntity<>("Got Class naot found exception",HttpStatus.INTERNAL_SERVER_ERROR);
	return re;
	}
	
	
}
