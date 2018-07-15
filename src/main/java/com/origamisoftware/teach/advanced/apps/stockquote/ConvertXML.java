package com.origamisoftware.teach.advanced.apps.stockquote;

import com.origamisoftware.teach.advanced.xml.Stocks;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Marshall XML instance from file.
 */
public class ConvertXML {

    private static String xmlInstance;

    /**
     * Read in the XML file with a stream
     */

    private static String fileName = "/tmp/stocks_info.xml";

    //read file into stream, try-with-resources

    public static void main(String[] args) {

        Stream<String> stream;

        {
            try {
                stream = Files.lines(Paths.get(fileName));
                xmlInstance = stream.toString();


                // here is how to go from XML to Java
                JAXBContext jaxbContext = null;
                try {
                    jaxbContext = JAXBContext.newInstance(Stocks.class);
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                Unmarshaller unmarshaller = null;
                try {
                    unmarshaller = jaxbContext.createUnmarshaller();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                Stocks stocks = null;
                try {
                    stocks = (Stocks) unmarshaller.unmarshal(new StringReader(xmlInstance));
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                System.out.println(stocks.toString());

                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}