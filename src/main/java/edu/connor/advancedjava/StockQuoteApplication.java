package edu.connor.advancedjava;

import java.math.BigDecimal;
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

        //Check that arguments were provided
        if (args.length != 3){
            throw new NullPointerException("No args provided");
        }

        StockService stockService = StockServiceFactory.getInstance();


        String symbol = args[0];
        String from = args[1];
        String until = args[2];
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


        List<StockQuote> quotes = stockService.getQuote(symbol, fromDateCal, untilDateCal);

        System.out.println(fromDate);
        for (StockQuote stockQuote: quotes) {
            System.out.print("Stock Symbol: " + stockQuote.getStockSymbol() + "\n" + "Stock Date: " + stockQuote.getDateRecorded()
            + "\n" + "Stock Price: " + stockQuote.getStockPrice() + "\n");
        }

    }
}