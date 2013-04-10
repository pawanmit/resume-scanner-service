package com.parser.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.parser.exception.ExtractorException;
import com.parser.exception.ParserException;
import com.parser.service.FileExtractorService;
import com.parser.service.FileExtractorServiceImpl;
import com.parser.service.ResumeScanService;
import com.parser.service.ResumeScanServiceImpl;

public class ExtractorTest {
	private static Logger logger = Logger.getLogger(ExtractorTest.class);

	public static void main(String args[]) {
		ResumeScanService resumeScanService = new ResumeScanServiceImpl();
		FileExtractorService fileExtractorService = new FileExtractorServiceImpl();

		List<String> keywords = new ArrayList<String>();
		keywords.add("red");
		keywords.add("cross");
		Map keywordCountMap = new HashMap();
		String fileContent = "";
		try {
			fileContent = fileExtractorService
					.extractFileContent("/tmp/1.pdf");
		} catch (ExtractorException ee) {
			logger.error(ee.getMessage());
		}
		logger.debug(fileContent);
		try {
			keywordCountMap = resumeScanService.findKeywordCount(fileContent,
					keywords);
		} catch (ParserException pe) {
			logger.error(pe.getMessage());
		}

		for (Object keyword : keywordCountMap.keySet()) {
			logger.info(keyword.toString() + ":" + keywordCountMap.get(keyword));
		}

		
	}
}
