import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.SAXException;

public class AddDeleteNode {
	static String uri;
	static String outputUri;

	  public AddDeleteNode() {
	    try {
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document doc = builder.parse(uri);
	      Node node = doc.getDocumentElement();
	      NodeList children = node.getChildNodes();
	      Element item = doc.createElement("melon");
	      item.appendChild(doc.createTextNode("Melon"));
	      Attr attrItem = doc.createAttribute("color");
	      attrItem.setValue("green");
	      item.setAttributeNode(attrItem);
	      node.insertBefore(item, children.item(3));
	      node.insertBefore(doc.createTextNode("\n"), children.item(4));

	      Node selectedNode = children.item(0);
	      node.removeChild(selectedNode);
	      selectedNode = children.item(0);
	      node.removeChild(selectedNode);

	      selectedNode = children.item(3);
	      Node attr = selectedNode.getAttributes().item(1);
	      ((Element) selectedNode).removeAttributeNode((Attr) attr);
	      
	      DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();    
	      DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("XML 3.0 LS 3.0");
	      LSSerializer serializer = impl.createLSSerializer();
	      serializer.getDomConfig().setParameter("format-pretty-print", true);
	      LSOutput output = impl.createLSOutput();
	      
	      FileOutputStream fw = new FileOutputStream(outputUri);
	      output.setByteStream(fw);
	      serializer.write(doc, output);
	      fw.close();
	      
	    } catch (FactoryConfigurationError e) {
	    	// unable to get a document builder factory
	    	e.printStackTrace(System.err);
	    } catch (ParserConfigurationException e) {
	    	// parser was unable to be configured
	    	e.printStackTrace(System.err);
	    } catch (SAXException e) {
	    	// parsing error
	    	e.printStackTrace(System.err);
	    } catch (IOException e) {
	    	// i/o error
	    	e.printStackTrace(System.err);
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassCastException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] argv) {
	    if (argv.length == 0) {
	      System.err.println("Usage: java AddDeleteNode uri ...");
	      System.exit(1);
	    }
	    uri = argv[0];
	    outputUri = argv[1];
	    AddDeleteNode nt = new AddDeleteNode();
	}
}
