package com.runner;

import com.observer.ObserverImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.constants.Content;
import com.constants.ContentType;
import com.observer.Observer;
import com.subject.Blog;
import com.subject.BlogArticle;

public class AppRunner {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Blog blog = Blog.getInstance();

		Observer obj2 = new ObserverImpl("Obj2");
		Observer obj3 = new ObserverImpl("Obj3");

		Observer obj4 = new ObserverImpl("Obj4");

		blog.register(obj2);

		obj2.setSubject(blog);
		List<Content> content = new ArrayList<>();
		content.add(new Content(ContentType.VIDEO, "this is text"));
		BlogArticle article = new BlogArticle("Article1", "This article is about java", content);
		article.register(obj3, ContentType.VIDEO);
		obj3.setSubject(article);
		obj4.setSubject(article);
		article.register(obj4, ContentType.TEXT);
		article.addContent(new Content(ContentType.VIDEO, "new content is added of type video"));
		article.UpdateContent(new Content(ContentType.VIDEO, "new content is updated of type Video"));
		article.RemoveContent(new Content(ContentType.VIDEO, "new content is updated of type Video"));
	}

}
