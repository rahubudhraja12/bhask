package com.ecom.inventorymanagement.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/*The Error handling  is done by this class*/

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/* Returns the error message when the URL is undefined */
    /**
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(IdNotFoundException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    } 
    @ExceptionHandler( NameAlreadyExistsException.class)
    public ResponseEntity<?> resourceAlreadyExistsException( NameAlreadyExistsException ex, WebRequest request) {
         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    } 
    
    /* Returns the error message when there error in server */ 
    
    /**
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

