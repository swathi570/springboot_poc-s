package com.ojas.poc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value =  CustomException.class)
	public ResponseEntity<Object> customException(CustomException cusException){
		String localizedMessage = cusException.getLocalizedMessage();
		return new ResponseEntity<>(localizedMessage, HttpStatus.UNPROCESSABLE_ENTITY);
	}

}
