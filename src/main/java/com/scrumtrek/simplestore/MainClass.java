package com.scrumtrek.simplestore;

class MainClass {
	 public static void main(String[] args) {
		// Create movies
		Movie movCinderella = new Movie("Cinderella", PriceCodes.CHILDREN);
		Movie movStarWars = new Movie("Star Wars", PriceCodes.REGULAR);
		Movie movGladiator = new Movie("Gladiator", PriceCodes.NEWRELEASE);

		// Create customers
		Customer custMickeyMouse = new Customer("Mickey Mouse");
		Customer custDonaldDuck = new Customer("Donald Duck");
		Customer custMinnieMouse = new Customer("Minnie Mouse");

		// Create rentals
		Rental rental1 = new Rental(5);
         rental1.addMovie(movCinderella);
		Rental rental2 = new Rental(5);
         rental2.addMovie(movStarWars);
		Rental rental3 = new Rental(5);
         rental3.addMovie(movGladiator);

		// Assign rentals to customers
		custMickeyMouse.addRental(rental1);
		custMickeyMouse.addRental(rental2);
		custMickeyMouse.addRental(rental3);




		// Generate invoice
		ReportFormat format = new TextReport();

		// Print the statement
		InvoicePrinter printer = new InvoicePrinter();
		 printer.print(format.format(Report.getReport(custMickeyMouse)));
	}
}

