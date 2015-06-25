package Parser;

import java.util.ArrayList;

import control.FileTypeMapping;
import jsputil.CreateFixedTable;
import objects.Structure;
import dbutil.FileReaderFixed;
import dbutil.FileUtilCSV;
import dbutil.FileUtilFixed;
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
			System.out.println(rd.getFileType() + "~~~~~");
			
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
		
		if (true) {
			System.out.println("~~~~~~~~~~~~~~Fixed~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			ReadFixedXML fix = new ReadFixedXML("C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml");
			System.out.println(fix.getFileList().get(0).getTable().getTitleList());
			System.out.println(fix.getFileType());
		}
		
		if (false) {
			ReadFixedXML fix = new ReadFixedXML("C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml");
			FileReaderFixed frf = new FileReaderFixed("C:\\Users\\znsong\\Documents\\My Received Files\\KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00.txt");
			FileUtilFixed fuf = new FileUtilFixed("C:\\Users\\znsong\\Documents\\My Received Files\\KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00.txt",fix.getFileList().get(0));
//			fuf.setFileSample(fix.getFileList().get(0)); 
//			frf.setFileSample(fix.getFileList().get(0));
			
			System.out.println(fuf.getPage(50, 1));
			
			//System.out.println(test);
//			System.out.println(frf.getHasTitle());
//			System.out.println(frf.fromFixedLineToArray(frf.readLine(), false, true));
//			System.out.println(frf.fromFixedLineToArray(frf.readLine(), true, false));
//			//System.out.println(fuf.washString(frf.fromFixedLineToArray(frf.readLine(), false, false).get(2)));
//			System.out.println(fuf.washArray(frf.fromFixedLineToArray(frf.readLine(), false, false)));
//			System.out.println(frf.readLine());
//			System.out.println(frf.readLine());
		}
		
//		CreateFixedTable cft = new CreateFixedTable("C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml", "C:\\Users\\znsong\\Documents\\My Received Files\\KXCV00P.GB.GLOBAL.BIN.RANGE.G3586V00.txt");
//		System.out.println(cft.createTable(1, 20));
//		//System.out.println(cft.getTailer());
//		System.out.println("~~~~~~~~~~~~~~");
//		System.out.println(cft.createTailerTable());
		FileTypeMapping ftm = new FileTypeMapping("C:\\Users\\znsong\\Documents\\My Received Files\\structure.xml", "C:\\Users\\znsong\\Documents\\My Received Files\\structureFixed.xml");
		System.out.println(ftm.getFileSample("GLOBAL_BIN_RANGE").getFileType());
	}
}
