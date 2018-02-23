package com.reader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class CSVWriter  implements Runnable{
	public static final Logger logger=Logger.getLogger(CSVWriter.class.getName());
	
	private String message;
	private int index;
	
	
	public CSVWriter(String message, int index) {
		super();
		this.message = message;
		this.index = index;
	}


	public void run() {
		System.out.println("in writer");
		try (BufferedWriter oWriter= new BufferedWriter(new FileWriter("/home/sarithab/Documents/data/data_"+index+".csv"))){
       
			oWriter.write (message);
			
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
        
		
	}

}
