package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by askryl on 01.03.16.
 */
public class CompositeRental {
    private List<Rental> m_Rentals = new ArrayList<Rental>();

    public double totalAmount() {
        double totalAmount = 0;

        for(Rental each: m_Rentals) {
            totalAmount += PriceCodeRepository.calculate(each);
        }

        return totalAmount;
    }

}
