package com.gasbooking.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SurrenderCylinderNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 914569459626622748L;
	
	public SurrenderCylinderNotFoundException(String msg) {
		super(msg);
	}
}