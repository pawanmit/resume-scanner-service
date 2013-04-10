package com.parser.client.output;

import java.util.HashMap;
import java.util.Map;

public class KeywordsCountMap {

	private Map<String, Integer> keywordCountMap;
	private String error;

	public KeywordsCountMap() {
		keywordCountMap = new HashMap<String, Integer>();
		error = "";
	}

	public Map<String, Integer> getKeywordCountMap() {
		return keywordCountMap;
	}

	public void setKeywordCountMap(Map<String, Integer> keywordCountMap) {
		this.keywordCountMap = keywordCountMap;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
