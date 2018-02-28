package com.runner;

import com.observer.ObserverImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.constants.ContentType;
import com.observer.Observer;
import com.subject.Blog;
import com.subject.BlogArticle;

public class AppRunner {

	public static void main(String[] args) {
		Blog blog = Blog.getInstance();

		Observer obj2 = new ObserverImpl("Obj2");
		Observer obj3 = new ObserverImpl("Obj3");

		Observer obj4 = new ObserverImpl("Obj4");

		blog.register(obj2);

		obj2.setSubject(blog);
		Map<ContentType, String> map = new HashMap<>();
		map.put(ContentType.TEXT, "This is text content");
		map.put(ContentType.VIDEO, "This is video content");
		BlogArticle article = new BlogArticle("Article1", "This article is about java", map);
		BlogArticle topic2 = new BlogArticle("Article2", "This article is about mongodb");
		article.register(obj3);
		obj3.setSubject(article);
		obj4.setSubject(article);
		article.register(obj4, ContentType.TEXT);
		article.addContent(ContentType.TEXT, "text content is updated");

		// article.postMessage(ContentType.TEXT, "Updated content of article in text");

	}

}
