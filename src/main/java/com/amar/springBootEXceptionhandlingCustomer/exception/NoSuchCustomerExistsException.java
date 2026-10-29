package com.amar.springBootEXceptionhandlingCustomer.exception;

public class NoSuchCustomerExistsException extends RuntimeException {
	
	
	public  NoSuchCustomerExistsException() {}
	public  NoSuchCustomerExistsException(String msg) {
		super(msg);
		
	}

}
