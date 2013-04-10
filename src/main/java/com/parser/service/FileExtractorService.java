package com.parser.service;

import com.parser.exception.ExtractorException;

public interface FileExtractorService {

	/**
	 * Extracts file as a string
	 * 
	 * @param fileName
	 * @return file contents
	 */
	public String extractFileContent(String fileName) throws ExtractorException;

}
