package com.parser.client.filter;

import org.apache.log4j.Logger;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class ParserResponseFilter implements ContainerResponseFilter {

	private static Logger logger = Logger.getLogger(ParserResponseFilter.class);

	public ContainerResponse filter(ContainerRequest request,
			ContainerResponse response) {

		String requestPath = request.getPath();

		logger.info("Returning response for request " + requestPath);

		logger.debug("Returning Entity: " + (response.getEntity().toString()) + "\n");

		return response;
	}

}
