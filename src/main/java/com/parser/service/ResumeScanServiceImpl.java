package com.parser.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.parser.exception.AnalyzerException;
import com.parser.exception.ParserException;
import com.parser.utils.analysis.BasicResumeAnalyser;
import com.parser.utils.analysis.ResumeAnalyser;

public class ResumeScanServiceImpl implements ResumeScanService {

	private static Logger logger = Logger
			.getLogger(ResumeScanServiceImpl.class);

	public Map<String, Integer> findKeywordCount(String content,
			List<String> keywordList) throws ParserException {

		// System.out.println("Content:" + content);
		ResumeAnalyser resumeAnalyser = new BasicResumeAnalyser();

		Map<String, Integer> keywordCountMap = new HashMap<String, Integer>();

		// If no error in extracting file content then proceed with analysis
		try {
			keywordCountMap = resumeAnalyser.getCount(keywordList, content,
					true);
		} catch (AnalyzerException e) {
			e.printStackTrace();
			throw new ParserException(e.getMessage());
		}
		// System.out.println("Keywords Scanned " +
		// keywordCountMap.keySet().size());
		return keywordCountMap;
	}

}
