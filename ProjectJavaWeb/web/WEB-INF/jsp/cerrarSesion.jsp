<%-- 
    Document   : CerrarSesion
    Created on : 16-feb-2020, 22:55:54
    Author     : josew
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
session.invalidate();
  response.sendRedirect("index");
  %>

    </body>
</html>
