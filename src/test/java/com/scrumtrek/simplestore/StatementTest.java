package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by raz0r on 29.02.2016.
 */
public class StatementTest {
    @Test
    public void childrenMovieRentalNoOverprice() {
        //region Given
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Rental rental1 = new Rental(movCinderella, 1);
        custMickeyMouse.addRental(rental1);
        //endregion

        //region When
        String invoice = custMickeyMouse.Statement();
        //endregion

        //region Then
        assertThat(invoice).contains("Amount owed is " + 1.5);
        //endregion
    }


    @Test
    public void childrenMovieRentalOverprice() {
        //region Given
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Rental rental1 = new Rental(movCinderella, 5);
        custMickeyMouse.addRental(rental1);
        //endregion

        //region When
        String invoice = custMickeyMouse.Statement();
        //endregion

        //region Then
        assertThat(invoice).contains("Amount owed is " + ((5-3)*1.5));
        //endregion
    }


    @Test
    public void regularMovieOverprice() {
        //region Given
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Regular);
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Rental rental1 = new Rental(movCinderella, 5);
        custMickeyMouse.addRental(rental1);
        //endregion

        //region When
        String invoice = custMickeyMouse.Statement();
        //endregion

        //region Then
        assertThat(invoice).contains("Amount owed is " + (2 + (5-2)*1.5));
        //endregion
    }

    @Test
    public void regularMovieNoOverprice() {
        //region Given
        Movie movCinderella = new Movie("Cinderella", PriceCodes.Regular);
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Rental rental1 = new Rental(movCinderella, 1);
        custMickeyMouse.addRental(rental1);
        //endregion

        //region When
        String invoice = custMickeyMouse.Statement();
        //endregion

        //region Then
        assertThat(invoice).contains("Amount owed is " + 2);
        //endregion
    }

    @Test
    public void newReleaaseMoviePrice() {
        //region Given
        Movie movCinderella = new Movie("Cinderella", PriceCodes.NewRelease);
        Customer custMickeyMouse = new Customer("Mickey Mouse");
        Rental rental1 = new Rental(movCinderella, 5);
        custMickeyMouse.addRental(rental1);
        //endregion

        //region When
        String invoice = custMickeyMouse.Statement();
        //endregion

        //region Then
        assertThat(invoice).contains("Amount owed is " + 5 * 3);
    }
}
