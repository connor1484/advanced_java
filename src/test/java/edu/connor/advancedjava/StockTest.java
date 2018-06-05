package edu.connor.advancedjava;

import org.junit.Test;
import java.time.LocalDate;
import java.util.Calendar;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

public class StockTest {

    private String stockSymbol;
    private String date;
    private BigDecimal stockPrice;
    private StockQuote testQuote;

    @Before
    public void setup() {
        // create a known state of the Person object(also known as a baseline)
        stockSymbol = "ATHN";
        date = "2018-06-04";
        stockPrice = new BigDecimal(150.00);

        testQuote = new StockQuote(stockSymbol,date,stockPrice);
    }

    @Test
    public void testStockSymbol() {

        stockSymbol = testQuote.getStockSymbol();
        assertEquals("Stock test", "ATHN",stockSymbol);



    }

    @Test
    public void testDateRecorded() {

        date = testQuote.getDateRecorded();
        assertEquals("Date Test", "2018-06-04",testQuote.getDateRecorded());
    }

    @Test
    public void testStockPrice() {

        stockPrice = testQuote.getStockPrice();
        assertEquals("Price Test", 150.00,stockPrice.doubleValue());
    }


    @Test
    public void testNegativeStockSymbol() {

        stockSymbol = "NUAN";
        assertFalse("Stock negative test", stockSymbol == testQuote.getStockSymbol());

    }

    @Test
    public void testNegativeDateRecorded() {

        date = "2015-06-04";
        assertFalse("Date negative test", date == testQuote.getDateRecorded());
    }

    @Test
    public void testNegativeStockPrice() {

        Double wrongPrice = 199.00;
        assertFalse("Price negative test", wrongPrice == testQuote.getStockPrice().doubleValue());

    }



}