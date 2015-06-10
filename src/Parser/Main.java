package Parser;

import java.util.ArrayList;

import objects.Structure;
import dbutil.FileUtil;

public class Main {
	public static void main(String args[]) throws Exception {
		//FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008.csv");
		//FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\MVX5N5KZ9CTX8_receipt_2014-05-15-446.csv");
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
		
		ReadXML rd = new ReadXML("C:\\Users\\znsong\\Documents\\My Received Files\\structure.xml");
		
		TestTable tt = new TestTable();
		System.out.println(tt.getTable());
		
		Structure structure = rd.getFileList().get(2).getStructure();
		System.out.println(structure.getBatchFooter());
		FileUtil fu = new FileUtil("C:\\Users\\znsong\\Documents\\My Received Files\\MVX5N5KZ9CTX8_receipt_2014-05-15-446.csv");
		fu.setStructure(structure);
		ArrayList<ArrayList<ArrayList<String>>> fileInBatch = fu.readInBatch();
		System.out.println(fileInBatch.get(3).get(2111).get(2));
		
		ArrayList<ArrayList<String>> get200 = fu.get50Batch(fileInBatch,2, 3);
		System.out.println(get200.size());
		
	}
}
