package com.tioba.printerbackend.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tioba.printerbackend.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		StandardError error = new StandardError();
		
		error.setTimestamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Resource Not Found");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatusCode statusCode, WebRequest request) {

		StandardError error = new StandardError();
		
		error.setTimestamp(Instant.now());
		error.setError("Error: ");
		error.setMessage(ex.getMessage());
		error.setStatus(statusCode.value());
		error.setPath(request.getContextPath());
		
		return ResponseEntity.status(error.getStatus()).body(error);
	}
}
