package com.runner;

import com.observer.ObserverImpl;
import com.constants.ContentType;
import com.observer.Observer;
import com.subject.Blog;
import com.subject.BlogArticle;

public class AppRunner {

	public static void main(String[] args) {
		Blog blog = Blog.getInstance();
		
		Observer obj2 = new ObserverImpl("Obj2");
		Observer obj3 = new ObserverImpl("Obj2");


		blog.register(obj2);

		obj2.setSubject(blog);

		BlogArticle topic = new BlogArticle("Article1", "This article is about java");
		BlogArticle topic2 = new BlogArticle("Article2", "This article is about java");
         topic.register(obj3);
		// obj2.update();

		// topic.postMessage(ContentType.TEXT,"New Text Message");
		// blog.postMessage("blog article");
		// blog.postNewArticle(topic);
	}

}
