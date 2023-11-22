import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

public class AddElement {
  private static String uri;
  public AddElement() {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(uri);

      Node node = doc.getDocumentElement();
      NodeList children = node.getChildNodes();
      Element item = doc.createElement("melon");
      item.appendChild(doc.createTextNode("Melon"));
      node.insertBefore(item, children.item(3));
      children = node.getChildNodes();
      Node selected_Node = children.item(3);
      String outName = selected_Node.getNodeName();
      System.out.println("item(3)=" + outName);

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
  public static void main(String argv[]) {
    if ( argv.length == 0) {
      System.err.println("Usage: java AddElement uri ...");
      System.exit(1);
    }
    uri = argv[0];		
    AddElement nt = new AddElement();
  }
}