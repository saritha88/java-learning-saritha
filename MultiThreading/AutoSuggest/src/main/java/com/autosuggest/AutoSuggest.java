package com.autosuggest;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoSuggest {

	public static final Logger logger = Logger.getLogger(AutoSuggest.class.getName());

	public static void main(String[] args) throws Exception {

		ExecutorService executer = Executors.newCachedThreadPool();

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/home/sarithab/Desktop/output/"))) {
			for (Path entry : stream) {
				Future<List<String>> future = executer
						.submit(new WordLengthCallable(entry.toString()));

				for (String str : future.get()) {

					logger.info(str);

				}

			}

		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());

		}

	}
}
