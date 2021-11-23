package com.gasbooking.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class BankNotFoundException  extends Exception{
   public BankNotFoundException(String msg) {
	   super(msg);
   }
}
