package com.mycompany.ucsa.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mycompany.ucsa.exception.AdmissionNotGrantedException;
import com.mycompany.ucsa.exception.ApplicantNotFoundException;
import com.mycompany.ucsa.exception.FacultyNotFoundException;
import com.mycompany.ucsa.exception.StaffMemberNotFoundException;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationAndExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = StaffMemberNotFoundException.class)
	public ResponseEntity<Object> exception(StaffMemberNotFoundException exception) {

		return new ResponseEntity<>("Staff Member Not Found!!", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = AdmissionNotGrantedException.class)
	public ResponseEntity<Object> exception(AdmissionNotGrantedException exception) {

		return new ResponseEntity<>("Admission Not Granted.", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = ApplicantNotFoundException.class)
	public ResponseEntity<Object> exceptionTwo(ApplicantNotFoundException exception) {

		return new ResponseEntity<>("Applicant Not Found!!", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = FacultyNotFoundException.class)
	public ResponseEntity<Object> exception(FacultyNotFoundException exception) {

		return new ResponseEntity<>("Faculty Not Found!!", HttpStatus.NOT_FOUND);
		
}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}

}