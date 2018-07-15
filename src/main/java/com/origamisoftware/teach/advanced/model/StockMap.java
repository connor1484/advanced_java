package com.origamisoftware.teach.advanced.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockmap")
public class StockMap {

    private int id;
    private Person ownerId;
    private StockQuote symbol;



    /**
     * Primary Key - Unique ID for a particular row in the person table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return 0;
    }

    /**
     * Set the unique ID for a particular row in the person table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the owner ID
     */
    @Basic
    @Column(name = "owner_id", nullable = false, insertable = true, updatable = true, length = 11)
    public Person getOwnerId() {
        return ownerId;
    }

    /**
     * Specify the owner ID of the stock
     * @param ownerId an int value
     */
    public void setOwnerId(Person ownerId) {
        this.ownerId = ownerId;
    }

    /**
     *
     * @return the symbol
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 256)
    public StockQuote getSymbol() {
        return symbol;
    }

    /**
     * Specify the symbol
     * @param symbol is a String value
     */
    public void setSymbol(StockQuote symbol) { this.symbol = symbol; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockMap stockMap = (StockMap) o;

        if (ownerId != stockMap.ownerId) return false;
        if (symbol != null ? !stockMap.equals(stockMap.symbol) : stockMap.symbol != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        //    result = 31 * result + ownerId;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", ownerId='" + ownerId + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }


}