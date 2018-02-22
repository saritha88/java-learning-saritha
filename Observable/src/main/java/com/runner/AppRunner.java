package com.runner;

import com.constants.ContentType;
import com.observer.ArticleObserver;
import com.observer.Observer;
import com.subject.Blog;
import com.subject.BlogArticle;

public class AppRunner {

	public static void main(String[] args) {
		//create a instance of subject
		BlogArticle topic = new BlogArticle();
		
		//create observers
		Observer obj1 = new ArticleObserver("Obj1");
		Observer obj2 = new ArticleObserver("Obj2");
		
		
		//register observers to the subject
		topic.register(obj1);
		topic.register(obj2);
		
		
		//attach observer to subject
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		
		//check if any update is available
		obj1.update();
		
		//now send message to subject
		topic.postMessage(ContentType.TEXT,"New Text Message");
	}
}
