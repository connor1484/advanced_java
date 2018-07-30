package com.origami.teach.servlet;

import com.origami.teach.model.StockQuote;
import com.origami.teach.services.StockService;
import com.origami.teach.services.ServiceFactory;
import com.origami.teach.model.StockQuery;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/**
 * Simple Example of how a servlet can access form submission data
 * and act on it accordingly.
 */

public class StockSearchServlet extends HttpServlet {

    private StockService stockService;

    private static final String SYMBOL = "symbol";
    private static final String FROM = "from";
    private static final String UNTIL = "until";
    private static final String SOURCE = "source";

    // use this guy to instantiate a class of the service factory and pass params? Get params?

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String symbol = request.getParameter(SYMBOL);
        String from = request.getParameter(FROM);
        String until = request.getParameter(UNTIL);
        String source = request.getParameter(SOURCE);
        StockQuery stockQuery = null;

        HttpSession session = request.getSession();


        try {
            stockQuery = new StockQuery(symbol, from, until);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (source.equals("yahoo")) {
            stockService = ServiceFactory.getStockService();
        } else if (source.equals("database")) {
            stockService = ServiceFactory.getDatabaseStockService();
        }


        session.setAttribute("symbol", SYMBOL);
        session.setAttribute("from", FROM);
        session.setAttribute("until", UNTIL);

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher =
                servletContext.getRequestDispatcher("/StockQuoteResults.jsp");
        dispatcher.forward(request, response);

    }

}