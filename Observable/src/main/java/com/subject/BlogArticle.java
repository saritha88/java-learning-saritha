package com.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.constants.ContentType;
import com.observer.BlogSection;
import com.observer.Observer;

public class BlogArticle extends BlogSection implements Subject {
	private List<Observer> observers;
	private List<Observer> textobservers;
	private List<Observer> Videoobservers;
	private Map<ContentType, List<Observer>> map;

	private String message;
	private boolean changed;
	private String name;
	private ContentType type;

	void postMessage() {
		Blog.getInstance().addBlogSection(this);
	}

	public BlogArticle(String name, String message) {
		this.observers = new ArrayList<>();
		this.textobservers = new ArrayList<>();
		this.Videoobservers = new ArrayList<>();
		this.map = new HashMap<>();
		this.name = name;
		this.message = message;
		postMessage();

	}

	@Override
	public void register(Observer obj) {
		if (obj != null) {
			if (!observers.contains(obj)) {
				observers.add(obj);
			}
		}
	}

	@Override
	public void unregister(Observer obj) {

		observers.remove(obj);

	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;
		if (!changed)

			return;
		observersLocal = new ArrayList<>(this.observers);
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

	public void register(Observer obj, ContentType type ) {
		Blog.getInstance().register(obj);
		List<Observer> list = map.get(type);
		if (obj != null) {
			if (!list.contains(obj)) {
				list.add(obj);
			}
		}
	}

}
