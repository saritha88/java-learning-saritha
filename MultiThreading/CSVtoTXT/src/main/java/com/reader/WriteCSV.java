package com.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("serial")
public class WriteCSV extends RecursiveAction {
	public static final Logger log = Logger.getLogger(WriteCSV.class.getName());

	static int limit = 5000;
	private List<String> lines;
	static AtomicInteger i = new AtomicInteger(0);

	public WriteCSV(List<String> lines) {
		super();
		this.lines = lines;
	}

	@Override
	protected void compute() {
		if (lines.size() > limit) {

			ForkJoinTask.invokeAll(createSubtasks());

		} else {
			writeToFile(lines);

		}

	}

	private List<WriteCSV> createSubtasks() {
		List<WriteCSV> subTasks = new ArrayList<>();
		Stream<String> partOne = lines.stream().limit(limit);
		Stream<String> partTwo = lines.stream().skip(limit);

		subTasks.add(new WriteCSV((List<String>) partOne.collect(Collectors.toList())));
		subTasks.add(new WriteCSV((List<String>) partTwo.collect(Collectors.toList())));

		return subTasks;
	}

	public void writeToFile(List<String> lines) {
		try {
			
			if (Files.isWritable(Paths.get("/home/sarithab/Documents/result"))) {
				Files.write(Paths.get("/home/sarithab/Documents/result/data" + i.incrementAndGet() + ".txt"), lines);
			}
		} catch (IOException e) {
			log.info(e.getMessage());
		}

	}

}
