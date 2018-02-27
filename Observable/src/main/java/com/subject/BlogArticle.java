package com.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.constants.ContentType;
import com.observer.BlogSection;
import com.observer.Observer;

public class BlogArticle extends BlogSection implements Subject {

	public Map<ContentType, List<Observer>> map;
	private List<Observer> observers;
	private String message;
	private boolean changed;
	private String name;
	private ContentType type;

	public BlogArticle(String name, String message) {
		this.observers = new ArrayList<>();
		this.map = new HashMap<>();
		this.name = name;
		this.message = message;
		postMessage();

	}

	void postMessage() {
		Blog.getInstance().addBlogSection(this);
	}

	@Override
	public void register(Observer obj) {

		/*
		 * if (obj != null) { System.out.println("in for loop"+map.size());
		 * for(Map.Entry<String, List<Observer>> entry:map.entrySet()) {
		 * 
		 * String key=entry.getKey(); System.out.println(key); List<Observer>
		 * observers=entry.getValue(); if (!observers.contains(obj)) {
		 * observers.add(obj); } System.out.println(observers.size());
		 * 
		 * }
		 * 
		 * }
		 */

		register(obj, ContentType.values());
	}

	@Override
	public void unregister(Observer obj) {

		// observers.remove(obj);

	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		if (!changed)

			return;
		// observersLocal = new ArrayList<>(this.observers);
		this.changed = false;

		for (Observer obj : observersLocal) {
			obj.update();
		}

	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}

	public void postMessage(ContentType type, String msg) {
		System.out.println("Posted some mesage in BlogArticle subject " + type + " message is" + msg);
		if (type.equals(ContentType.TEXT)) {
			this.message = msg;
			this.changed = true;

			notifyObservers();
		} else if (type.equals(ContentType.VIDEO)) {
			this.message = msg;
			this.changed = true;
			notifyObservers();
		} else {
			this.message = msg;
			this.changed = true;
			notifyObservers();
		}
	}

	public void register(Observer obj, ContentType... type) {
		Blog.getInstance().register(obj);

		for (ContentType content : type) {
			if (type == null) {
				if (map.containsKey(content)) {
					observers = map.get(content);
					if (obj != null) {
						observers.add(obj);
					}
				} else {
					if (obj != null) {
						observers.add(obj);
					}
					map.put(content, observers);
				}
			} else {
				if (map.containsKey(content)) {
					observers = map.get(content);
					if (obj != null) {
						observers.add(obj);
					}
				} else {
					if (obj != null) {
						observers.add(obj);
					}
					map.put(content, observers);
				}
				/*
				 * observers = map.get(type); if (obj != null) { observers.add(obj); }
				 */
			}
		}

	}
}