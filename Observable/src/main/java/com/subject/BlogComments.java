package com.subject;

import java.util.List;
import java.util.Map;
import com.constants.Content;
import com.constants.ContentType;
import com.observer.BlogSection;

public class BlogComments extends BlogSection{

	public  BlogComments(String name, String message, List<Content> content) {
		super(name, message, content);
	}

	public BlogComments(String name, String message) {
		super(name, message);
	}

	
}
