package com.parser.exception;

/**
 * Exception thrown in case there is a problem extracting content from the
 * document.
 * 
 * @author Pawan
 * 
 */
public class ExtractorException extends Exception {

	public ExtractorException(String message) {
		super(message);
	}
}
