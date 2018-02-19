package com.wordcount;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Searcher {

	static Path path = Paths.get("/home/sarithab/Desktop/result/result.txt");

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {

		final List<Path> files = new ArrayList<>();

		ExecutorService executorService = Executors.newFixedThreadPool(files.size());
		Map<String, Integer> map = new HashMap<>();

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/home/sarithab/Desktop/output/"))) {
			for (Path entry : stream) {
				files.add(entry);
				Future<?> future = executorService.submit(new WordSearch(entry.toFile()));
				map = (Map<String, Integer>) future.get();
			}

		}

		List<String> mLines = new ArrayList<>();
		map.forEach((key, value) -> mLines.add(key + "value=" + value));
		Files.write(path, mLines, StandardCharsets.UTF_8);

	}

}