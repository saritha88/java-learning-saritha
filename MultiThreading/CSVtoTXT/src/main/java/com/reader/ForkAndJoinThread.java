package com.reader;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForkAndJoinThread {

	public static void main(String[] args) throws IOException {

		List<String> lines = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get("/home/sarithab/Documents/Multithreading_Task1_Books.csv"))) {
			lines=stream.collect(Collectors.toList());
			
		}
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		WriteCSV writeCSV = new WriteCSV(lines);
		forkJoinPool.invoke(writeCSV);
	}
}

