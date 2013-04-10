package com.parser.client.filter;

import org.apache.log4j.Logger;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

public class ParserRequestFilter implements ContainerRequestFilter {

	private static Logger logger = Logger.getLogger(ParserRequestFilter.class);

	public ContainerRequest filter(ContainerRequest request) {

		String requestPath = request.getPath();

		logger.info("Processing request " + requestPath);

		return request;

	}

}
