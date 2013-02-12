<%-- 
    Document   : index
    Created on : Feb 2, 2013, 6:03:09 PM
    Author     : Toshiba laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="order" name="order" method="POST" action="OrderServlet">
            <input type="checkbox" name="food" value="Classic Burger - $5.65">Classic Burger - $5.65<br>
            <input type="checkbox" name="food" value="Turkey Club - $5.55">Turkey Club - $5.55<br>
            <input type="checkbox" name="food" value="Reuben Sandwich - $5.89">Reuben Sandwich - $5.89<br>
            <input type="checkbox" name="food" value="Quiche - $8.78">Quiche - $8.78<br>
            <input type="checkbox" name="food" value="Shrimp Pasta - $7.95">Shrimp Pasta - $7.95<br>
            <input type="checkbox" name="food" value="Pan Seared Salmon - $9.98">Pan Seared Salmon - $9.98<br>
            <br/>
            <button type="submit" id="addItem" name="addItem">
                Get receipt</button>
        </form>
     <%/*   <form id="submitOrder" name="submitOrder" method="POST" action="ReceiptServlet">
        <button id="submitOrder" name="submitOrder" type="submit">Submit Order</button>
        </form> */%>
    </body>
</html>
