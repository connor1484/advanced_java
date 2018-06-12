package edu.connor.advancedjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;



/**
 *
 * @author Connor Ryan
 *
 * Main Stock App that creates a Factory instance of Stock Service.
 *
 */
public class StockQuoteApplication {

    /**
     *  Main method
     *
     * @param args
     */
    public static void main(String[] args){

        StockService StockService = StockServiceFactory.getInstance();

        String from = "11/20/2017";
        String until = "01/20/2018";
        String symbol = "NUAN";
        Date fromDate = null;
        Date untilDate = null;

        try {
            fromDate = new SimpleDateFormat("mm/dd/yyy").parse(from);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println("From Date must be in format mm/dd/yyy");
        }

        try {
            untilDate = new SimpleDateFormat("mm/dd/yyy").parse(until);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println("Until Date must be in format mm/dd/yyy");
        }

        Calendar fromDateCal = Calendar.getInstance();
        fromDateCal.setTime(fromDate);
        Calendar untilDateCal = Calendar.getInstance();
        untilDateCal.setTime(untilDate);

        List<StockQuote> quotes = StockService.getQuote(symbol, fromDateCal, untilDateCal);

        for (StockQuote stockQuote: quotes) {
            System.out.print("Stock Quote: " + stockQuote);
        }

    }
}