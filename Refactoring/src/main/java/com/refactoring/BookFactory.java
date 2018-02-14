package com.refactoring;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BookFactory {
private static final Logger logger=Logger.getLogger(BookFactory.class.getName());
	

	public static Book getBookInstance(String title,int category) {
		switch (category) {
		case (Book.FICTION):
			return new Fiction(title);

		case (Book.NON_FICTION):
			return new NonFiction(title);

		case (Book.CHILDRENS):
			return new ChidrenBook(title);
		default:
			logger.log(Level.SEVERE,"Invalid category");
		}
		return null;
	}
	
	private BookFactory() {
		
	}
}