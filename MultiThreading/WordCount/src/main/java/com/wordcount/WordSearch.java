package com.wordcount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;


public class WordSearch implements Callable<Map<String, Integer>> {
	static volatile  Map<String, Integer> countByWords = new HashMap<>();

	private File file;

	public WordSearch(File file2) {
		this.file = file2;
	}

	private Map<String, Integer> searchString() throws IOException {
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				String[] words = readLine.split("\\W");
				for (String text : words) {

					Integer count = countByWords.get(text);
					if (countByWords.containsKey(text)) {
						countByWords.put(text, count + 1);
					} else {
						countByWords.put(text, 1);
					}

				}

			}
		}
		return countByWords;
	}

	@Override
	public Map<String, Integer> call() throws Exception {
		return searchString();
	}
}
