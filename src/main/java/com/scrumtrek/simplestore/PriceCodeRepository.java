package com.scrumtrek.simplestore;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by askryl on 29.02.16.
 */
public class PriceCodeRepository {


    private Map<PriceCodes, AbstractPriceCode> pricesCodes = new HashMap<>();

    public void init() {

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

                    @Override
                    public double getBonus(Integer days) {
                        return 1;
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

                    @Override
                    public double getBonus(Integer days) {
                        return 1;
                    }
                }
        );
    }

    double calculate(PriceCodes code, Integer days) {
        double amount = 0;
        if (pricesCodes.containsKey(code)) {
            amount = pricesCodes.get(code).calculateAmount(days);
        }

        return amount;
    }
}
