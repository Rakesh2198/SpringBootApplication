package com.mycompany.ucsa.controller;


import java.util.HashMap;


import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mycompany.ucsa.exception.CourseNotFoundException;
import com.mycompany.ucsa.exception.InvalidCardException;

@ControllerAdvice
public class ValidateHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(value = CourseNotFoundException.class)
 public ResponseEntity<Object> exception(CourseNotFoundException exception) {

	return new ResponseEntity<>("Course Not Found!!", HttpStatus.NOT_FOUND);

}

@ExceptionHandler(value = InvalidCardException.class)
public ResponseEntity<Object> exception2(InvalidCardException exception) {

	return new ResponseEntity<>("Invalid Card!!", HttpStatus.BAD_REQUEST);

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
