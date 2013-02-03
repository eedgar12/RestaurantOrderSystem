<%-- 
    Document   : receipt
    Created on : Feb 3, 2013, 3:19:35 PM
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
        <%
            if (request.getAttribute("receipt") != null) {
                    out.print(request.getAttribute("receipt"));
                }

            %>
    </body>
</html>
