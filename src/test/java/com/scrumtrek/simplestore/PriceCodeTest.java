package com.scrumtrek.simplestore;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
/**
 * Created by askryl on 29.02.16.
 */
public class PriceCodeTest {

    private PriceCodeRepository priceCodeRepository;

    @Before
    public void before() {
        priceCodeRepository = new PriceCodeRepository();
        priceCodeRepository.init();
    }

    @Test
    public void getAmountRegularPriceCodeOneDay() {
        double value = priceCodeRepository.calculate("REGULAR", 1);
        assertTrue(value == 2.0);
    }


    @Test
    public void getAmountPronRegularPriceCodeOneDay() {
        double value = priceCodeRepository.calculate("PRON", 1);
        assertTrue(value == 2.0);
    }

    @Test
    public void getAmountPronRegularPriceCodeFourDay() {
        double value = priceCodeRepository.calculate("PRON", 4);
        assertTrue(value == 5.0);
    }
}
