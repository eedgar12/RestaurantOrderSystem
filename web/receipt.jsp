<%-- 
    Document   : receipt
    Created on : Feb 3, 2013, 3:19:35 PM
    Author     : Emma Edgar
    Purpose    : To display the user's order receipt, including tax, tip, and total.
--%>

<%@page import="javax.print.attribute.standard.MediaSize.Other"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Receipt</title>
        <meta http-equiv="description" content="Thank you for placing your order at David's Diner">
              
    </head>
    <body>
        <%
            if (request.getAttribute("receipt") != null) {
                    out.print(request.getAttribute("receipt"));
                }
           
            %>
    </body>
</html>
