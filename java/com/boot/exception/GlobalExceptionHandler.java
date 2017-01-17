package com.boot.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import com.boot.exception.UserIdExistException;
import com.boot.model.ExceptionResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserIdExistException.class)
	public ResponseEntity<ExceptionResponse> notFound() {
		ExceptionResponse er = new ExceptionResponse();
		er.setCode(HttpStatus.BAD_REQUEST.value());
		er.setMessage("Existing ID");
		System.out.println("----ID Exception----");

		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.BAD_REQUEST);

	}
}