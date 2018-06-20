package edu.connor.advancedjava;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.math.BigDecimal;
import java.util.Calendar;


/**
 *
 * @author Connor Ryan
 *
 * The purpose of this class is to provide the blueprint for creating a StockQuote Object
 */

@Immutable
public class StockQuote {

    private BigDecimal stockPrice;
    private String stockSymbol;
    private Calendar dateRecorded;

    /**
     * StockQuote contstructor that sets the stock symbol, date recorded and the stock price
     *
     * @param stockSymbol
     * @param dateRecorded
     * @param stockPrice
     */
    public StockQuote(String stockSymbol, Calendar dateRecorded, BigDecimal stockPrice) {

        this.stockSymbol = stockSymbol;
        this.dateRecorded = dateRecorded;
        this.stockPrice = stockPrice;


    }

    /**
     * Return stock price of the stock
     *
     * @return stock price in BigDecimal Format
     *
     */
    public String getStockSymbol() { return stockSymbol;}

    /**
     * Return stock symbol for the stock
     *
     * @return stock symbol string
     */
    public BigDecimal getStockPrice() { return stockPrice;}

    /**
     * Return the recorded date for the stock
     *
     * @return recorded date of the stock
     */
    public Calendar getDateRecorded() { return dateRecorded; }

}