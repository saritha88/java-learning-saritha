package com.autosuggest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordLengthCallable implements Callable<List<String>> {
	public static final Logger logger = Logger.getLogger(WordLengthCallable.class.getName());


		private  String path;

		public WordLengthCallable(String path) {

			this.path = path;
		}

		public List<String> call() throws IOException {
			List<String> list = new ArrayList<>();
			try (Stream<String> stream = Files.lines(Paths.get(path))) {
				list = stream.collect(Collectors.toList());
			}

			List<String> result = new ArrayList<>();
			logger.info("enter text==");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			String token = input;

			for (String text : list) {
				String[] strings = text.split("==");
				for (String str : strings) {
					if (str.contains(token)) {
						result.add(str);
					}
				}
			}
			return result;
		}

}
