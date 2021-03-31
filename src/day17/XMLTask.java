package day17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

//read all data
public class XMLTask {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		dbf.setValidating(true);
		dbf.setIgnoringElementContentWhitespace(true);
		DocumentBuilder db=dbf.newDocumentBuilder();
		
		Document dom=db.parse(new FileInputStream("books.xml"));
		
		Element e=dom.getDocumentElement();
		getNodes(e);
	}
	public static void getNodes(Element e) {
		if(e.hasChildNodes()) {
			NodeList nodeList=e.getChildNodes();
			for(int i=0;i<nodeList.getLength();i++) {
				if(nodeList.item(i).hasChildNodes()) {
					getNodes((Element) nodeList.item(i));
				}else {
					System.out.println(nodeList.item(i).getNodeValue());
				}
			}
		}
		System.out.println(e.getNodeName());
	}
}
