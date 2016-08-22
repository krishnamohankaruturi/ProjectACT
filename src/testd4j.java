import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

public class testd4j {

	public static void main(String[] args) {
		try {
			
			String xmlString = "<root><people>Allen</people></root>";
			
			
			Document document = DocumentHelper.parseText(xmlString);
			
			System.out.println(document.asXML());
		} catch (DocumentException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
