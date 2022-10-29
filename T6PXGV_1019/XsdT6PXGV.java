package SaxT6PXGV1019

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;


public class XsdT6PXGV {

	public static void main(String[] args) {
		
		System.out.println("XSD Validation succesful "+validateXMLSchema("UM_kurzusfelvetel.xsd", "UM_kurzusfelvetel.xml"));

	}
	
	public static boolean validateXMLSchema(String xsdPath, String xmlPath){
        
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File("UM_kurzusfelvetel.xsd"));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File("UM_kurzusfelvetel.xml")));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        }
        return true;
    }

}
