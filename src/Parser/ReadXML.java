package Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ReadXML {
	private String filepath = "";
	private DocumentBuilder db= null;
	private DocumentBuilderFactory dbf= null;
	private File file = null;
	private Document doc = null;
	private Element root = null;
	 
	private void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	private void setDocumentBuilderFactory() {
		this.dbf = DocumentBuilderFactory.newInstance(); 
	}
	 
	 private void setDocumentBuilder() {
		 try {
			this.db = this.dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 
	 private void setFile() {
		 this.file = new File(this.filepath);
	 }
	 
	 private void setDoc(DocumentBuilder db) {
		 try {
			this.doc = db.parse(this.file);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 private void setRoot(Document doc) {
		 this.root = doc.getDocumentElement();
	 }
	 
	 public ReadXML(String filepath) {
		 /*
		setFilepath(filepath);
		System.out.println(this.filepath);
		setFile();
		setDocumentBuilderFactory();
		setDocumentBuilder();
		setDoc(this.db);
		setRoot(this.doc);
		
		System.out.println(root.getNodeName());
		//System.out.println(root.getTextContent());
		System.out.println(root.getAttributes().getNamedItem("class").getTextContent());
		
		NodeList childnodes = root.getChildNodes();
		Node detail = childnodes.item(5);
		if (detail.getNodeName() == "#text") {
			System.out.println("haha123");
		}
		//System.out.println(detail.getTextContent());
		System.out.println(detail.getNodeName());
		System.out.println(childnodes.getLength());
	
		NodeList childnodes2 = detail.getChildNodes();
		Node detail2 = childnodes2.item(1);
		System.out.println("~~~~~~~~~~~~~~~~~~");
		System.out.println(detail2.getAttributes().getNamedItem("value").getTextContent());
		System.out.println(detail2.getNodeName());
		System.out.println(detail2.getTextContent());
		if (detail2.getTextContent().equals(""))
			System.out.println("empty!!!!!!");
		System.out.println(childnodes2.getLength());
		
		System.out.println("this is the end of the test");
		
		*/
		 setFilepath(filepath);
		System.out.println(this.filepath);
		setFile();
		setDocumentBuilderFactory();
		setDocumentBuilder();
		setDoc(this.db);
		setRoot(this.doc);
		
		System.out.println(root.getNodeName());
		NodeList files = root.getChildNodes();
		System.out.println(files.item(1).getNodeName());
		System.out.println(files.getLength());
 
	}
	 
// those are private methods
	 
	 /*
	  * get the index number in dom using child index
	  */
	 private int setNum(int number) {
		 return number*2-1;
	 }
	 
	 /*
	  * get the child index using the index in dom
	  */
	 private int getNum(int number) {
		 return (number+1)/2;
	 }
	 
}