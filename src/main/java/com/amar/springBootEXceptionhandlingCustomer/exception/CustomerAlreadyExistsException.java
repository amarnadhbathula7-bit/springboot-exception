package com.amar.springBootEXceptionhandlingCustomer.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
	
	 
	public CustomerAlreadyExistsException() {}
	public CustomerAlreadyExistsException(String msg) {
		super(msg);
		 
	}

}
