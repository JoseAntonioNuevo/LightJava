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
        <form:form method="post" modelAttribute="tactil" action="Insertar" onsubmit="return ValidacionInsertProd()">
            <table class="tablainsert">
                <thead><a href="productos?categoria=99&oferta=1&filtro_nombre="><img style="width: 100px; height: 80px; float: left;" src="IMG/flecha.png"></a><h1 style="text-align: center;">Formulario</h1></thead>
                <tr>
                    <form:errors path="nombre" style="color: red;" /><br>
                    <form:errors path="foto" style="color: red;" /><br>
                    <form:errors path="descripcion" style="color: red;" /><br>
                </tr>
                <tr> <!-- Hace antes la validación en cliente que en el servidor. Por tanto hasta que no se ejecuten todas las validaciones del cliente no se enviarán al servidor para que haga la validación. -->
                    <td><b>Nombre:</b></td>
                    <td><form:input class="form-control" path="nombre" id="nombre"/></td> <!-- el path es el atributo de la clase y lo puedo llamar desde css como si fuese una id. -->
                    
                </tr>
                <tr>
                    <td><b>Descripción:</b></td>
                    <td><form:textarea id="descripcion" path="descripcion" rows="5"  /></td>
                    <td><span id="error_password"> </span></td>
                </tr>
                <tr>
                    <td><b>Número de serie:</b></td>
                    <td><form:input class="form-control" path="num_serie" id="num_serie"  name="num_serie"/></td>
                    </tr> 
                            <tr>
                    <td><b>Descuento:</b></td>
                    <td><form:input class="form-control" path="descuento" id="descuento" name="descuento" /></td>
                    </tr> 
                             <tr>
                    <td><b>Categoria:</b></td>
                    <td><select class="form-control" path="categoria"  name="categoria"/>
                     <c:forEach var="tactil" items="${micat}">
                         
                    <option  value="${tactil.categoriaId}">${tactil.categoria}</option>  
                </c:forEach>
            </select>
                             </tr> 
                               <tr>
                    <td><b>Precio:</b></td>
                    <td><form:input class="form-control" path="precio" id="precio" name="precio" /></td>
                    </tr>
                                <tr>
                    <td><b>Cantidad:</b></td>
                    <td><form:input class="form-control" path="cantidad" id="cantidad"  name="cantidad"/></td>
                    </tr>
                            
                             <tr>
                    <td><b>Cantidad máxima de stock:</b></td>
                    <td><form:input class="form-control" path="stock_max" id="stock_max" name="stock_max"  /></td>
                    </tr>
                    
                        <tr>
                    <td><b>Cantidad minima de stock:</b></td>
                    <td><form:input class="form-control" path="stock_min" id="stock_min" name="stock_min"  /></td>
                    </tr>
                        <tr>
       
                    <td><b>Bloque:</b></td>
                   <td><select class="form-control" path="num_block" id="num_block" name="num_block"  />
     
                       <%
                           for (int i=1; i<=8; i++) {
                       %>
                       <option value="bloc <%=i %>">bloque <%=i %></option>
                       <%
                           }
                           %>
        </tr>
                    
                        <tr>
                    <td><b>Pasillo:</b></td>
                     <td><select class="form-control" path="num_passadis" name="num_passadis"   />
     
                       <%
                           for (int i=1; i<=12; i++) {
                       %>
                       <option value="passadis <%=i %>">pasillo <%=i %></option>
                       <%
                           }
                           %>
        </tr>
                    
                        <tr>
                    <td><b>LLeixa:</b></td>
                     <td><select class="form-control" path="num_lleixa" name="num_lleixa"   />
     
                       <%
                           for (int i=1; i<=8; i++) {
                       %>
                       <option value="lleixa <%=i %>">lleixa <%=i %></option>
                       <%
                           }
                           %>
        </tr>
                    
                         <tr>
                    <td><b>Foto:</b></td>
                    <td><form:input type="file" class="form-control-file" path="foto" id="foto" name="foto"   /></td>
                    </tr>
                    
                <tr>
                    <td></td>
                    <td><input type="submit" class="btn btn-warning" value="Registrar" id="boton" /></td> 
                    
                </tr>
                <tr>
                    <p class="alerta" id="alerta"></p>
                </tr>
                
            </table>
        </form:form>

        <script type="text/javascript">
            //el blur hace que se ejecute cuando pierda el foco.
            $('#password').blur(
                function() {
                    //este mensaje va a recibir el mensaje del servidor, pq primero va al servidor a coger el mensaje y luego lo ejecuta.
                    $('#error_password').load('myajax', "pass="+$('#password').val())
                }
            )
            
        </script>
      
    </body>
</html>
