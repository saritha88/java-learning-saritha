package com.autosuggest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class TrieWords implements Callable<Trie> {

	static volatile Trie t = new Trie();
	private File file;

	public TrieWords(File file2) {
		this.file = file2;
	}

	private Trie searchString() throws IOException {
		try (BufferedReader in = new BufferedReader(new FileReader(file))) {
			String readLine = "";
			while ((readLine = in.readLine()) != null) {
				String[] words = readLine.split("\\W");
				for (String text : words) {

					t.insert(text);

				}

			}
		}
		return t;
	}

	@Override
	public Trie call() throws Exception {
		return searchString();
	}

}
