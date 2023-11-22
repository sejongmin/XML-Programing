import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AttributeShow {
  public static String uri;

  public AttributeShow() {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(uri);
      Node node = doc.getDocumentElement();
      traverse(node, "   ");

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

  public void traverse(Node node, String indent) {
    if (node == null)
      return;
    int type = node.getNodeType();
    switch (type) {
    case Node.DOCUMENT_NODE:
      System.out.println(indent + "[Document] " + node.getNodeName());
      break;
    case Node.ELEMENT_NODE:
      System.out.println(indent + "[Element] " + node.getNodeName());
      if (node.hasAttributes()) {
        NamedNodeMap attr = node.getAttributes();
        for (int i = 0; i < attr.getLength(); i++) {
          System.out.println("  " + indent + "[Attribute] " + attr.item(i).getNodeName() + "=" + attr.item(i).getNodeValue());
        }
      }
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
  }
  public static void main(String[] argv) {
    if (argv.length != 1) {
      System.err.println("Usage: java AttributeShow xml_file...");
      System.exit(-1);
    }
    uri = argv[0];
    AttributeShow nt = new AttributeShow();
  }
}
