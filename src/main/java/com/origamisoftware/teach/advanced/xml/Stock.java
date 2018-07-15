
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
 *       &lt;attribute name="age" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "symbol")
public class Stock implements XMLDomainObject {

    @XmlValue
    protected String symbol;
    @XmlAttribute(name = "symbol", required = true)
    @XmlSchemaType(name = "anySimpleType")

    protected String price;
    @XmlAttribute(name = "price", required = true)
    @XmlSchemaType(name = "anySimpleType")

    protected String date;
    @XmlAttribute(name = "date", required = true)
    @XmlSchemaType(name = "anySimpleType")


    /**
     * Sets the value of the symbol property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */


    public void setStockSymbol(String value) {
        this.symbol = value;
    }

    /**
     * Gets the value of the symbol property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */

    public String getStockSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */

    public void setPrice(String value) {
        this.price = value;
    }

    /**
     * Gets the value of the price property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */

    public String getPrice() {
        return price;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */

    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the date property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */

    public String getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "Stocks{" +
                "stock='" + symbol + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price +'\'' +
                '}';
    }
}
