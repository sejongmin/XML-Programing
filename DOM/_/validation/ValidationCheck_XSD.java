import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ValidationCheck_XSD {
	public static String xmlFile;
	public static String xsdFile;
	public static boolean validationCheck = false;

	public ValidationCheck_XSD() {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			SchemaFactory schemaFactory = null;
			if (validationCheck) {
				factory.setValidating(false);
				factory.setNamespaceAware(true);
				schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        
				factory.setSchema(schemaFactory.newSchema(new Source[] { new StreamSource(xsdFile) }));
			}
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		catch (SAXException e) { e.printStackTrace(); } 
		catch (IOException e) { e.printStackTrace(); }
	}
  
	public static void main(String[] args) {
		if (args.length <= 1) {
			System.err.println
			("Java ValidationCheck usage XML_file XSD_file -v");
			System.err.println
			("[-v] : validation on / none : validation off");
			System.exit(1);
		}
    
		xmlFile = args[0];
		xsdFile = args[1];
		
		if (args.length == 3) {
			if (args[2].equals("-v")) {
				validationCheck = true;
			}
		}
		ValidationCheck_XSD vc = new ValidationCheck_XSD();
	}
}
