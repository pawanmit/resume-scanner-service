package com.parser.exception;

/**
 * Exception thrown by REST client that makes the call to resume service.
 * 
 * @author Pawan
 * 
 */
public class ClientException extends Exception {

	public ClientException(String message) {
		super(message);
	}
}
