package com.parser.utils.io;

import com.parser.exception.ExtractorException;

public interface FileExtractor {

	/**
	 * This method reads a file and returns the content as plain text
	 * 
	 * @param inputFileName Location of the file to be parsed
	 * @return Parsed content as plain text
	 */
	public String extract(String inputFileName) throws ExtractorException; 
}
