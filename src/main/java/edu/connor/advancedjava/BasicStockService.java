package edu.connor.advancedjava;

import src.main.java.edu.connor.advancedjava.IntervalEnum;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static java.lang.System.exit;


/**
 *
 * @author Connor Ryan
 *
 * Basic Stock Service class that returns a StockQuote object
 *
 */
public class BasicStockService implements StockService {

    /**
     * Method that returns a StockQuote object with a symbol, date and price.
     *
     * @param symbol the stock symbol of the company you want a quote for.
     * e.g. APPL for APPLE
     *
     * @return StockQuote Object
     */

    @Override
    public StockQuote getQuote(String symbol) {

        return new StockQuote("ATHN", Calendar.getInstance(), new BigDecimal(20.00));
    }


    /**
     * @param symbol the stock symbol of the company you want a quote for.
     * @param from the beginning date of the stock
     * @param until the end date of the stock
     * @param intervalEnum the interval to check for a quote
     * @return StockQuote list
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum intervalEnum) {

        List<StockQuote> stockQuotes = new ArrayList<StockQuote>();

        Date applDate = null;
        try {
            applDate = new SimpleDateFormat("mm/dd/yyyy").parse("06/12/1985");
            Calendar applDateFinal = Calendar.getInstance();
            applDateFinal.setTime(applDate);

            stockQuotes.add(new StockQuote("APPL",applDateFinal, new BigDecimal("15.00")));
        } catch (ParseException e) {
            e.getMessage();
            exit(-1);
        }

        Date googDate = null;
        try {
            googDate = new SimpleDateFormat("mm/dd/yyyy").parse("01/01/2018");
            Calendar googDateFinal = Calendar.getInstance();
            googDateFinal.setTime(googDate);

            stockQuotes.add(new StockQuote("GOOG",googDateFinal, new BigDecimal("35.00")));
        } catch (ParseException e) {
            e.getMessage();
            exit(-1);
        }

        return stockQuotes;
    }

}
