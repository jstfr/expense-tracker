package com.nemo.expense_tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(CategoryExceptionHandler.NotFound.class)
	public ResponseEntity<String> handleCategoryNotFound(CategoryExceptionHandler.NotFound ex){
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(CategoryExceptionHandler.AlreadyExists.class)
	public ResponseEntity<String> handleCategoryNameExist(CategoryExceptionHandler.AlreadyExists ex){
		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(ExpenseExceptionHandler.NotFound.class)
	public ResponseEntity<String> handleExpenseNotFound(ExpenseExceptionHandler.NotFound ex) {
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(ex.getMessage());
	}
	
	@ExceptionHandler(RuntimeException.class) 
	public ResponseEntity<String> handleUnexpected(RuntimeException ex) {
	        return ResponseEntity
	        		.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Unexpected error: " + ex.getMessage());
    }
}
