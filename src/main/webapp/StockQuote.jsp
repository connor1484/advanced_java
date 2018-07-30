<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="StockQuote" class="com.origami.teach.model.StockQuote" scope="request"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stock Quote</title>

</head>
<body>

<h2>
    Please enter a stock quote: <br>
</h2>

<P></P>

<form name="myform" action="servlets/StockSearchServlet/" method="post">
    Symbol : <input type="text" name="symbol"><br>
    From : <input type="text" name="from"><br>
    Until : <input type="text" name="until">'><br>
    Yahoo Source :  <input type="radio" name="source" title="yahoo" value="yahoo">
    Database Source : <input type="radio" name="source" title="database" value="database"><br>

    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="submit" value="true">
</form>

</body>
</html>
