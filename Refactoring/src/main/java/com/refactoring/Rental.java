/**
 * 
 */
package com.refactoring;

import java.io.Serializable;

/**
 * Represent a customer renting a book.
 * 
 * @author Saritha
 *
 */
public class Rental implements Serializable {

	private static final long serialVersionUID = 1256869448913370768L;

	 private transient Book book;

	private int daysRented;
	int frequentRenterPoints = 0;
	public Rental(Book book, int daysRented) {
		
		super();
		this.book = book;
		this.daysRented = daysRented;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}

	public double getRental() {
		return fetchPrice(this.daysRented);
	}

	public double fetchPrice(int daysRented) {
		double thisAmount = 0;
		thisAmount += getBook().getMinAmount();
		if (daysRented > 2)
			thisAmount += (daysRented - 2) * 2;
		return thisAmount;
	}

	public double getPoints() {
		return getBook().getPoints(getDaysRented());
	}

}
