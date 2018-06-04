package edu.connor.advancedjava;
//import StockService;
//import StockQuote;

public class StockServiceFactory {

    public static BasicStockService getStockService(StockQuote stock) {
        return new BasicStockService();
    }


}