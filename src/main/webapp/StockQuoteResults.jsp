<%--
  Created by IntelliJ IDEA.
  User: connorryan
  Date: 7/24/18
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="StockQuote" class="com.origami.teach.model.StockQuote" scope="request"/>
<jsp:setProperty name="StockQuote" property="*" />

<html>
<head>
    <title><%= StockQuote.getSymbol() %></title>
</head>
<body>

Stock Symbol: <%= StockQuote.getSymbol() %>
Stock Date: <%= StockQuote.getDate() %>
Stock Price: <%= StockQuote.getPrice() %>


</body>
</html>
