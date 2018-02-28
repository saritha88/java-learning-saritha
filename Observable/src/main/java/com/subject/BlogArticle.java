package com.subject;

import java.util.List;
import com.constants.Content;
import com.observer.BlogSection;

public class BlogArticle extends BlogSection{

	public BlogArticle(String name, String message) {
		super(name, message);
	}

	public BlogArticle(String name, String message, List<Content> content) {
		super(name,message,content);
	}

	
}