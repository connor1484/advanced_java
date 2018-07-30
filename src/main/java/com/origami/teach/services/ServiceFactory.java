package com.origami.teach.services;

/**
 * A factory that returns a Services.
 */
public class ServiceFactory {

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getStockService() {

        return new APIStockServiceAdaptor();
    }

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getDatabaseStockService() {
        return new DatabaseStockService();
    }

    /**
     *
     * @return get a <CODE>UserService</CODE> instance
     */
    public static UserService getUserService() {
        return new DatabaseUserService();
    }
}