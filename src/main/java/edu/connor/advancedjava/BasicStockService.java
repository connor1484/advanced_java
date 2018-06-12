package edu.connor.advancedjava;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


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
    public StockQuote getQuote(String symbol) {

        return new StockQuote("ATHN", Calendar.getInstance(), new BigDecimal(20.00));
    }

    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {

        List<StockQuote> stockQuotes = new ArrayList<>();

        Date applDate = null;
        try {
            applDate = new SimpleDateFormat("mm/dd/yyyy").parse("06/12/1985");
            Calendar applDateFinal = Calendar.getInstance();
            applDateFinal.setTime(applDate);

            stockQuotes.add(new StockQuote("APPL",applDateFinal, new BigDecimal("15.00")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date googDate = null;
        try {
            googDate = new SimpleDateFormat("mm/dd/yyyy").parse("01/01/2018");
            Calendar googDateFinal = Calendar.getInstance();
            googDateFinal.setTime(googDate);

            stockQuotes.add(new StockQuote("GOOG",googDateFinal, new BigDecimal("35.00")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

}
