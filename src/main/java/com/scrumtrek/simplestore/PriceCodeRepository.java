package com.scrumtrek.simplestore;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by askryl on 29.02.16.
 */
public class PriceCodeRepository {


    private Map<String, AbstractPriceCode> pricesCodes = new HashMap<>();

    public void init() {

        pricesCodes.put(
                "REGULAR",
                new AbstractPriceCode() {
                    @Override
                    public double calculateAmount(Integer days) {
                            double amount = 2;
                            if (days > 2)
                            {
                                amount += (days - 2) * 1.5;
                            }
                            return amount;
                    }

                    @Override
                    public double getBonus(Integer days) {
                        return 1;
                    }
                }
        );


        pricesCodes.put(
                "PRON",
                new AbstractPriceCode() {
                    @Override
                    public double calculateAmount(Integer days) {
                        double amount = 2;
                        if (days > 1)
                        {
                            amount += (days - 2) * 1.5;
                        }
                        return amount;
                    }

                    @Override
                    public double getBonus(Integer days) {
                        return 0;
                    }
                }
        );
    }

    double calculate(String description, Integer days) {
        double amount = 0;
        if (pricesCodes.containsKey(description)) {
            amount = pricesCodes.get(description).calculateAmount(days);
        }

        return amount;
    }
}
