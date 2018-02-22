package com.refactoring;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintStatement implements GenerateStatement {

	public static final Logger log = Logger.getLogger(PrintStatement.class.getName());

	@Override
	public void getStatement(Customer customer, int daysRented, int bookId) {

		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentalsItr = null;
		if (!customer.getRentals().isEmpty()) {
			rentalsItr = customer.getRentals().iterator();

			StringBuilder stb;
			String print;

			while (rentalsItr.hasNext()) {
				Rental rental = rentalsItr.next();

				double thisAmount = rental.fetchPrice(daysRented);

				stb = new StringBuilder().append("\t").append(thisAmount);
				print = stb.toString();
				log.log(Level.INFO, print);

				frequentRenterPoints += rental.fetchPrice(daysRented);
				totalAmount += thisAmount;
			}

			stb = new StringBuilder().append("Amount owed is ").append(totalAmount);
			print = stb.toString();
			log.log(Level.INFO, print);
			stb = new StringBuilder().append("You earned ").append(frequentRenterPoints)
					.append(" frequent renter points");
			print = stb.toString();
			log.log(Level.INFO, print);
		}
	}

}
