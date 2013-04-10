package com.parser.service;

import org.apache.log4j.Logger;

import com.parser.exception.ExtractorException;
import com.parser.utils.io.FileExtractor;
import com.parser.utils.io.TikaFileExtractor;

public class FileExtractorServiceImpl implements FileExtractorService {
	private static Logger logger = Logger
			.getLogger(FileExtractorServiceImpl.class);

	public String extractFileContent(String fileName) throws ExtractorException {
		// Get file contents

		FileExtractor fileExtractor = new TikaFileExtractor();

		String content = "";

		try {
			content = fileExtractor.extract(fileName);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new ExtractorException(e.getMessage());
		}
		return content;
	}

}
