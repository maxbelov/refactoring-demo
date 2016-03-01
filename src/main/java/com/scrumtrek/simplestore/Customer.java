package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String m_Name;
	private List<CompositeRental> rentals = new ArrayList<CompositeRental>();

	public Customer(String name) {
		m_Name = name;
	}

	public String getName() {
		return m_Name;
	}


	public void addCompositeRental(CompositeRental arg){
		rentals.add(arg);
	}

	public double totalAmount() {
		double totalAmount = 0;

		for(CompositeRental each: rentals) {
			totalAmount += each.totalAmount();
		}

		return totalAmount;
	}

	public List<CompositeRental> getRentals() {
		return rentals;
	}
}

