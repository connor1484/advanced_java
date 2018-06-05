package edu.connor.advancedjava;
import java.math.BigDecimal;

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

        String date = "2018-06-04";
        BigDecimal stockPrice = new BigDecimal(150.00);
        return new StockQuote("ATHN", date, stockPrice);
    }

}
