package dbutil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import objects.FileSample;
import objects.Table;

public class FileReaderFixed {
    // file encode 
    public static final String ENCODE = "UTF-8";  
  
    private FileInputStream fis = null;  
    private InputStreamReader isw = null;  
    private BufferedReader br = null;  
    private FileSample fs = null;
    private Table table = null;
	private int totalLength = 0;
	private boolean hasTitle = false;
	private boolean hasTailer = false;
	private ArrayList<Integer> headerStart = null;
	private ArrayList<Integer> contentStart = null;
	private ArrayList<Integer> headerEnd = null;
	private ArrayList<Integer> contentEnd = null;
	private ArrayList<Integer> tailerStart = null;
	private ArrayList<Integer> tailerEnd = null;
	
  
	public FileReaderFixed(String filename) throws Exception {  
        fis = new FileInputStream(filename);  
        isw = new InputStreamReader(fis, ENCODE);  
        br = new BufferedReader(isw);
    }
    
    public FileReaderFixed(String filename, FileSample fs) throws Exception { 
    	setFileSample(fs);
        fis = new FileInputStream(filename);  
        isw = new InputStreamReader(fis, ENCODE);  
        br = new BufferedReader(isw);
    }   
	    
    //we should set the fileSample first before reading the file for the fixed file. 
    //While for the CSV file, we do not have to read the sample first.
    public void setFileSample(FileSample fs) {
    	this.fs = fs;
    	this.table = fs.getTable();
    	this.totalLength = table.getTotalLength();
    	this.hasTitle = table.getHasTitle();
    	this.hasTailer = table.getHasTailer();
    	this.headerStart = table.header.getStartList();
    	this.headerEnd = table.header.getEndList();
    	this.contentStart = table.content.getStartList();
    	this.contentEnd = table.content.getEndList();
    	this.tailerStart = table.tailer.getStartList();
    	this.tailerEnd = table.tailer.getEndList();
    	
    }
    
    public boolean getHasTitle() {
    	return hasTitle;
    }
    
    public boolean getHasTailer() {
    	return hasTailer;
    }
    
    
    // =========Public Methods=============================  
    /** 
     * Read a line from the fixed file
     * 
     * @throws Exception 
     */  
    public String readLine() throws Exception {
    	String temp = br.readLine();
        return temp;
    }
    
    /**
     * 
     * @param source
     * @param isHeader
     * @return
     */
    public ArrayList<String> fromFixedLineToArray(String source, boolean isHeader, boolean isTailer) {
    	ArrayList<String> array = new ArrayList<String>();
    	int length = totalLength;
    	int finish = 0;
    	int count = 0;
    	
    	if (isHeader) {
    		while (finish < length) {
    			finish = headerEnd.get(count);
    			array.add(nextToken(source, headerStart.get(count), finish));
    			count++;
    		}
    	}
    	else if (isTailer) {
    		while (finish < length) {
    			finish = tailerEnd.get(count);
    			array.add(nextToken(source, tailerStart.get(count), finish));
    			count++;
    		}
    	}
    	else {
    		while (finish < length) {
    			finish = contentEnd.get(count);
    			array.add(nextToken(source, contentStart.get(count), finish));
    			count++;
    		}
    	}
    	
    	return array;
    }

    // ==========Private Methods=============================  
    /**
     * 
     * @param source
     * @param start
     * @param end
     * @return
     */
    private String nextToken(String source, int start, int end) {
    	StringBuffer strb = new StringBuffer();  
        int next = start - 1;  
        while (next < end) {  
            char ch = source.charAt(next);
            strb.append(ch);
            next++;
        }
        return strb.toString();  
    }
    
 
}
