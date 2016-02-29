package com.scrumtrek.simplestore;

/**
 * Created by raz0r on 29.02.2016.
 */
public enum PriceCodes {
    REGULAR(2, 2, 1.5),
    NEWRELEASE(0, 0, 3),
    CHILDREN(1.5, 3, 1.5);

    private final double startAmount;
    private final int startDays;
    private final double coefficient;

    PriceCodes(double startAmount, int startDays, double coefficient) {
        this.startAmount = startAmount;
        this.startDays = startDays;
        this.coefficient = coefficient;
    }

    public double getAmount(final int daysRented) {
        return startAmount + ((daysRented > startDays) ? (daysRented - startDays) * coefficient : 0);
    }
}
