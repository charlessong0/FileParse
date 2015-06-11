package Parser;

import java.util.ArrayList;

import objects.Structure;
import dbutil.FileReaderFixed;
import dbutil.FileUtilCSV;
import dbutil.ReadCSVXML;
import dbutil.ReadFixedXML;

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
		
		if (false) {
			System.out.println("~~~~~~~~~~~~~~CSV~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			ReadCSVXML rd = new ReadCSVXML("C:\\Users\\znsong\\Documents\\My Received Files\\structure.xml");
			
			TestTable tt = new TestTable();
			System.out.println(tt.getTable());
			
			Structure structure = rd.getFileList().get(2).getStructure();
			System.out.println(structure.getBatchFooter());
			FileUtilCSV fu = new FileUtilCSV("C:\\Users\\znsong\\Documents\\My Received Files\\MVX5N5KZ9CTX8_receipt_2014-05-15-446.csv");
			fu.setStructure(structure);
			ArrayList<ArrayList<ArrayList<String>>> fileInBatch = fu.readInBatch();
			System.out.println(fileInBatch.get(3).get(2111).get(2));
			
			ArrayList<ArrayList<String>> get200 = fu.get50Batch(fileInBatch,2, 3);
			System.out.println(get200.size());
		}
		
		if (false) {
			System.out.println("~~~~~~~~~~~~~~Fixed~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			ReadFixedXML fix = new ReadFixedXML("C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml");
			System.out.println(fix.getFileList().get(0).getTable().getTitleList());
		}
		
		ReadFixedXML fix = new ReadFixedXML("C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml");
		FileReaderFixed frf = new FileReaderFixed("C:\\Users\\znsong\\Documents\\My Received Files\\KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00.txt");
		frf.setFileSample(fix.getFileList().get(0));
		System.out.println(frf.getHasTitle());
		System.out.println(frf.fromFixedLineToArray(frf.readLine(), false, true));
		System.out.println(frf.fromFixedLineToArray(frf.readLine(), true, false));
		System.out.println(frf.fromFixedLineToArray(frf.readLine(), false, false));
		System.out.println(frf.readLine());
		System.out.println(frf.readLine());
	}
}
