package com.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.constants.Listner;
import com.observer.BlogSection;
import com.observer.Observer;

public class Blog implements Subject {
	private List<Observer> observers;
	private Map<String, List<BlogSection>> map;
	private String message;
	private boolean changed;
	private Listner lisner;
	private static Blog blog;

	private Blog() {
		this.map = new HashMap<>();
		this.observers = new ArrayList<>();
		lisner = new Listner();
		postConstruct();
	}

	public static Blog getInstance() {
		if (blog == null) {
			blog = new Blog();
		}
		return blog;
	}

	private void postConstruct() {
		lisner.setInstanceBlog(this);
	}

	@Override
	public void register(Observer obj) {

		if (!observers.contains(obj))
			observers.add(obj);
	}

	@Override
	public void unregister(Observer obj) {
		observers.remove(obj);
	}

	@Override
	public void notifyObservers() {
		for (Observer obj : observers) {
			obj.update();
		}
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}

	public <T> void addBlogSection(T t) {

		this.message = "New post is added in blog";
		this.changed = true;
		if (t instanceof BlogArticle) {
			List<BlogSection> list = new ArrayList<>();
			list.add((BlogSection) t);
			map.put(t.getClass().getSimpleName(), list);

		}
		notifyObservers();

	}

	public void postMessage(String msg) {

		this.message = msg;
		this.changed = true;

		notifyObservers();

	}
}
