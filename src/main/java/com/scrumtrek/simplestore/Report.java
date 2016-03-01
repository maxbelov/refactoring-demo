package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Report {
    public static class Header {
        public String customerName;
    }
    public static class Body {
        public List<Rental> rentals;
    }
    public static class Footer {
        public double total;
    }

    public Header header;
    public Body body;
    public Footer footer;

    public static Report getReport(Customer c) {
        Report r = new Report();
        r.header = new Header();
        r.header.customerName = c.getName();
        r.body = new Body();
        r.body.rentals = new ArrayList<>();
        r.body.rentals.addAll(c.getRentals());
        r.footer = new Footer();
        r.footer.total = c.getTotal();
        return r;
    }
}
