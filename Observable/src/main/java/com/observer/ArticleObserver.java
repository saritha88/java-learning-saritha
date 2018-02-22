package com.observer;

import com.constants.ContentType;
import com.subject.Subject;

public class ArticleObserver implements Observer {

	private String name;
	private ContentType type;
	private Subject topic;
	
	public ArticleObserver(String name){
		this.name=name;
	}
	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if(msg == null){
			System.out.println(name+":: No new message");
		}else
		System.out.println(name+":: Consuming message::"+msg);
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic=sub;
	}


}
