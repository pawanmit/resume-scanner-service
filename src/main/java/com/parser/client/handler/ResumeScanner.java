package com.parser.client.handler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.parser.client.output.KeywordsCountMap;
import com.parser.exception.ExtractorException;
import com.parser.exception.ParserException;
import com.parser.service.FileExtractorService;
import com.parser.service.FileExtractorServiceImpl;
import com.parser.service.ResumeScanService;
import com.parser.service.ResumeScanServiceImpl;

@Path("/scan")
public class ResumeScanner {

	private static Logger logger = Logger.getLogger(ResumeScanner.class);

	@GET
	@Path("/keywords/")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getKeywordCount(@QueryParam("filepath") String filePath,
			@QueryParam("keywords") String keywords) {

		String[] keywordsArray = new String[0];
		if (keywords != null) {
			keywordsArray = keywords.split(",");
		}

		KeywordsCountMap keywordsCountMap = new KeywordsCountMap();
		if (keywordsArray.length < 1) {
			keywordsCountMap.setError("No keywords found");
			return generateResponseAsJson(keywordsCountMap);
		} else {

			List<String> keywordList = Arrays.asList(keywordsArray);

			ResumeScanService resumeScanService = new ResumeScanServiceImpl();
			FileExtractorService fileExtractorService = new FileExtractorServiceImpl();

			Map<String, Integer> keywordsCount = new HashMap<String, Integer>();
			String fileContent = "";
			try {
				fileContent = fileExtractorService.extractFileContent(filePath);
			} catch (ExtractorException ee) {
				logger.error(ee.getMessage());
				keywordsCountMap.setError(ee.getMessage());
				return generateResponseAsJson(keywordsCountMap);
			}
			try {
				keywordsCount = resumeScanService.findKeywordCount(fileContent,
						keywordList);
			} catch (ParserException e) {
				logger.error(e.getMessage());
				keywordsCountMap.setError(e.getMessage());
				return generateResponseAsJson(keywordsCountMap);
			}
			keywordsCountMap.setKeywordCountMap(keywordsCount);

			return generateResponseAsJson(keywordsCountMap);
		}

	}

	private Response generateResponseAsJson(Object output) {
		JSONObject json = new JSONObject();
		json.put("output", output);
		return Response.ok(json, MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "http://localhost")
				.build();

	}
}
