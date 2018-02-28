package com.observer;

import com.subject.Subject;

public class ObserverImpl implements Observer {

	private String name;
	private Subject topic;

	public ObserverImpl(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if (msg == null) {
			System.out.println(name + ":: No new message");
		} else
			System.out.println(name + ":: Consuming message::");
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic = sub;
	}

	@Override
	public String toString() {
		return "ObserverImpl [name=" + name + ", topic=" + topic + "]";
	}

}
