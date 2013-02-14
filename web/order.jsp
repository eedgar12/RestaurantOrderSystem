<%


%>

<%-- 
    Document   : order
    Created on : Feb 12, 2013, 2:54:18 PM
    Author     : Toshiba laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Place order at David's Diner</title>
    </head>
    <body>
        <form id="order" name="order" method="POST" action="OrderServlet">
            <input type="checkbox" name="food" value="Classic Burger">Classic Burger - $5.65<br>
            <input type="checkbox" name="food" value="Turkey Club">Turkey Club - $5.55<br>
            <input type="checkbox" name="food" value="Reuben Sandwich">Reuben Sandwich - $5.89<br>
            <input type="checkbox" name="food" value="Quiche">Quiche - $8.78<br>
            <input type="checkbox" name="food" value="Shrimp Pasta">Shrimp Pasta - $7.95<br>
            <input type="checkbox" name="food" value="Pan Seared Salmon">Pan Seared Salmon - $9.98<br>
            <br/>
            <button type="submit" id="addItem" name="addItem">
                Get receipt</button>
        </form>
    </body>
</html>
