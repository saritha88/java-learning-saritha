package com.learning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class ThreadingKeywords implements Keywords {
	public static final Logger log=Logger.getLogger(ThreadingKeywords.class.getName());

	private String fileName;
	
	public ThreadingKeywords(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<String> getKeywords() throws IOException {
		String[] str = null;
		List<String> list = new ArrayList<>();
		String pathToCSV = basePath + fileName + ".txt";
		String line = "";
		try (BufferedReader in = new BufferedReader(new FileReader(pathToCSV))){
			line=in.readLine();
		line=in.readLine();
		
		} catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
		}
		
		str=line.split(",");
		for(String s: str) {
			if(s.length()>0) {
			list.add(s);	
			}
		}
		
		return list;
	}

	public ThreadingKeywords() {
		super();
	}

}
