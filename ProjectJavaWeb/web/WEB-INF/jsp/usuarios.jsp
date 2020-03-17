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
         
       <a href="productos?categoria=99&oferta=1&filtro_nombre=">Administración de productos</a>
        
        <br><br>
        <div class="container">
                 
      
      
      
        <table class="tabla">
            <thead class="cabecera">
            <tr style="border: 2px solid black; height: 40px;">
                <th>ID</th>
                <th>Usuarios</th>
                 <th>Nombre</th>
                 <th>Operaciones</th>
                <th><a href="insertar_usuarios"><button type="button" class="insertar">Insertar</button></a></th>
            
            </tr>
           
            </thead>
            
                <c:forEach var="tactil" items="${miusu}">
                <tr style="border: 1px solid black;">
                     <td style="width:200px; height: 150px;"> ${tactil.categoriaId} </td>
                    <td>${tactil.categoria}</td>
                    <td>${tactil.descripcion}</td>
                    <td> <a href="editar_usuarios?nombre=${tactil.descripcion}&usuario=${tactil.categoria}&categoriaId=${tactil.categoriaId}"><img style="width:45px;" src="./IMG/edit.png" alt="edit"/></a><a href="eliminar_usuarios?user=${tactil.categoriaId}"><img style="width:45px;"  src="./IMG/papelera.png" alt="borrar"/></a></td>
                    <td></td>
               
                </tr>
                </c:forEach>
            
        </table>
            <div align="right">
            
            </div>
        </div>
        
        </body>
</html>