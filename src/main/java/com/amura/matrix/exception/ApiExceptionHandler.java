package com.amura.matrix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.amura.matrix.model.ErrorResponse;

/**
 * Handles Exceptions and returns exceptions by wrapping it in ErrorResponse
 * 
 * @author Sayali Doshi
 * @since 29-03-2019
 */

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler
	public final ResponseEntity<Object> handleApiException(ApiException apiException) {
		ErrorResponse errorResponse = ErrorResponse.builder().message(apiException.getMessage()).build();
		return new ResponseEntity<>(errorResponse, apiException.getHttpStatus());
	}

	@ExceptionHandler
	public final ResponseEntity<Object> handleAllException(Exception exception) {
		ErrorResponse errorResponse = ErrorResponse.builder().message(exception.getMessage()).build();
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
