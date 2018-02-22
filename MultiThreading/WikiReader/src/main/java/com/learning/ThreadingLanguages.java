package com.learning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadingLanguages implements Keywords {
	 static final Logger log=Logger.getLogger(ThreadingLanguages.class.getName());
	
private String fileName;
	
	public ThreadingLanguages(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<String> getKeywords() throws IOException {
		String[] str = null;
		List<String> list = new ArrayList<>();
		String pathToCSV = basePath +fileName+".txt";
		try (BufferedReader in = new BufferedReader(new FileReader(pathToCSV))){
		String line = null;
		 line=in.readLine();
			while ((line = in.readLine()) != null) {
			if(!line.contains("}}")) {
				str = line.split("\n");
				list.addAll(Arrays.asList(str));
			}
			}
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		
		return list;
	}

}
