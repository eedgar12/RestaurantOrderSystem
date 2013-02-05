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
            <select id="item" name="item">
                <option value="BURGER">Classic Burger</option>
                <option value="CLUB">Turkey Club Sandwich</option>
                <option value="REUBEN">Reuben Sandwich</option>
                <option value="QUICHE">Quiche</option>
                <option value="PASTA">Shrimp Pasta</option>
                <option value="SALMON">Pan Seared Salmon</option>
            </select><br/>
            <button type="submit" id="addItem" name="addItem">
                Get receipt for this item</button>
        </form>
        <form id="submitOrder" name="submitOrder" method="POST" action="ReceiptServlet">
        <button id="submitOrder" name="submitOrder" type="submit">Submit Order</button>
        </form>
    </body>
</html>
