package com.ecom.inventorymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NameAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 1L;

    public NameAlreadyExistsException(String message){
        super(message);
    }
}