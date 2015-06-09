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
	
	/*
	 * get the batch in ArrayList through batchID or batchTime
	 */
	public List<String> getBatch(String BH, String batchID, String batchTime) {
		ArrayList<String> batchList = new ArrayList<String>();

		return batchList;
	}
	
	/*
	 * get the list of all batches
	 * allBatches - batchList - batch
	 */
	public ArrayList<ArrayList<ArrayList<String>>> readInBatch() throws Exception {
		String readLine = null;
		int lineLength = 0;
		boolean inBatch = false;
		ArrayList<ArrayList<String>> batchList = new ArrayList<ArrayList<String>>();
		ArrayList<String> batch = new ArrayList<String>();
		ArrayList<ArrayList<ArrayList<String>>> allBatches = new ArrayList<ArrayList<ArrayList<String>>>();
		
		while(true) {
			readLine = fr.readLine();
			batch = fr.fromCSVLinetoArray(readLine);
			lineLength = batch.size();
			if (lineLength == 0)
				break;
			else {
				if (inBatch) {
					if(isBatchFooter(batch)) {
						batchList.add(batch);
						allBatches.add(batchList);
						inBatch = false;
						batchList = new ArrayList<ArrayList<String>>();
					}
					else {
						batchList.add(batch);
					}
				}
				else {
					if (isBatch(batch)) {
						batchList.add(batch);
						inBatch = true;
					}
					else
						continue;
				}
			}
		}
		return allBatches;
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
	
	private boolean isBatch(ArrayList<String> batch) {
		boolean isBatch = false;
		if (batch.get(0).equals(structure.getBatchHeader()))
			isBatch = true;		
		return isBatch;
	}
	
	private boolean isBatchFooter(ArrayList<String> batch) {
		boolean isFooter = false;
		if (batch.get(0).equals(structure.getBatchFooter()))
			isFooter = true;
		return isFooter;
	}
}
