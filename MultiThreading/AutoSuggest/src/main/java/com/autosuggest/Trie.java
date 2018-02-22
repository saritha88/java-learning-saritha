package com.autosuggest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Trie {
	protected final Map<Character, Trie> children;
	protected String content;
	protected boolean endOfWord = false;

	public Trie() {
		this(null);

	}

	private Trie(String content) {
		this.content = content;
		children = new HashMap<>();
	}

	protected void add(char character) {
		String s;
		if (this.content == null) {
			s = Character.toString(character);
		} else {
			s = this.content + character;
		}
		children.put(character, new Trie(s));
	}

	public void insert(String word) {
	
		Trie node = this;
		for (char c : word.toCharArray()) {
			if (!node.children.containsKey(c)) {
				node.add(c);
			}
			node = node.children.get(c);
		}
		node.endOfWord = true;

	}

	public List<String> autoComplete(String prefix,Trie t) {
		
		for (char c : prefix.toCharArray()) {
			if (!t.children.containsKey(c)) {
				return Collections.emptyList();
			}
			t = t.children.get(c);
		}
		return t.allPrefixes();
	}

	protected List<String> allPrefixes() {
		List<String> results = new ArrayList<>();
		if (this.endOfWord) {
			results.add(this.content);
		}
		
		for (Map.Entry<Character, Trie> entry : children.entrySet()) {
			Trie child = entry.getValue();
			results.addAll(child.allPrefixes());
		}
		return results;
	}

	}
