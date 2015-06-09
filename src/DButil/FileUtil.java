package dbutil;

import java.util.ArrayList;
import java.util.List;

import objects.Structure;
import Parser.FileReader;

public class FileUtil {
	private FileReader fr;
	private String path = null;
	private Structure structure = null;
	
	public FileUtil(String path) throws Exception {
		this.path = path;
		fr = new FileReader(this.path);
	}
	
	public List<String> getBatch(String BH, String batchID, String batchTime) {
		ArrayList<String> batchList = new ArrayList<String>();
		
		
		return batchList;
	}
	
	public List<List<String>> readInBatch() throws Exception {
		String readLine = null;
		int lineLength = 0;
		boolean firstBatch = true;
		ArrayList<List<String>> batchList = new ArrayList<List<String>>();
		ArrayList<String> batch = new ArrayList<String>();
		
		while(true) {
			readLine = fr.readLine();
			lineLength = fr.fromCSVLinetoArray(readLine).size();
			if (lineLength == 0)
				break;
			else {
				if (firstBatch) {
					
					
					firstBatch = false;
				}
				else {
					
				}
			}
		}
		return batchList;
	}
	
	
	public String getPath() {
		return path;
	}
	
	public FileReader getFR() {
		return fr;
	}
	
	public void setStructure(Structure structure) {
		this.structure = structure;
	}
	
	
	// those are private methods
	/*
	 * judge the exact batch header
	 */
	private boolean exactBatch() {
		boolean exactBatch = false;
		
		return exactBatch;
	}
	
	private boolean isBatch() {
		boolean isBatch = false;
		
		return isBatch;
	}
}
