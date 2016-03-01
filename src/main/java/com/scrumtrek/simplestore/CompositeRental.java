package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by askryl on 01.03.16.
 */
public class CompositeRental {
    private List<Rental> rentals = new ArrayList<Rental>();

    public List<Rental> getRentals() {
        return rentals;
    }

    public double totalAmount() {
        double totalAmount = 0;

        for(Rental each: rentals) {
            totalAmount += PriceCodeRepository.calculate(each);
        }

        return totalAmount;
    }

}
