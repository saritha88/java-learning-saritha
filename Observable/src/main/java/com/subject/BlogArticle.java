package com.subject;

import java.util.Map;

import com.constants.ContentType;
import com.observer.BlogSection;

public class BlogArticle extends BlogSection<BlogArticle>{

	public BlogArticle(String name, String message) {
		super(name, message);
	}

	public BlogArticle(String name, String message,Map<ContentType, String> content) {
		super(name,message,content);
	}

	
}