package com.wns.sp.migration.api.exceptionhandling;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * ExceptionHandlerControllerAdvice class to handle the all Exception occurs in the application
 * @author Dilip
 *
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleResourceNotFound(ResourceNotFoundException exception,
			HttpServletRequest request) {

		ExceptionResponse errorResponse = new ExceptionResponse();
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.toString());
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.callerURL(request.getRequestURI());

		return errorResponse;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(Exception exception,
			 HttpServletRequest request) {

		ExceptionResponse errorResponse = new ExceptionResponse();
		errorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.callerURL(request.getRequestURI());

		return errorResponse;
	}

}
