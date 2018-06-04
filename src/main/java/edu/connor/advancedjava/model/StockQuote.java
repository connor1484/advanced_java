package edu.connor.advancedjava;

import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author Connor Ryan
 *
 * The purpose of this class is to provide the blueprint for creating a StockQuote Object
 */
public class StockQuote {

    private BigDecimal stockPrice;
    private String stockSymbol;
    private Date dateRecorded;

    public StockQuote(Date dateRecorded, BigDecimal stockPrice, String stockSymbol) {

        this.dateRecorded = dateRecorded;
        this.stockPrice = stockPrice;
        this.stockSymbol = stockSymbol;

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
    public Date getDateRecorded() { return dateRecorded; }

}