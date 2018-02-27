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

		Observer obj4 = new ObserverImpl("Obj4");

		blog.register(obj2);

		obj2.setSubject(blog);

		BlogArticle article = new BlogArticle("Article1", "This article is about java");
		BlogArticle topic2 = new BlogArticle("Article2", "This article is about java");
		 article.register(obj3);
         obj3.setSubject(article);
         obj4.setSubject(article);
         article.register(obj4,ContentType.TEXT);
         System.out.println(article.map.get(ContentType.TEXT).size());
		
	}

}
