package net.kzn.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	String message;
	public ProductNotFoundException() {
		this("product is not available");
	}
	public ProductNotFoundException(String message) {
		this.message=message;
	}
	

}
