package com.subject;

import java.util.ArrayList;
import java.util.List;

import com.observer.Observer;

public class BlogComments implements Subject {

	private List<Observer> observers;
	private String message;
	private boolean changed;
	
	public BlogComments(){
		this.observers=new ArrayList<>();
	}
	@Override
	public void register(Observer obj) {
		if(!observers.contains(obj)) observers.add(obj);
		
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
			this.changed=false;
		
		for (Observer obj : observersLocal) {
			obj.update();
		}

	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	//method to post message to the topic
	public void postMessage(String msg){
		System.out.println("Message Posted to Topic:"+msg);
		this.message=msg;
		this.changed=true;
		notifyObservers();
	}

}
