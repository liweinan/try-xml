package net.bluedash.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TrySax extends HandlerBase {

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String value = new String(ch, start, length);
		if (!value.trim().equals("")) {
			System.out.println("Text: " + value);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End Document");
		super.endDocument();
	}

	@Override
	public void endElement(String name) throws SAXException {
		System.out.println("End Element:" + name);
		super.endElement(name);
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start Document.");
		super.startDocument();
	}

	@Override
	public void startElement(String name, AttributeList attributes)
			throws SAXException {
		System.out.println("Start Element: " + name);
		for (int i = 0, n = attributes.getLength(); i < n; ++i)
			System.out.println("Attribute: " + attributes.getName(i) + "="
					+ attributes.getValue(i));
		super.startElement(name, attributes);
	}

	public static void main(String args[]) throws Exception {
		InputStream data_xml = TryDom.class.getResourceAsStream("/data.xml");
		InputStreamReader reader = new InputStreamReader(data_xml);

		InputSource source = new InputSource(reader);
		HandlerBase handler = new TrySax();

		SAXParserFactory factory = SAXParserFactory.newInstance();
		String parserClassName = "javax.xml.parsers.SAXParser";
		SAXParser parser = factory.newSAXParser();

		parser.parse(source, handler);

	}
}
