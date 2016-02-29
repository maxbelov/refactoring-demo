package com.scrumtrek.simplestore;

/**
 * Created by raz0r on 29.02.2016.
 */
public class PriceCodes {
    public static final PriceCodes REGULAR = new PriceCodes(2, 2, 1.5);
    public static final PriceCodes NEWRELEASE = new PriceCodes(0, 0, 3) {
        @Override
        public int getBonusPoints(int daysRented) {
            int bonusPoints = super.getBonusPoints(daysRented);
            return (daysRented > 1) ? bonusPoints + 1 : bonusPoints;
        }
    };
    public static final PriceCodes CHILDREN = new PriceCodes(1.5, 3, 1.5);
    public static final PriceCodes XXX = new PriceCodes(5, 3, 1) {
        @Override
        public int getBonusPoints(int daysRented) {
            int bonusPoints = super.getBonusPoints(daysRented);
            return (daysRented > 2) ? bonusPoints + 5 : bonusPoints;
        }
    };
    public static final int DEFAULT_BONUS_POINTS = 1;

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

    public int getBonusPoints(final int daysRented) {
        return DEFAULT_BONUS_POINTS;
    }
}
