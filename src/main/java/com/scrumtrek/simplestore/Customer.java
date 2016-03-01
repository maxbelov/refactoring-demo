package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String m_Name;
	private List<CompositeRental> m_Rentals = new ArrayList<CompositeRental>();

	public Customer(String name) {
		m_Name = name;
	}

	public String getName() {
		return m_Name;
	}


	public void addCompositeRental(CompositeRental arg){
		m_Rentals.add(arg);
	}

	public double totalAmount() {
		double totalAmount = 0;

		for(CompositeRental each: m_Rentals) {
			totalAmount += each.totalAmount();
		}

		return totalAmount;
	}

	public String report()
	{
		return "";
	}
}

