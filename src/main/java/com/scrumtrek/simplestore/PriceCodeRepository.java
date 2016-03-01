package com.scrumtrek.simplestore;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by askryl on 29.02.16.
 */
public class PriceCodeRepository {


    private static Map<PriceCodes, AbstractPriceCode> pricesCodes = new HashMap<>();
    static {

        pricesCodes.put(
                PriceCodes.Regular,
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

                }
        );


        pricesCodes.put(
                PriceCodes.Pron,
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

                }
        );


        pricesCodes.put(
                PriceCodes.NewRelease,
                new AbstractPriceCode() {
                    @Override
                    public double calculateAmount(Integer days) {
                        return days * 3;
                    }

                }
        );

        pricesCodes.put(
                PriceCodes.Childrens,
                new AbstractPriceCode() {
                    @Override
                    public double calculateAmount(Integer days) {
                        double amount = 1.5;
                        if (days > 3)
                        {
                            amount += (days - 3) * 1.5;
                        }
                        return amount;
                    }

                }
        );
    }

    static double calculate(PriceCodes code, Integer days) {
        double amount = 0;
        if (pricesCodes.containsKey(code)) {
            amount = pricesCodes.get(code).calculateAmount(days);
        }

        return amount;
    }

    static double calculate(final Rental rental) {
        double amount = 0;

        if (pricesCodes.containsKey(rental.getMovie().getPriceCode())) {
            amount = pricesCodes.get(rental.getMovie().getPriceCode()).calculateAmount(rental.getDaysRented());
        }

        return amount;
    }
}
