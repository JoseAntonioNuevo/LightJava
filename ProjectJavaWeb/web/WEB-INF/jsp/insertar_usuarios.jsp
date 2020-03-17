<!-- Añadimos formularios de spring, este es el form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Añadimos la libreria de jstl, es para usar los condicionales y los bucles de java. Esto sin necesidad de abrir y cerrar esrtas llaves '<%%>' -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INSERTAR</title>
        <script src="${pageContext.request.contextPath}/js/jquery-1.11.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
        <!-- Añadimos el Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="CSS/estilos.css" type="text/css" /> <!-- -->
        <script src="JS/java.js"></script>
        
    </head>

    <body>
              <%@ include file="mensajeStock.jsp" %>  
        <form:form method="post" modelAttribute="tactil" action="Insertar_usu" onsubmit="return ValidacionInsertUsu()">
            <table class="tablainsert">
                <thead><a href="usuarios"><img style="width: 100px; height: 80px; float: left;" src="IMG/flecha.png"></a><h1 style="text-align: center;">Formulario</h1></thead>
            <br>
                <tr> <!-- Hace antes la validación en cliente que en el servidor. Por tanto hasta que no se ejecuten todas las validaciones del cliente no se enviarán al servidor para que haga la validación. -->
                    <td><b>Nombre:</b></td>
                    <td><form:input class="form-control" path="nombre" id="nombre" name="nombre"/></td> <!-- el path es el atributo de la clase y lo puedo llamar desde css como si fuese una id. -->
                    
                </tr>
                <tr>
                    <td><b>Usuario:</b></td>
                    <td><form:input class="form-control" path="usuario" id="usuario" name="usuario"/></td>
                    </tr> 
                            <tr>
                    <td><b>Password:</b></td>
                    <td><form:input type="password" class="form-control" path="num_serie" id="num_serie" name="num_serie" /></td>
                    </tr> 
                             <tr>
                    <td><b>Confirmar Password:</b></td>
                     <td><form:input type="password" class="form-control" path="num_serie" id="pass2" name="pass2" /></td>
                             </tr> 
                          
                <tr>
                    <td></td>
                    <td><input type="submit" class="btn btn-warning" value="Registrar" id="boton" /></td>                    
                </tr>
                <p class="alerta" id="alerta"></p>
            </table>
        </form:form>
      
    </body>
</html>
