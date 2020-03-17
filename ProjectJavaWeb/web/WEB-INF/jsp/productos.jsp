<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRODUCTOS</title>
        
        <!-- Añadimos el Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <!--end bootstrap -->
        <link rel="stylesheet" href="CSS/estilos.css" type="text/css" /> <!-- -->
        <script src="js/java.js"></script>
    </head>

    <body>
         <div style="float: left; font-size: 20px; margin-left: 10px;">
       
          <%  
    if(session.getAttribute("usuario") == null){
          response.sendRedirect("index");
    }
  
HttpSession s=request.getSession();
String usuario = (String)s.getAttribute("usuario");
 out.println("Bienvenido "+usuario);
%>   
         </div>
        
         <div style="font-size: 20px; margin-right: 10px;" align="right">
    <a href="cerrarSesion">cerrar sesión</a>
         </div>
         
      <a href="usuarios">Administración de usuarios</a>
        
        <br><br>
        <div class="container">
                 
      
      
      
        <table class="tabla">
            <form method="get" modelAttribute="tactil" action="productos">  
            <td><b>Categoria:</b></td>
                    <td><select class="form-control" path="categoria"  name="categoria"/>
                    <option  value="99"> Todos</option>  
                        <c:forEach var="tactil" items="${micat}">
                         
                    <option  value="${tactil.categoriaId}">${tactil.categoria}</option>  
                </c:forEach>
            </select>
                        <br>
<input type="radio" name="oferta" value="1" checked>Todos

<br>

<input type="radio" name="oferta" value="2">Oferta

<br>
<input type="text" name="filtro_nombre">
<img  style="width: 25px;" src="./IMG/lupa.png" alt="lupa"/>

<br><br>
         <input type="submit" class="btn btn-warning" value="Filtrar" id="boton" />
        </form>
            <thead class="cabecera">
            <tr style="border: 2px solid black; height: 40px;">
                <th>Foto</th>
                <th>Información del producto</th>
                <th>Operaciones</th>
                <th><a href="insertar_prod"><button type="button" class="insertar">Insertar</button></a></th>
            
            </tr>
           
            </thead>
                <c:forEach var="tactil" items="${milista}">
                <tr style="border: 1px solid black;">
                     <td style="width:200px; height: 150px;"> <img style="width:160px; margin: 7%;  " src="IMG/${tactil.foto}" alt=""/> </td>
                    <td>Nombre del Producto: ${tactil.nombre} <br> Descripción del Producto:
                        ${tactil.descripcion} <br>  categoria: ${tactil.categoria}
                        <br> Descuento:
                        ${tactil.descuento}%</td>   
                    <td> <a href="editar_prod?nombre=${tactil.nombre}&foto=${tactil.foto}&descripcion=${tactil.descripcion}&num_serie=${tactil.num_serie}&descuento=${tactil.descuento}&categoria=${tactil.categoriaId}&precio=${tactil.precio}&cantidad=${tactil.cantidad}&stock_max=${tactil.stock_max}&stock_min=${tactil.stock_min}&num_block=${tactil.num_block}&num_passadis=${tactil.num_passadis}&num_lleixa=${tactil.num_lleixa}"><img style="width:45px;" src="./IMG/edit.png" alt="edit"/></a><a href="eliminar_producto?producto=${tactil.prod_id}&serie=${tactil.categoriaId}&lloc=${tactil.lloc_id}&estoc=${tactil.cantidad}"><img style="width:45px;"  src="./IMG/papelera.png" alt="borrar"/></a></td>
                    <td></td>
                </tr>
                </c:forEach>
            
        </table>
            <div align="right">
            
            </div>
        </div>
        <p><%@ include file="mensajeStock.jsp" %></p>
        </body>
</html>