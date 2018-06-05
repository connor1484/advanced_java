package edu.connor.advancedjava;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 *
 * @author Connor Ryan
 *
 * The purpose of this class is to provide the blueprint for creating a StockQuote Object
 */
public class StockQuote {

    private BigDecimal stockPrice;
    private String stockSymbol;
    private String dateRecorded;

    /**
     * StockQuote contstructor that sets the stock symbol, date recorded and the stock price
     *
     * @param stockSymbol
     * @param dateRecorded
     * @param stockPrice
     */
    public StockQuote(String stockSymbol, String dateRecorded, BigDecimal stockPrice ) {

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
    public String getDateRecorded() { return dateRecorded; }

}