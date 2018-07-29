package com.origami.teach.servlet;

import com.origami.teach.model.StockQuote;

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
    private static final String DATE = "date";
    private static final String PRICE = "price";

    // use this guy to instantiate a class of the service factory and pass params? Get params?

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String symbol = request.getParameter(SYMBOL);
        String price = request.getParameter(PRICE);
        String date = request.getParameter(DATE);

        HttpSession session = request.getSession();

        StockService stockService = ServiceFactory.getStockServiceInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date pdate = null;
        try {
            pdate = sdf.parse(DATE);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar. getInstance();
        cal.setTime(pdate);
        StockQuote stockQuote = new StockQuote(new BigDecimal(PRICE), pdate, SYMBOL);

        session.setAttribute("symbol", SYMBOL);
        session.setAttribute("price", PRICE);
        session.setAttribute("date", DATE);

        //StockQuote stockQuote = new StockQuote(new BigDecimal(PRICE), pdate, SYMBOL);

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher =
                servletContext.getRequestDispatcher("stockquoteResults.jsp");
        dispatcher.forward(request, response);

    }

}