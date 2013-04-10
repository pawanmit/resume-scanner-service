package com.parser.service;

import java.util.List;
import java.util.Map;

import com.parser.exception.ParserException;

public interface ResumeScanService {

	/**
	 * This methods reads a file and scans it for keywords, returning a mapping
	 * of keywords with the count
	 * 
	 * @param content File content to parsed
	 * @param keywordList List of keywords to be scanned
	 * @return A map of keywords to count
	 */
	public Map<String, Integer> findKeywordCount(String content, List<String> keywordList) throws ParserException;
}