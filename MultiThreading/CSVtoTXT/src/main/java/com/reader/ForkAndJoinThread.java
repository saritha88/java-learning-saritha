package com.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForkAndJoinThread {
	public static final Logger log = Logger.getLogger(ForkAndJoinThread.class.getName());

	public static void main(String[] args) {

		try (Stream<String> stream = Files
				.lines(Paths.get("/home/sarithab/Documents/Multithreading_Task1_Books.csv"))) {
			List<String> lines = stream.collect(Collectors.toList());
			ForkJoinPool forkJoinPool = new ForkJoinPool();
			WriteCSV writeCSV = new WriteCSV(lines);
			forkJoinPool.invoke(writeCSV);
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}

	}
}
