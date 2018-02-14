package com.refactoring;

public class NonFiction extends Book {

	public NonFiction(String title) {
		super(title);
	}

	@Override
	public double getMinAmount() {
		return 2;
	}

	@Override
	public double getPoints(int daysRented) {
		double frequentRenterPoints = 0;

		if (daysRented > 1)
			frequentRenterPoints++;

		return frequentRenterPoints;
	}

}
