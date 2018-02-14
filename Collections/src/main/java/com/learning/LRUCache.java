package com.learning;

import java.util.HashMap;
import java.util.Stack;

public class LRUCache {
	private HashMap<String, Object> lruMap;
	private Stack<String> stack;
	int capacity;

	public LRUCache(int capacity) {
		super();
		this.capacity = capacity;
		this.lruMap = new HashMap<String, Object>(capacity);
		this.stack = new Stack<String>();
	}

	public void put(String key, Object value) {
		String remove;
		if (lruMap.containsKey(key) || this.capacity < lruMap.size() + 1) {
			if (lruMap.containsKey(key)) {
				remove = key;
			} else {
				remove = this.stack.pop();
			}
			this.stack.removeElement(remove);
			this.lruMap.remove(remove);
		}
		this.lruMap.put(key, value);
		this.stack.add(key);
	}

	public Stack<String> get() {
		return this.stack;
	}

	public Object get(String key) {
		Object value = lruMap.get(key);
		put(key, value);
		return value;
	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(3);
		lru.put("k1", "v1");
		lru.put("k2", "v2");
		lru.put("k3", "v3");
		System.out.println(lru.get());
		lru.get("k1");
		System.out.println(lru.get());
		lru.put("k4", "v4");
		System.out.println(lru.get());
	}

}
