package com.refactoring;

public class ChidrenBook extends Book {

	public ChidrenBook(String title) {
		super(title);
	}

	@Override
	public double getMinAmount() {
		return 1.5;
	}

	@Override
	public double getPoints(int daysRented) {
		double frequentRenterPoints = 0;

		if (daysRented > 1)
			frequentRenterPoints++;

		return frequentRenterPoints;
	}

}
