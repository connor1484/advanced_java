package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.model.Person;
import com.origamisoftware.teach.advanced.model.StockMap;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;


public class DatabaseActivitiesService implements PersonService {


    /**
     * Get a list of people
     *
     * @return a list of Person instances
     * @throws ActivitiesServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */
    @Override
    public List<Person> getPerson() throws ActivitiesServiceException {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        List<Person> returnValue = null;
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Person.class);

            returnValue = criteria.list();

        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new ActivitiesServiceException("Could not get Person data. " + e.getMessage(), e);
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

        return returnValue;
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
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(person);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
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
    @SuppressWarnings("unchecked")
    public StockQuote getStocks(Person person) throws ActivitiesServiceException {
        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        List<StockQuote> stockQuotes = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(StockMap.class);
            criteria.add(Restrictions.eq("person", person));

            List<StockMap> list = criteria.list();
            for (StockMap stockMap : list) {
                stockQuotes.add(getStocks(person));
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
        return (StockQuote) stockQuotes;
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

        Session session =  DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            StockMap stockMap = new StockMap();
            stockMap.setSymbol(stockQuote);
            stockMap.setOwnerId(person);
            session.saveOrUpdate(stockMap);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

    }
}
