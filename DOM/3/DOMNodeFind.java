import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class DOMNodeFind {
  private static String uri;

  public DOMNodeFind(String findNode) {
    try {
      DocumentBuilderFactory factory = 
          DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(uri);
      nodeFind(doc.getDocumentElement(), findNode);
      
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
    
  public void nodeFind (Node node, String eleName) {
    if ( node == null)  return;

    NodeList children = node.getChildNodes();
    for (int i = 0; i < children.getLength(); i++) {
      Node child = children.item(i);

      if (child.getNodeName().equals(eleName)) {
        System.out.print("[" + getDepth(child) + ", ");
        System.out.print(getSiblingIndex(child) +"] ");
        System.out.println(child.getNodeName());
      }

      nodeFind(child, eleName);
    }
  } // print(Node)

  // Calculate  the depth of the current element.
  public int getDepth(Node node) {
    int index = 0;
    while ((node = node.getParentNode()) != null)  index++;
    return index;
  }
		
  // Calculate the element index for each depth (starting from 1) -----//
  protected int getSiblingIndex(Node node) {
    int index=1;
		
    while( (node = node.getPreviousSibling()) != null) 
    if(node.getNodeType() != Node.TEXT_NODE		
          && node.getNodeType() != Node.COMMENT_NODE)
      index++;
      
    return index;		
  }

  public static void main(String argv[]) {
    if ( argv.length == 0 || argv.length > 2) {
      System.err.println("Usage: java DOMNodeFind node_name uri ...");
      System.exit(1);
    }
			
    String findNode = argv[0];
    uri = argv[1];
			
    DOMNodeFind dt = new DOMNodeFind(findNode);
  } // main(String[])
}
