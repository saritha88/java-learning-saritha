package com.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.constants.ContentType;
import com.subject.Blog;
import com.subject.Subject;

public class BlogSection<T> implements Subject {
	public Map<ContentType, List<Observer>> map;
	private String message;
	private boolean changed;
	private String name;
	private Map<ContentType, String> content;

	public BlogSection(String name, String message) {
		this.map = new HashMap<>();
		this.name = name;
		this.message = message;
		postMessage();
	}

	public BlogSection(String name, String message, Map<ContentType, String> content) {
		this.map = new HashMap<>();
		this.name = name;
		this.message = message;
		this.content = content;
		postMessage();
	}

	void postMessage() {
		Blog.getInstance().addBlogSection(this);
	}

	@Override
	public void register(Observer obj) {
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

		// observersLocal = map.get();
		this.changed = false;

		for (Observer obj : observersLocal) {
			obj.update();
		}

	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}

	public void register(Observer obj, ContentType... type) {
		Blog.getInstance().register(obj);
		for (ContentType content : type) {
			List<Observer> observers1 = null;
			if (map.containsKey(content)) {
				observers1 = map.get(content);
				if (obj != null && !observers1.contains(obj)) {

					observers1.add(obj);

				}
			} else {
				observers1 = new ArrayList<>();
				if (obj != null && !observers1.contains(obj)) {

					observers1.add(obj);
				}
				map.put(content, observers1);
			}

		}
	}

	@Override
	public void addContent(ContentType type, String str) {
		System.out.println("Content is addedd:"+str);
		this.changed = true;
		String obj = content.get(type);
		obj.concat(str);
		content.put(type, obj);
		notifyObservers(type);

	}

	private void notifyObservers(ContentType type) {
		List<Observer> observersLocal = null;
		if (!changed)
			return;
		observersLocal = map.get(type);
		this.changed = false;

		for (Observer obj : observersLocal) {
			obj.update();
		}

	}


	@Override
	public void UpdateContent() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RemoveContent() {
		// TODO Auto-generated method stub
		
	}
}
