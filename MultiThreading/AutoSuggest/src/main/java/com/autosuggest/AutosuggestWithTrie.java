package com.autosuggest;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutosuggestWithTrie {
	final static Logger logger = Logger.getLogger(AutosuggestWithTrie.class.getName());

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		logger.info("enter text==");
		Scanner sc = new Scanner(System.in);
		String token = sc.nextLine();

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Trie t = null;

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/home/sarithab/Desktop/output/"))) {
			for (Path entry : stream) {
				Future<Trie> future1 = executorService.submit(new TrieWords(entry.toFile()));

				t = future1.get();
			}

		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());

		}
		if (Objects.nonNull(t)) {
			List<String> results = t.autoComplete(token, t);
			for (Iterator<String> iterator = results.iterator(); iterator.hasNext();) {
				String str = iterator.next();
				logger.info(str);
			}
		}
	}

}