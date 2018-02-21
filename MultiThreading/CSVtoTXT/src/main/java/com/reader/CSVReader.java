package com.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

class Reader implements Runnable {

	public static final Logger logger = Logger.getLogger(Reader.class.getName());
	static int lineCount = 1;
	static int limit = 100;
	BufferedReader csvReader;

	public Reader() {
	}

	public Reader(BufferedReader br) {
		this.csvReader = br;
	}

	private synchronized void readCSV() {
		String line;
		int i = 0;
		StringBuilder sb = new StringBuilder("");
		try {
			while ((line = csvReader.readLine()) != null) {
				if (sb.length() == 0)
					sb.append(line);
				else
					sb.append("\n").append(line);
				lineCount++;

				if (lineCount >= limit) {

					new Thread(new CSVWriter(sb.toString(), ++i)).start();
					lineCount = 1;
					sb.setLength(0);
				}

			}
		} catch (IOException e) {
			logger.info(e.getMessage());

		}

	}

	public void run() {
		readCSV();
	}
}

public class CSVReader {
	public static final Logger logger = Logger.getLogger(CSVReader.class.getName());

	public static void main(String[] args) throws FileNotFoundException {

		try (BufferedReader br = new BufferedReader(
				new FileReader("/home/sarithab/Documents/Multithreading_Task1_Books.csv"))) {

			Reader ops = new Reader(br);
			Thread t1 = new Thread(ops);
			t1.setName("T1");
			t1.start();
		} catch (IOException e) {
			logger.info(e.getMessage());
		}

	}

}