package edu.connor.advancedjava;

import src.main.java.edu.connor.advancedjava.IntervalEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.System.exit;


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
        if (args.length != 4){
            throw new IllegalArgumentException("No args provided");
        }

        StockService stockService = StockServiceFactory.getInstance();


        String symbol = args[0];
        String from = args[1];
        String until = args[2];
        String interval = args[3];
        Date fromDate = null;
        Date untilDate = null;

        try {
            fromDate = new SimpleDateFormat("mm/dd/yyy").parse(from);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println("From Date must be in format mm/dd/yyy");
            exit(-1);
        }

        try {
            untilDate = new SimpleDateFormat("mm/dd/yyy").parse(until);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            System.out.println("Until Date must be in format mm/dd/yyy");
            exit(-1);
        }

        Calendar fromDateCal = Calendar.getInstance();
        fromDateCal.setTime(fromDate);
        Calendar untilDateCal = Calendar.getInstance();
        untilDateCal.setTime(untilDate);

        IntervalEnum chosenInterval;

        if (interval.equalsIgnoreCase("daily")) {
            chosenInterval = IntervalEnum.DAILY;
        } else if (interval.equalsIgnoreCase("weekly")) {
            chosenInterval = IntervalEnum.WEEKLY;
        } else if (interval.equalsIgnoreCase("monthly")) {
            chosenInterval = IntervalEnum.MONTHLY;
        } else if (interval.equalsIgnoreCase("yearly")){
            chosenInterval = IntervalEnum.YEARLY;
        } else chosenInterval = IntervalEnum.DAILY;


        List<StockQuote> quotes = stockService.getQuote(symbol, fromDateCal, untilDateCal, chosenInterval);

        System.out.println(fromDate);
        for (StockQuote stockQuote: quotes) {
            System.out.print("Stock Symbol: " + stockQuote.getStockSymbol() + "\n" + "Stock Date: " + stockQuote.getDateRecorded()
            + "\n" + "Stock Price: " + stockQuote.getStockPrice() + "\n" );
            System.out.println(chosenInterval);
        }

    }
}