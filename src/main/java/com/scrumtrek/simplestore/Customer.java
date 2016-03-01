package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addRental(Rental arg){
		rentals.add(arg);
	}

    public List<Rental> getRentals() {
        return rentals;
    }

    public double getTotal()
	{
		double totalAmount = 0;
		for(Rental rental: rentals) {
			totalAmount += rental.getTotal();
		}
		return totalAmount;
	}
}

