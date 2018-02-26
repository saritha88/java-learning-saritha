package com.subject;

import java.util.ArrayList;
import java.util.List;
import com.constants.ContentType;
import com.observer.Observer;

public class BlogArticle  extends Blog implements Subject  {
	private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX = new Object();

	public BlogArticle() {
		
		this.observers = new ArrayList<>();
		
	}

	private static BlogArticle notifyBlog() {
		System.out.println("iam in notify blog");
		return new BlogArticle();
	
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
		return this.message;
	}

	// method to post message to the articel
	public void postMessage(ContentType type,String msg) {
		System.out.println("Posted some mesage in BlogArticle subject "+type+" message is"+msg);
		if(type.equals(ContentType.TEXT)) {
		this.message = msg;
		this.changed = true;
	
		notifyObservers();
	}else if(type.equals(ContentType.VIDEO)) {
		this.message = msg;
		this.changed = true;
		notifyObservers();
	}else {
		this.message = msg;
		this.changed = true;
		notifyObservers();
	}
	}

}
