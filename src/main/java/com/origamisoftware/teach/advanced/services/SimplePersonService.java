package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.Person;
import com.origamisoftware.teach.advanced.model.StockQuote;

import java.util.List;

class SimplePersonService implements PersonService {


    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    @Override
    public List<Person> getPerson() throws ActivitiesServiceException {
        return null;
    }

    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    @Override
    public void addOrUpdatePerson(Person person) throws ActivitiesServiceException {

    }

    /**
     * Get a list of all a person's stocks.
     *
     * @param person
     * @return a list of stocks instances
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    @Override
    public StockQuote getStocks(Person person) throws ActivitiesServiceException {
        return null;
    }

    /**
     * Assign a stock to a person.
     *
     * @param stockQuote The stock to assign
     * @param person     The person to assign the stock too.
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    @Override
    public void addStockToPerson(StockQuote stockQuote, Person person) throws ActivitiesServiceException {

    }
}
