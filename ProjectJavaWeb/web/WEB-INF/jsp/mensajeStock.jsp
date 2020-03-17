<%-- 
    Document   : mensajeStock
    Created on : 21-feb-2020, 16:53:01
    Author     : josew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <div style="font-size: 12px; position: fixed; bottom: 0; border: 2px solid black; color: red; margin-left:1148px; width: 200px; background-color: yellow;" class="mensaje">
        <c:forEach var="tactil" items="${mistockMax}">
                         
             <p>Hay demasiadas unidades del producto ${tactil.nombre}, disponemos de ${tactil.cantidad} unidades, debería de haber como máximo ${tactil.stock_max}.</p>
                </c:forEach>
             
        <c:forEach var="tactil" items="${mistockMin}">
                         
             <p>Faltan unidades del producto ${tactil.nombre}, disponemos de solamente ${tactil.cantidad} unidades, debería de haber como mínimo ${tactil.stock_max}.</p>
                </c:forEach>
        </div>
    </body>
</html>
