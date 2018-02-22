package com.refactoring;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookFactory {
private static final Logger logger=Logger.getLogger(BookFactory.class.getName());
	

	public static Optional<Book> getBookInstance(String title,int category) {
		if(category!=-1)
		switch (category) {
		case (Book.FICTION):
			return Optional.of(new Fiction(title));

		case (Book.NON_FICTION):
			return Optional.of(new NonFiction(title));

		case (Book.CHILDRENS):
			return Optional.of(new ChidrenBook(title));
		default:
			logger.log(Level.SEVERE,"Invalid category");
		
	}
		return Optional.empty();
	}
	
	private BookFactory() {
		
	}
}