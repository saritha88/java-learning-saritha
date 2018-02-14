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

public class WriteCSV extends RecursiveAction {
	public static final Logger log=Logger.getLogger(WriteCSV.class.getName());
	
	static  int limit = 50000;
	private List<String> lines = new ArrayList();	
	static AtomicInteger i=new AtomicInteger(0);
	
	public WriteCSV(List<String> lines) {
		super();
		this.lines = lines;
	}

		@Override
	protected void compute() {
		if (lines.size() > limit) {
			List<WriteCSV> subtasks =new ArrayList();

	            subtasks.addAll(createSubtasks());

	            for(RecursiveAction subtask : subtasks){
	                subtask.fork();
	                subtask.join();
	            }
			ForkJoinTask.invokeAll(createSubtasks());

		} else {
			writeToFile(lines);

		}

	}

	@SuppressWarnings("unchecked")
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
			
			Files.write(Paths.get("/home/sarithab/Documents/result/data" + i.incrementAndGet() + ".txt"), lines);
			

		} catch (IOException e) {
			log.info(e.getMessage());
		}

	}

}
