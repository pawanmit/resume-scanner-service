package com.parser.utils.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.microsoft.ooxml.OOXMLParser;
import org.xml.sax.SAXException;

import com.parser.exception.ExtractorException;

public class TikaFileExtractor implements FileExtractor {

	private static Logger logger = Logger.getLogger(TikaFileExtractor.class);

	public String extract(String inputFileName) throws ExtractorException {

		File inputFile = new File(inputFileName);
		BufferedInputStream inputStream = null;

		try {
			inputStream = new BufferedInputStream(
					new FileInputStream(inputFile));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			throw new ExtractorException("Error reading file " + inputFileName);
		}

		TikaConfig config = TikaConfig.getDefaultConfig();

		// AutoDetectReader

		Metadata metadata = new Metadata();

		Parser parser1 = new OOXMLParser();

		Parser parser2 = new AutoDetectParser();

		ParseContext parseContext = new ParseContext();

		SaxEventHandler handler = new SaxEventHandler();

		try {
			parser2.parse(inputStream, handler, metadata, parseContext);
		} catch (java.io.IOException e) {
			logger.error(e.getMessage());
			throw new ExtractorException("Error scanning file " + inputFileName);
		} catch (SAXException e) {
			logger.error(e.getMessage());
			throw new ExtractorException("Error building content for "
					+ inputFileName);
		} catch (TikaException e) {
			logger.error(e.getMessage());
			throw new ExtractorException("Tika Error parsing file "
					+ inputFileName);
		}

		return handler.getBodyContent();

	}
}
