package com.learning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThreadingCompanies implements Keywords {
	
private String fileName;
	
	public ThreadingCompanies(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<String> getKeywords() throws IOException {
		
		List<String> list = new ArrayList<>();
		String[] str;
		String pathToCSV = "/home/sarithab/Downloads/"+fileName+".txt";
		String line = "";
			try (BufferedReader in = new BufferedReader(new FileReader(pathToCSV))) {
		
			while ((line = in.readLine()) != null) {
				str=line.split(",");
			String companyname = str[0].replaceAll("\\d","").trim();
				list.add(companyname);	
		} 

		return list;
	}
	}
}
