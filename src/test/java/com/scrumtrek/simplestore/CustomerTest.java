package com.scrumtrek.simplestore; /**
 * Created by askryl on 29.02.16.
 */

import com.scrumtrek.simplestore.Customer;
import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.fest.assertions.Assertions.*;

public class CustomerTest {

    @Test
    public void getReportOnRegularMovieOneDayOneCustomer() {

        Movie testMovie = new Movie("Star Wars", PriceCodes.Regular);


        Customer testCustomer = new Customer("Test Customer");

        // Create rentals
        Rental testRental = new Rental(testMovie, 1);

        // Assign rentals to customers
        testCustomer.addRental(testRental);

        // Generate invoice
        String statement = testCustomer.Statement();

        assertThat(statement).
                contains("Rental record for Test Customer").
                contains("Star Wars\t2.0").
                contains("Amount owed is 2.0").
                contains("You earned 1 frequent renter points");


    }

    @Test
    public void getReportOnRegularMovieThreeDayOneCustomer() {

        Movie testMovie = new Movie("Star Wars", PriceCodes.Regular);


        Customer testCustomer = new Customer("Test Customer");

        // Create rentals
        Rental testRental = new Rental(testMovie, 3);

        // Assign rentals to customers
        testCustomer.addRental(testRental);

        // Generate invoice
        String statement = testCustomer.Statement();

        assertThat(statement).
                contains("Rental record for Test Customer").
                contains("Star Wars\t3.5").
                contains("Amount owed is 3.5").
                contains("You earned 1 frequent renter points");


    }

    @Test
    public void getReportOnNewReleaseMovieTwoDayOneCustomer() {

        Movie testMovie = new Movie("Star Wars", PriceCodes.NewRelease);


        Customer testCustomer = new Customer("Test Customer");

        // Create rentals
        Rental testRental = new Rental(testMovie, 2);

        // Assign rentals to customers
        testCustomer.addRental(testRental);

        // Generate invoice
        String statement = testCustomer.Statement();

        // Print the statement
        assertThat(statement).
                contains("Rental record for Test Customer").
                contains("Star Wars\t6.0").
                contains("Amount owed is 6.0").
                contains("You earned 2 frequent renter points");


    }


    @Test
    public void getReportOnChildrensMovieOneDayOneCustomer() {

        Movie testMovie = new Movie("Star Wars", PriceCodes.Childrens);


        Customer testCustomer = new Customer("Test Customer");

        // Create rentals
        Rental testRental = new Rental(testMovie, 1);

        // Assign rentals to customers
        testCustomer.addRental(testRental);

        // Generate invoice
        String statement = testCustomer.Statement();

        // Print the statement
        assertThat(statement).
                contains("Rental record for Test Customer").
                contains("Star Wars\t1.5").
                contains("Amount owed is 1.5").
                contains("You earned 1 frequent renter points");


    }

    @Ignore
    @Test
    public void getWrongReportOnChildrensMovieFourDayOneCustomer() {

        Movie testMovie = new Movie("Star Wars", PriceCodes.Childrens);


        Customer testCustomer = new Customer("Test Customer");

        // Create rentals
        Rental testRental = new Rental(testMovie, 5);

        // Assign rentals to customers
        testCustomer.addRental(testRental);

        // Generate invoice
        String statement = testCustomer.Statement();



        // Print the statement
        assertThat(statement).
                contains("Rental record for Test Customer").
                contains("Star Wars\t1.5").
                contains("Amount owed is 1.5").
                contains("You earned 1 frequent renter points");


    }
}
