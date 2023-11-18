import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ErrorHandler;

class SimpleErrorHandler implements ErrorHandler {
	public void warning(SAXParseException e) throws SAXException {
		System.out.println(e.getMessage());
	}
	public void error(SAXParseException e) throws SAXException {
		System.out.println(e.getMessage());
	}
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println(e.getMessage());
	}
}
