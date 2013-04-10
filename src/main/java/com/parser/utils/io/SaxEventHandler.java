package com.parser.utils.io;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class SaxEventHandler implements ContentHandler {

	public StringBuffer elementContent = new StringBuffer();

	private boolean isBodyElement = false;

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (isBodyElement) {
			elementContent.append(ch);
		}

	}

	public void endDocument() throws SAXException {

	}

	
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

	}

	
	public void endPrefixMapping(String prefix) throws SAXException {

	}

	
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {

	}

	
	public void processingInstruction(String target, String data)
			throws SAXException {
	}

	
	public void setDocumentLocator(Locator locator) {

	}

	
	public void skippedEntity(String name) throws SAXException {

	}

	
	public void startDocument() throws SAXException {
	}

	
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		if (localName == "body") {
			isBodyElement = true;
		}

	}

	
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {

	}

	public String getBodyContent() {

		return elementContent.toString();

	}
}
