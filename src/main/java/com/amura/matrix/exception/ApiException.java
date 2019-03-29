package com.amura.matrix.exception;

import org.springframework.http.HttpStatus;

import com.amura.matrix.model.ErrorResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Exception class
 * 
 * @author Sayali Doshi
 * @since 29-03-2019
 */


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiException extends RuntimeException {

	private ErrorResponse error;
	private HttpStatus httpStatus;
	private String message;

	public ApiException(HttpStatus httpStatus, String message) {
		super(message);
		this.error = null;
		this.httpStatus = httpStatus;
		this.message = message;
	}

}
