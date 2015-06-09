package Parser;

import java.util.ArrayList;

import objects.Structure;
import dbutil.FileUtil;

public class Main {
	public static void main(String args[]) throws Exception {
		FileReader fr = new FileReader("C:\\Users\\znsong\\Documents\\My Received Files\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008.csv");
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
		
		ReadXML rd = new ReadXML("C:\\Users\\znsong\\Documents\\My Received Files\\structure.xml");
		TestTable tt = new TestTable();
		tt.getTable();
		
		Structure structure = rd.getFileList().get(0).getStructure();
		System.out.println(structure.getBatchFooter());
		FileUtil fu = new FileUtil("C:\\Users\\znsong\\Documents\\My Received Files\\US-eBay-EOM-Fees@ebay.com.TRR-20140702.01.008.csv");
		fu.setStructure(structure);
		ArrayList<ArrayList<ArrayList<String>>> fileInBatch = fu.readInBatch();
		System.out.println(fileInBatch.get(0).get(0).get(1));
	}

}
