package com.example.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler  {

	@ExceptionHandler(ProductException.class)
	public String handleProductNotFoundException(ProductException e) {
		return e.getMessage();
	}
}
