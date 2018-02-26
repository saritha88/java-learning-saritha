package com.subject;

import java.util.ArrayList;
import java.util.List;

import com.constants.ContentType;
import com.observer.Observer;

public class Blog<T> implements Subject {
	private List<Observer> observers;
	private List<Object> list;
	private String message;
	private boolean changed;
	private final Object MUTEX = new Object();

	public Blog() {
		this.list=new ArrayList<>();
		this.observers = new ArrayList<>();
	}
	

	@Override
	public void register(Observer obj) {
		if (obj == null)
			throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
			if (!observers.contains(obj))
				observers.add(obj);
		}
	}

	@Override
	public void unregister(Observer obj) {
		synchronized (MUTEX) {
			observers.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> observersLocal = null;

		synchronized (MUTEX) {
			if (!changed)
				return;
			observersLocal = new ArrayList<>(this.observers);
			this.changed = false;
		}
		for (Observer obj : observersLocal) {
			obj.update();
		}
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this;
	}

	public void postMessage(String msg,BlogArticle blog) {
		System.out.println("Posted some mesage in BlogArticle subject  message is" + msg);
		this.message = msg;
		this.changed = true;
		list.add(blog);
		System.out.println("list size=="+list.size());
		
		notifyObservers();

	}
}
