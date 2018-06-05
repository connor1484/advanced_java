package edu.connor.advancedjava;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.math.BigDecimal;

public class BasicStockService implements StockService {

    /**
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return should be the stock symbol, date and price.
     */

    public StockQuote getQuote(String symbol) {

        String date = "2018-06-04";
        BigDecimal stockPrice = new BigDecimal(150.00);
        return new StockQuote("ATHN", date, stockPrice);
    }

}
