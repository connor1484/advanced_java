package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.model.Person;

import java.util.List;

public interface PersonService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    List<Person> getPerson() throws ActivitiesServiceException;

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    void addOrUpdatePerson(Person person) throws ActivitiesServiceException;


    /**
     * Get a list of all a person's stocks.
     *
     * @return a list of stocks instances
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    StockQuote getStocks(Person person) throws ActivitiesServiceException;

    /**
     * Assign a stock to a person.
     *
     * @param stockQuote  The stock to assign
     * @param person The person to assign the stock too.
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    public void addStockToPerson(StockQuote stockQuote, Person person) throws ActivitiesServiceException;

}
