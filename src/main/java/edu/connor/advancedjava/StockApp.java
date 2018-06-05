package edu.connor.advancedjava;

/**
 *
 * @author Connor Ryan
 *
 * Main Stock App that creates a Factory instance of Stock Service.
 * 
 */
public class StockApp {

    /**
     *  Main method
     *
     * @param args
     */
    public static void main(String[] args){

        StockService StockService = StockServiceFactory.getInstance();
    }
}