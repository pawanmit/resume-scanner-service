package com.parser.exception;

/**
 * Exception thrown in case parser is not able to parse the document (after successful extraction).
 * @author Pawan
 *
 */
public class ParserException extends Exception {

	public ParserException(String message) {
		super(message);
	}
}
