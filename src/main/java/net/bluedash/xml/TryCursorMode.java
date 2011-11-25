package net.bluedash.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class TryCursorMode {

	private void parseXML() throws IOException, XMLStreamException {

		InputStream data_xml = TryDom.class.getResourceAsStream("/data.xml");
		
		XMLInputFactory inFactory = XMLInputFactory.newInstance();
		XMLStreamReader r = inFactory.createXMLStreamReader(data_xml);

		try {
			int event = r.getEventType();
			while (true) {
				switch (event) {
				case XMLStreamConstants.START_DOCUMENT:
					System.out.println("Start Document.");
					break;
				case XMLStreamConstants.START_ELEMENT:
					System.out.println("Start Element: " + r.getName());
					for (int i = 0, n = r.getAttributeCount(); i < n; ++i)
						System.out.println("Attribute: "
								+ r.getAttributeName(i) + "="
								+ r.getAttributeValue(i));

					break;
				case XMLStreamConstants.CHARACTERS:
					if (r.isWhiteSpace())
						break;

					System.out.println("Text: " + r.getText());
					break;
				case XMLStreamConstants.END_ELEMENT:
					System.out.println("End Element:" + r.getName());
					break;
				case XMLStreamConstants.END_DOCUMENT:
					System.out.println("End Document.");
					break;
				}

				if (!r.hasNext())
					break;

				event = r.next();
			}
		} finally {
			r.close();
		}

	}

	public static void main(String args[]) throws Exception {
		TryCursorMode demo = new TryCursorMode();
		demo.parseXML();

	}
}
