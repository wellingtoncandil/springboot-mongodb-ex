package com.wellington.springmongo.resource.exception;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wellington.springmongo.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	
	@ExceptionHandler(ObjectNotFoundException.class)
	private ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		String date = sdf.format(System.currentTimeMillis());
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(date, status.value(), e.getMessage(), "Objeto não encontrado" , request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
