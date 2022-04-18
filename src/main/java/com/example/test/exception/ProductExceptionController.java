package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
	   @ExceptionHandler(value = ProductNotFoundException.class)
	   public ResponseEntity<Object> exception(ProductNotFoundException exception) {
	      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	   }
	   
	   @ExceptionHandler(value = AlreadyClaimedException.class)
	   public ResponseEntity<Object> exception(AlreadyClaimedException exception) {
	      return new ResponseEntity<>("Product Deal Already Over", HttpStatus.NO_CONTENT);
	   }
	   
	   @ExceptionHandler(value = DealClosedException.class)
	   public ResponseEntity<Object> exception(DealClosedException exception) {
	      return new ResponseEntity<>("Deal closed", HttpStatus.NO_CONTENT);
	   }
	   
	   
	   
}

