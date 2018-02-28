package com.subject;

import java.util.Map;
import com.constants.ContentType;
import com.observer.BlogSection;

public class BlogComments extends BlogSection<BlogComments>{

	public BlogComments(String name, String message, Map<ContentType, String> content) {
		super(name, message, content);
	}

	public BlogComments(String name, String message) {
		super(name, message);
	}

	
}
