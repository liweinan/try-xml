package net.bluedash.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TryDom {
	
	public static void main(String args[]) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputStream data_xml = TryDom.class.getResourceAsStream("/data.xml");
		Document doc = builder.parse(data_xml);

		Element elem = doc.getDocumentElement();
		NodeList list = elem.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			NamedNodeMap attributes = node.getAttributes();
			if (attributes != null) {
				for (int j = 0; j < attributes.getLength(); j++) {
					Node attr = attributes.item(j);
					System.out.println("attr name: " + attr.getNodeName());
					System.out.println("attr value: " + attr.getNodeValue());
				}
			}
			System.out.println("node name: " + node.getNodeName());
			System.out.println("node type: " + node.getNodeType());
			System.out.println("node value: " + node.getNodeType());
			System.out.println("content: " + node.getTextContent());
//			System.out.println("---");
		}
	}
}
