package XmlRead;

import java.io.File;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	public static void main(String[] args) {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			
			//DOM analisies XML File
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("MonoDevelop.Xml.xml"));
			Element root = document.getDocumentElement();
			NodeList list = root.getElementsByTagName("member");
			for (int i = 0; i < list.getLength(); i++) {
				Element members = (Element) list.item(i);
				System.out.println("------------");
				System.out.println("name = "+members.getAttribute("name"));
				
				NodeList clist =members.getChildNodes();
				for (int j = 0; j < clist.getLength(); j++) {
					Node cElement =  clist.item(j);
					if(cElement instanceof Element){
					System.out.println(cElement.getNodeName() + " = "+cElement.getTextContent());
					}
					
				}
			}
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
