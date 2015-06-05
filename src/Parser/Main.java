package Parser;

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
		
	}

}
