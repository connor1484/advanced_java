
package com.origamisoftware.teach.advanced.xml;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}stock"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "stock"
})
@XmlRootElement(name = "stocks")
public class Stocks implements XMLDomainObject {

    @XmlElement(required = true)
    protected Stock stock;

    /**
     * Gets the value of the stock property.
     *
     * @return
     *     possible object is
     *     {@link Stock }
     *
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Sets the value of the stock property.
     *
     * @param value
     *     allowed object is
     *     {@link Stock }
     *
     */
    public void setStock(Stock value) {
        this.stock = value;
    }


    @Override
    public String toString() {
        return "Stocks{" +
                "stock=" + stock +
                '}';
    }
}
