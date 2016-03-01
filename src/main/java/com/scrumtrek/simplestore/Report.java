package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raz0r on 01.03.2016.
 */
public class Report {
    public static class Header {
        public String customerName;
    }
    public static class Body {
        public List<CompositeRental> rentals = new ArrayList<>();
    }
    public static class Footer {
        public double total;
    }

    public Header header = new Header();
    public Body body = new Body();
    public Footer footer = new Footer();


    public static Report getReport(Customer c) {
        Report r = new Report();
        r.header.customerName = c.getName();
        r.body.rentals = c.getRentals();
        r.footer.total = c.totalAmount();
        return r;
    }

}
