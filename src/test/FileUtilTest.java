package test;

import dbutil.FileReaderCSV;
import dbutil.ReadCSVXML;
import Parser.TestTable;

public class FileUtilTest {
	public void test200line() {
		
	}
	
	public void testFileReader() throws Exception {
		//FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008.csv");
				FileReaderCSV fr = new FileReaderCSV("C:\\Users\\znsong\\Documents\\My Received Files\\MVX5N5KZ9CTX8_receipt_2014-05-15-446.csv");
				/*
				System.out.println(fr.fromCSVLinetoArray(fr.readLine()));
				System.out.println(fr.readLine());
				System.out.println(fr.readLine());
				System.out.println(fr.fromCSVLinetoArray(fr.readLine()));
				System.out.println(fr.fromCSVLinetoArray(fr.readLine()));
				System.out.println(fr.fromCSVLinetoArray(fr.readLine()));
				System.out.println(fr.fromCSVLinetoArray(fr.readLine()));
				System.out.println(fr.fromCSVLinetoArray(fr.readLine()));
				System.out.println(fr.fromCSVLinetoArray(fr.readLine()));
				System.out.println(fr.fromCSVLinetoArray(fr.readLine()));
				System.out.println(fr.fromCSVLinetoArray(fr.readLine()));
				System.out.println(fr.fromCSVLinetoArray(null));
				System.out.println(fr.fromCSVLinetoArray(fr.readLine()));
				*/
	}
	
	public void testTable() throws Exception {
		TestTable tt = new TestTable();
		tt.getTable();
	}
	
	public void testXML() {
		ReadCSVXML rd = new ReadCSVXML("C:\\Users\\znsong\\Documents\\My Received Files\\structure.xml");
	}
	
}
