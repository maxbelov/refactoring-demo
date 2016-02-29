package com.scrumtrek.simplestore;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by raz0r on 29.02.2016.
 */
public class StatementTest {
    @Test
    public void childrenMovieRental() {
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
}
