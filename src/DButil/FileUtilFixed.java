package dbutil;

import java.util.ArrayList;
import java.util.Iterator;

import objects.FileSample;
import objects.Structure;
import Parser.Error;

public class FileUtilFixed {
	private FileReaderFixed fr;
	private String path = null;
	private FileSample fs = null;
	private Structure structure = null;
	public Error err;
	
	public FileUtilFixed(String path) throws Exception {
		this.path = path;
		fr = new FileReaderFixed(this.path);
		
	}
	
	public FileUtilFixed(String path, FileSample fs) throws Exception {
		this.path = path;
		this.fs = fs;
		fr = new FileReaderFixed(this.path, this.fs);
		
	}
	
	public void setFileSample(FileSample fs) {
		this.fs = fs;
		this.fr.setFileSample(fs);
		this.structure = fs.getStructure();
	}
	
	/**
	 * read the file into ArrayList<ArrayList<String (After data wash)
	 * with header and footer - if there is one
	 * @return
	 * @throws Exception
	 */
	public ArrayList<ArrayList<String>> readFile() throws Exception {
		ArrayList<ArrayList<String>> fileArray = new ArrayList<ArrayList<String>>();
		String temp = fr.readLine();
		String nextTemp = fr.readLine();
		System.out.println(nextTemp);
		boolean hasHeader = fr.getHasTitle();
		boolean hasTailer = fr.getHasTailer();
		
		if (hasHeader) {
			if (temp.equals(""))
				err.err(40);
			else {
				fileArray.add(washArray(fr.fromFixedLineToArray(temp, hasHeader, false)));
				temp = nextTemp;
				nextTemp = fr.readLine();
			}
		}
		if (temp.equals("")) { //there is only one line of header, no content
			return fileArray;
		}
		else {
			
			while(!(nextTemp == null)) {
				fileArray.add(washArray(fr.fromFixedLineToArray(temp, false, false)));
				temp = nextTemp;
				nextTemp = fr.readLine();
				//System.out.println(temp);
				//System.out.println(nextTemp);
			}
			//if the final line is tailer
			if (hasTailer) {
				fileArray.add(washArray(fr.fromFixedLineToArray(temp, false, hasTailer)));
			}
			else {
				fileArray.add(washArray(fr.fromFixedLineToArray(temp, false, false)));
			}
		}
		
		
		return fileArray;
	}
	
	
	/*
	 * those below are private methods
	 */
	
	public ArrayList<String> washArray(ArrayList<String> array) {
		ArrayList<String> wash = new ArrayList<String>();
		Iterator<String> it = array.iterator();
		while(it.hasNext()) {
			wash.add(washString(it.next()));
		}
		return wash;
	}
	
	private String washString(String token) {
		StringBuffer sb = new StringBuffer();
		int first = getFirstChar(token);
		int length = getLength(token, first);
		int end = token.length() - 1;

		if (nextEmpty(token, first + length - 1)) {
			for (int i = 0; i < length; i++) {
				sb.append(token.charAt(first + i));
			}
		}
		else {
			for (int i = first + length + 1; i <= end; i++) {
				if (nextEmpty(token, i))
					end = i;
			}
			for (int i = first; i <= end; i++) {
				sb.append(token.charAt(i));
			}
		}
		return sb.toString();
	}
	
	//start from 0
	private int getFirstChar(String token) {
		int first = 0;
		for (int i = 0; i < token.length(); i++) {
			if (token.charAt(i) == ' ')
				continue;
			else {
				first = i;
				break;
			}
		}
		return first;
	}
	
	private int getLength(String token, int start) {
		int temp = start;
		int length = 0;
		for (int i = start; i < token.length(); i++) {
			if (token.charAt(temp) == ' ') 
				break;
			else  {
				length++;
				temp++;
			}
		}
		return length;
	}
	
	// end = start + length - 1
	private boolean nextEmpty(String token, int end) {
		boolean isEmpty = true;
		for (int i = end + 1; i < token.length(); i++) {
			if (token.charAt(i) == ' ')
				continue;
			else
				return false;
		}
		return isEmpty;
	}
}
