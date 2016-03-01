package com.scrumtrek.simplestore;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
/**
 * Created by askryl on 29.02.16.
 */
public class PriceCodeTest {

    private PriceCodeRepository priceCodeRepository;

    @Test
    public void getAmountRegularPriceCodeOneDay() {
        double value = PriceCodeRepository.calculate(PriceCodes.Regular, 1);
        assertTrue(value == 2.0);
    }


    @Test
    public void getAmountPronRegularPriceCodeOneDay() {
        double value = PriceCodeRepository.calculate(PriceCodes.Pron, 1);
        assertTrue(value == 2.0);
    }

    @Test
    public void getAmountPronRegularPriceCodeFourDay() {
        double value = PriceCodeRepository.calculate(PriceCodes.Pron, 4);
        assertTrue(value == 5.0);
    }
}
