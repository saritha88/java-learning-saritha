package com.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.constants.Content;
import com.constants.ContentType;
import com.subject.Blog;
import com.subject.Subject;

public class BlogSection implements Subject {
	public Map<ContentType, List<Observer>> map;
	private String message;
	private boolean changed;
	private String name;
	private List<Content> content;

	public BlogSection(String name, String message) {
		this.map = new HashMap<>();
		this.name = name;
		this.message = message;
		postMessage();
	}

	public BlogSection(String name, String message, List<Content> content) {
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
		unregister(obj, ContentType.values());

	}

	private void unregister(Observer obj, ContentType...values) {
		for (ContentType content : values) {
			List<Observer> observers1 = null;

			observers1 = map.get(content);
			if (obj != null && !observers1.contains(obj)) {

				observers1.remove(obj);

			}

		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		if (!changed)

			return;
	    //observersLocal = map.get();
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
	public void addContent(Content cont) {
		System.out.println("Content is addedd:" + cont.toString());
		this.changed = true;
		
		for (int i = 0; i < content.size(); i++) {
			
			Content con = content.get(i);
			if (con.getType().equals(cont.getType())) {
				con.getValue().toString().concat(cont.getValue().toString());
			}
		}
		notifyObservers((ContentType) cont.getType());

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
	public void RemoveContent(Content cont) {
		System.out.println("Content is deleted:" + cont.toString());
		this.changed = true;
		for (int i = 0; i < content.size(); i++) {
			Content con = content.get(i);
			if (con.getType().equals(cont.getType())) {
				content.remove(i);
			}
		}
		notifyObservers((ContentType) cont.getType());
	}

	@Override
	public void UpdateContent(Content cont) {
		System.out.println("Content is Updated:" + cont.toString());
		this.changed = true;
		
		for (int i = 0; i < content.size(); i++) {
			Content con = content.get(i);
			
			if (con.getType().equals(cont.getType())) {
				
				con.setValue(cont);
			}
		}
		notifyObservers((ContentType) cont.getType());

	}
		
	}
