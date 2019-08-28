package harish;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidation {
	
	 public static void main(String[] args) {
//	      if(args.length !=2){
//	         System.out.println("Usage : XSDValidator <file-name.xsd> <file-name.xml>" );
//	      } 
		 
	         boolean isValid = validateXMLSchema();
	         
	         if(isValid){
	            System.out.println("valid xml");
	         } else {
	            System.out.println("not valid");
	         
	      }

}
	 public static boolean validateXMLSchema(){
	      try {
	         SchemaFactory factory =
	            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	            Schema schema = factory.newSchema(new File(
	            		"C:\\Users\\hbali\\eclipse-workspace\\harish\\src\\harish\\students.xsd"));
	            Validator validator = schema.newValidator();
	            validator.validate(new StreamSource(new File("C:\\Users\\hbali\\eclipse-workspace\\harish\\src\\harish\\students.xml")));
	      } catch (IOException e){
	         System.out.println("Exception: "+e.getMessage());
	         return false;
	      }catch(SAXException e1){
	         System.out.println("SAX Exception: "+e1.getMessage());
	         return false;
	      }
			
	      return true;
		
	   }
}
	 
