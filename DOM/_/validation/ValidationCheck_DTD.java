import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.ErrorHandler;
import java.util.Scanner;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import static org.w3c.dom.Node.ATTRIBUTE_NODE;
import static org.w3c.dom.Node.CDATA_SECTION_NODE;
import static org.w3c.dom.Node.COMMENT_NODE;
import static org.w3c.dom.Node.DOCUMENT_TYPE_NODE;
import static org.w3c.dom.Node.ELEMENT_NODE;
import static org.w3c.dom.Node.ENTITY_NODE;
import static org.w3c.dom.Node.ENTITY_REFERENCE_NODE;
import static org.w3c.dom.Node.NOTATION_NODE;
import static org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE;
import static org.w3c.dom.Node.TEXT_NODE;

import org.w3c.dom.*;

import  org.w3c.dom.Document;
import  java.io.*;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class ValidationCheck_DTD {
	public static String xmlFile;
	public static boolean validationCheck = false;

    public ValidationCheck_DTD() {
    try {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    	if (validationCheck) {
    		factory.setValidating(validationCheck);
    	}
    	DocumentBuilder builder;
    	builder = factory.newDocumentBuilder();
    	builder.setErrorHandler(new SimpleErrorHandler());
    	Document doc = builder.parse(xmlFile);
    } catch (ParserConfigurationException e) {
    	e.printStackTrace();
    } catch (SAXException e) {
    	e.printStackTrace();
    } catch (IOException e) {
    	e.printStackTrace();
    }
}
  
public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println
          ("Java ValidationCheck_DTD usage XML_file -v");
      System.err.println
          ("[-v] : validation on / none : validation off");
      System.exit(1);
    }
    xmlFile = args[0];
    if (args.length == 2) {
      if (args[1].equals("-v")) {
        validationCheck = true;
      }
    }
    ValidationCheck_DTD vc = new ValidationCheck_DTD();
  }
}
