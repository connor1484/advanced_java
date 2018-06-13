package edu.connor.advancedjava;

/**
 *
 * @author Connor Ryan
 *
 * Factory class for StockService that returns a BasicStockService object
 *
 */
public class StockServiceFactory {

    /**
     * Method to return a BasicStockInstance object
     *
     * @return BasticStockInstance Object
     */
    public static StockService getInstance() {

        return new BasicStockService();
    }

}