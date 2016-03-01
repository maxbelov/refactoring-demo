package com.scrumtrek.simplestore;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by raz0r on 01.03.2016.
 */
public class JsonFormat implements ReportFormat {
    @Override
    public String format(Report r) throws ReportException {
        ObjectMapper m = new ObjectMapper();
        try {
            return m.writeValueAsString(r);
        } catch (IOException e) {
            throw new ReportException(e);
        }
    }

    public static void main(String[] args) throws ReportException {
        Customer c = new Customer("John");
        Movie m = new Movie("Inception", PriceCodes.NewRelease);
        Rental r = new Rental(m, 4);
        CompositeRental cr = new CompositeRental();
        cr.getRentals().add(r);
        c.addCompositeRental(cr);
        System.out.println(new JsonFormat().format(Report.getReport(c)));
        System.out.println(new StringReport().format(Report.getReport(c)));
    }
}
