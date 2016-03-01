package com.scrumtrek.simplestore;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by raz0r on 01.03.2016.
 */
public class JsonReportTest {
    @Test
    public void testEmptyHeader() throws ReportException {
        Report r = new Report();
        r.header.customerName = null;

        String result = new JsonFormat().format(r);
        assertTrue(result.contains("\"header\":{\"customerName\":null}"));
    }

    @Test
    public void testEmptyBody() throws ReportException {
        Report r = new Report();
        r.body = null;

        String result = new JsonFormat().format(r);
        assertTrue(result.contains("\"body\":null"));
    }


    @Test
    public void testEmptyFooter() throws ReportException {
        Report r = new Report();
        r.footer = null;

        String result = new JsonFormat().format(r);
        assertTrue(result.contains("\"footer\":null"));
    }
}
