package com.parser.utils.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.parser.exception.AnalyzerException;

public class BasicResumeAnalyser implements ResumeAnalyser {

	public Map<String, Integer> getCount(List<String> keywords, String content,
			boolean ignoreCase) throws AnalyzerException {

		Map<String, Integer> keywordCountMap = new HashMap<String, Integer>();

		if (ignoreCase) {
			content = content.toLowerCase();
		}
		try {
			for (String keyword : keywords) {
				if (ignoreCase) {
					keyword = keyword.toLowerCase();
				}
				int count = 0;
				Pattern p = Pattern.compile(keyword);
				Matcher m = p.matcher(content);
				while (m.find()) {
					count += 1;
				}
				keywordCountMap.put(keyword, count);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AnalyzerException("Error scanning content for keywords.");
		}
		return keywordCountMap;
	}// getCountList
}// Class
