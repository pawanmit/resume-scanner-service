package com.parser.utils.analysis;

import java.util.List;
import java.util.Map;

import com.parser.exception.AnalyzerException;

public interface ResumeAnalyser {
	
	/**
	 * 
	 * @param keyword List List of keywords to look for.
	 * @param content Content to scan
	 * @param ignoreCase boolean to check if search is case sensitive
	 * 
	 * @return A map, mapping keywords to their count in content
	 * @throws AnalysisException
	 */
	public Map<String, Integer> getCount(List<String> keywordList, String content, boolean ignoreCase) throws AnalyzerException;
	

}
