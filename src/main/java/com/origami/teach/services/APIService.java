package com.origami.teach.services;
import com.origami.teach.model.StockQuote;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class APIService {


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
    public void getStock(String stockQuote){

        String _stockQuote = stockQuote;

        try {
            Stock Quote = YahooFinance.get(_stockQuote);
            System.out.println(Quote);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public StockQuote getQuote(String symbol) {
        // a dead simple implementation.
        return new StockQuote(new BigDecimal(100), Calendar.getInstance().getTime(), symbol);
    }


    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @param interval the number of stockquotes to get per a 24 hour period.
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */

    public StockQuote ListQuotes(String symbol, Calendar from, Calendar until, Interval interval) throws IOException {

        String _symbol = symbol;

        Stock quote = YahooFinance.get(_symbol);

        List<HistoricalQuote> stockHistQuotes = quote.getHistory(from, until, Interval.DAILY);

        System.out.println("test");
        System.out.println(_symbol);
        System.out.println(quote);

        return (StockQuote) stockHistQuotes;
    }


}