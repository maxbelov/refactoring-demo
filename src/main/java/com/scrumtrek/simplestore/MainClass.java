package com.scrumtrek.simplestore;

class MainClass {
	 static void Main(String[] args) {
		// Create movies
		Movie movCinderella = new Movie("Cinderella", PriceCodes.CHILDREN);
		Movie movStarWars = new Movie("Star Wars", PriceCodes.REGULAR);
		Movie movGladiator = new Movie("Gladiator", PriceCodes.NEWRELEASE);

		// Create customers
		Customer custMickeyMouse = new Customer("Mickey Mouse");
		Customer custDonaldDuck = new Customer("Donald Duck");
		Customer custMinnieMouse = new Customer("Minnie Mouse");

		// Create rentals
		Rental rental1 = new Rental(movCinderella, 5);
		Rental rental2 = new Rental(movStarWars, 5);
		Rental rental3 = new Rental(movGladiator, 5);

		// Assign rentals to customers
		custMickeyMouse.addRental(rental1);
		custMickeyMouse.addRental(rental2);
		custMickeyMouse.addRental(rental3);

		// Generate invoice
		String statement = custMickeyMouse.Statement();

		// Print the statement
		System.out.println(statement);		
	}
}

