
package com.refactoring;

public abstract class Book {

	private static final long serialVersionUID = -7348792584072115788L;

	public static final int FICTION = 1;
	public static final int NON_FICTION = 2;
	public static final int CHILDRENS = 3;

	private long id;
	private String title;

	public Book(final String title) {
		super();
		this.title = title;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public abstract double getMinAmount();

	public abstract double getPoints(int daysRented);

}
