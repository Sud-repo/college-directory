package com.leucinetech.college_directory.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Sudharshan
 */

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestErrorController {

	Logger log = LoggerFactory.getLogger(RestErrorController.class);
	
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleInvalidArguments(MethodArgumentNotValidException ex) {
    	Map<String, String> errorMap = new HashMap<>();
    	ex.getBindingResult().getFieldErrors()
    		.forEach(error -> errorMap.put("message", error.getDefaultMessage()));
    	log.error("MethodArgumentNotValidException Occurred, Validation failed due to Invalid Input - Handling the Exception Response.");
    	return errorMap;
    }
	 
}
