package com.scrumtrek.simplestore;

/**
 * Created by raz0r on 01.03.2016.
 */
public class StringReport implements ReportFormat {
    @Override
    public String format(Report r) throws ReportException {
        StringBuilder sb = new StringBuilder();
        if (r.header != null) sb.append("Customer: " + r.header.customerName).append("\n");
        if (r.body != null) {
            sb.append("Rentals: ").append("\n");
            r.body.rentals.forEach(cr -> {
                cr.getRentals().forEach(rr -> {
                    sb.append("Rental: " + rr.getMovie().getTitle() + "; " + rr.getDaysRented()).append("days \n");
                });
                sb.append("Rental total: " + cr.totalAmount()).append("\n");
            });
        }
        if (r.footer != null) {
            sb.append("Total: " + r.footer.total).append("\n");
        }
        return sb.toString();
    }
}
