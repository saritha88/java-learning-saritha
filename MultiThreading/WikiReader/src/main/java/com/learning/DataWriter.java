package com.learning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataWriter implements Runnable {
	public static final Logger log = Logger.getLogger(DataWriter.class.getName());

	private String message;
	private int index;
	private String name;

	public DataWriter(String message, int index, String name) {
		super();
		this.message = message;
		this.index = index;
		this.name = name;
	}

	public void run() {
		try (BufferedWriter oWriter = new BufferedWriter(
				new FileWriter("/home/sarithab/Documents/result/task_" + name + "" + index + ".txt"))) {

			oWriter.write(message);

		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());

		}
	}
}
