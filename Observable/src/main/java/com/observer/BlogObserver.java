package com.observer;

import java.util.ArrayList;
import java.util.List;

import com.subject.Subject;

public class BlogObserver implements Observer {

	private String name;
	private Subject topic;
	private List<Object> list;
	
	public BlogObserver(String name) {
		super();
		this.name = name;
		this.list=new ArrayList<>();
	}
	@SuppressWarnings("unchecked")
	@Override
	public void update() {
		Object msg = topic.getUpdate(this);
		
		if(msg == null){
			System.out.println(name+":: No new message");
		}else
		System.out.println(name+":: Consuming message::"+msg);
		System.out.println(list+":: New article is added::");

		
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic=sub;
		
	}

}
