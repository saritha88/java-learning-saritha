/**
 * 
 */
package com.refactoring;

import java.io.Serializable;
import java.util.List;

/**
 * Customer class that denotes customer details as well as customer related
 * operations.
 * 
 * @author saritha
 *
 */
public class Customer implements Serializable {

	private static final long serialVersionUID = 851426779607326255L;

	public Customer() {
		super();
	}

	private long id;
	private String name;

	private List<Rental> rentals;

	public Customer(String name,List<Rental> rentals) {
		super();
		this.name = name;
		this.rentals=rentals;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		public List<Rental> getRentals() {
		return rentals;
	}

	public void addRental(final Rental rental) {
		getRentals().add(rental);
	}


}
