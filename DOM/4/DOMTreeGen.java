import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

public class DOMTreeGen {

	public static void main(String[] args) {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element root = doc.createElement("book_catalog");

			Element item = doc.createElement("book");
			Element subitem = doc.createElement("title");
			subitem.appendChild( doc.createTextNode("XML Programming"));
			item.appendChild(subitem);

			subitem = doc.createElement("author");
			subitem.appendChild( doc.createTextNode("J. Chae"));
			item.appendChild(subitem);
			
			subitem = doc.createElement("publisher");
			subitem.appendChild( doc.createTextNode("Hongreung publishing company"));
			item.appendChild(subitem);
			root.appendChild(item);
			
			item = doc.createElement("book");
			subitem = doc.createElement("title");
			subitem.appendChild( doc.createTextNode("Web Programming"));
			item.appendChild(subitem);

			subitem = doc.createElement("author");
			subitem.appendChild( doc.createTextNode("G. Hong"));
			item.appendChild(subitem);
			
			subitem = doc.createElement("publisher");
			subitem.appendChild( doc.createTextNode("Science publishing company"));
			item.appendChild(subitem);
			root.appendChild(item);
			
			doc.appendChild(root);
			
			DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();    
			DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
			LSSerializer serializer = impl.createLSSerializer();
			serializer.getDomConfig().setParameter("format-pretty-print", true);
			LSOutput output = impl.createLSOutput();
			
			FileOutputStream fos = new FileOutputStream(args[0]);
			output.setByteStream(fos);
			serializer.write(doc, output);
			fos.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
