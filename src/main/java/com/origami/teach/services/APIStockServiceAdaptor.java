package com.origami.teach.services;

import com.origami.teach.model.StockQuote;
import com.origami.teach.util.Interval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class APIStockServiceAdaptor implements StockService {


    private APIService apiQuote;

    public APIStockServiceAdaptor(){
        this.apiQuote = apiQuote;
    }


    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {

        return null;

    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol   the stock symbol to search for
     * @param from     the date of the first stock quote
     * @param until    the date of the last stock quote
     * @param interval the number of stockquotes to get per a 24 hour period.
     * @return a list of StockQuote instances
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) throws StockServiceException {

        List<StockQuote> stockQuotes = new ArrayList<>();

        try { stockQuotes.add(apiQuote.ListQuotes(symbol,from,until, yahoofinance.histquotes.Interval.DAILY));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockQuotes;
    }
}
