package edu.connor.advancedjava;

import org.junit.Before;
import edu.connor.advancedjava.StockQuote;
import src.main.java.edu.connor.advancedjava.IntervalEnum;
import edu.connor.advancedjava.StockQuoteApplication;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import org.junit.Test;

public class StockTest {

    private String stockSymbol;
    private Date athenaDate;
    private BigDecimal stockPrice;
    private StockQuote testQuote;

    @Before
    public void setup() {
        // create a known state of the Person object(also known as a baseline)
        try {
            athenaDate = new SimpleDateFormat("mm/dd/yyyy").parse("11/20/2017");
            stockPrice = new BigDecimal(150.00);
            Calendar athenaDateCal = Calendar.getInstance();
            athenaDateCal.setTime(athenaDate);
            stockSymbol = "ATHN";
            testQuote = new StockQuote(stockSymbol, athenaDateCal, stockPrice);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testStockSymbol() {

        stockSymbol = testQuote.getStockSymbol();
        assertEquals("Stock test", "ATHN",stockSymbol);



    }

    @Test
    public void testDateRecorded() {
        try {
            athenaDate = new SimpleDateFormat("mm/dd/yyyy").parse("11/20/2017");
            Calendar athenaTestDate = Calendar.getInstance();
            athenaTestDate.setTime(athenaDate);
            assertEquals("Date Test", athenaTestDate, testQuote.getDateRecorded());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testStockPrice() {

        stockPrice = testQuote.getStockPrice();
        assertEquals("Price Test", 150.00,stockPrice.doubleValue());
    }


    @Test
    public void testNegativeStockSymbol() {

        stockSymbol = "AAPL";
        assertFalse("Stock negative test", stockSymbol == testQuote.getStockSymbol());

    }

    @Test
    public void testNegativeDateRecorded() {

        try {
            athenaDate = new SimpleDateFormat("mm/dd/yyyy").parse("11/11/2015");
            Calendar athenaTestDate = Calendar.getInstance();
            athenaTestDate.setTime(athenaDate);
            assertFalse("Date negative test", athenaTestDate == testQuote.getDateRecorded());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testNegativeStockPrice() {

        Double wrongPrice = 199.00;
        assertFalse("Price negative test", wrongPrice == testQuote.getStockPrice().doubleValue());

    }

    @Test(expected = NullPointerException.class)
    public void testMainNegative() {
        StockQuoteApplication.main(null);
    }

    @Test
    public void testInterval() {

        IntervalEnum interval = IntervalEnum.DAILY;
        assertEquals("interval test", interval, IntervalEnum.DAILY);
    }


    @Test
    public void testNegativeInterval() {

        String intervalTest = "daily";
        IntervalEnum interval = IntervalEnum.DAILY;
        assertFalse("interval test", interval == IntervalEnum.MONTHLY);
    }

}