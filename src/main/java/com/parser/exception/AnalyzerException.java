package com.parser.exception;

/**
 * Exception thrown in case of an error analysing the document after successful
 * extraction and parsing
 * 
 * @author Pawan
 * 
 */
public class AnalyzerException extends Exception {

	public AnalyzerException(String message) {
		super(message);
	}

}
