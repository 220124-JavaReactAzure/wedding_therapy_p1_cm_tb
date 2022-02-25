package com.revature.wedding_therapy.exceptions;

@SuppressWarnings("serial")
public class InvalidRequestException extends Exception{

	public InvalidRequestException(String message) {
		super(message);
	}
}
