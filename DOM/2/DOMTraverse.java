import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTraverse {
  private static boolean setValidation = false; //defaults
  private static String uri;

  public DOMTraverse() {
    try {
      DocumentBuilderFactory factory = 
          DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      factory.setValidating(setValidation);
      Document doc = builder.parse(uri);
      traverse(doc.getDocumentElement(), "   ");
      
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
    }
  }
 
  public void traverse (Node node, String indent) {
    if ( node == null )
      return;

    int type = node.getNodeType();
    switch (type) {
    case Node.DOCUMENT_NODE:
      System.out.println(indent + "[Document] " + node.getNodeName());
      break;
        		
    case Node.ENTITY_NODE:
      System.out.println(indent + "[ENTITY] " + node.getNodeName());
      break;
        
    case Node.ELEMENT_NODE:
      System.out.println(indent + "[Element] " + node.getNodeName());
      break;

    case Node.ENTITY_REFERENCE_NODE:
      System.out.print(indent + "[ENTITY_REFERENCE] " + node.getNodeName());
      break;

    case Node.CDATA_SECTION_NODE:
        System.out.print(indent + "[CDATA_SECTION] ");
        System.out.print(node.getNodeName());
        System.out.println("  " + node.getNodeValue());
        break;

    case Node.COMMENT_NODE:
        System.out.print(indent + "[COMMENT] ");
        System.out.print(node.getNodeName());
        System.out.println("  " + node.getNodeValue());
        break;

    case Node.TEXT_NODE:
        System.out.print(indent + "[TEXT] ");
        System.out.print(node.getNodeName());
        System.out.println("  " + node.getNodeValue());
        break;
    }

    NodeList children = node.getChildNodes();
    if (children != null) {
      int len = children.getLength();
      for (int i = 0; i < len; i++)
        traverse(children.item(i), indent + "   ");
    }
  } // print(Node)

  public static void main(String argv[]) {
    if ( argv.length == 0) {
      System.err.println("Usage: java DOMTraverse uri ...");
      System.exit(1);
    }
    if (argv[0].equals("-v")) {
      setValidation = true;
      uri = argv[1];
    } else if (argv[0].equals("-V")) {
      setValidation = false;
      uri = argv[1];
    } else
      uri = argv[0];
			
    DOMTraverse dt = new DOMTraverse();
  } // main(String[])
}
