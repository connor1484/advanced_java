package edu.connor.advancedjava;

public class StockServiceFactory {

    public static StockService getInstance() {

        return new BasicStockService();
    }

}