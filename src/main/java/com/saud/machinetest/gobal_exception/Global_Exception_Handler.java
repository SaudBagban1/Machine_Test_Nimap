package com.saud.machinetest.gobal_exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.saud.machinetest.custom_exception.Custom_Exception;

//Global Exception Handler Class
@RestControllerAdvice
public class Global_Exception_Handler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = Custom_Exception.class)
	public ResponseEntity<?> resourceNotFound(Custom_Exception custom_Exception) {
		String message = custom_Exception.getMessage();
		return new ResponseEntity(message, HttpStatus.NOT_FOUND);
	}

}
