package dbutil;

import objects.Structure;
import Parser.Error;

public class FileUtilFixed {
	private FileReaderCSV fr;
	private String path = null;
	private Structure structure = null;
	public Error err;
	
	public FileUtilFixed(String path) throws Exception {
		this.path = path;
		fr = new FileReaderCSV(this.path);
	}
	
	public ArrayList readFile() {
		
	}
}
