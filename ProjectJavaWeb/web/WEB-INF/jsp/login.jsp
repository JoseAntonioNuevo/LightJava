<!-- Añadimos formularios de spring, este es el form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Añadimos la libreria de jstl, es para usar los condicionales y los bucles de java. Esto sin necesidad de abrir y cerrar esrtas llaves '<%%>' -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        
        <link rel="stylesheet" href="CSS/estilos.css" type="text/css" /> <!-- -->
        <script src="JS/java.js"></script>
        <script src="JS/jquery-1.11.0.min.js"></script>
        <script src="JS/jquery.validate.js"></script>
        <!-- Añadimos el Bootstrap -->
        

        <!-- Optional theme -->
        

    </head>

    <body>
  
<%  
String profile_msg=(String)request.getAttribute("profile_msg");  
if(profile_msg!=null){  
out.print(profile_msg);  
}  
String login_msg=(String)request.getAttribute("login_msg");  
if(login_msg!=null){  
out.print(login_msg);  
}  
 %>  
  
      <div class="overlay">
<!-- LOGN IN FORM by Omar Dsoky -->
<form action="iniciar" method="post" onsubmit="return ValidacionLogin()">
   <!--   con = Container  for items in the form-->
   <div class="con">
   <!--     Start  header Content  -->
   <header class="head-form">
      <h2>Haz Login</h2>
      <!--     A welcome message or an explanation of the login form -->
      <p>Inicia sesión con tu usuario y contraseña</p>
   </header>
   <!--     End  header Content  -->
   <br>
   <div class="field-set">
        <!--   user name Input-->
      <input class="form-input" id="username" name="username" type="text" placeholder="Usuario">   
      <br>
      <!--   Password Input-->
      <input class="form-input" type="password" placeholder="Contraseña" id="password" name="password">
      <br>
<!--        buttons -->
<!--      button LogIn -->
      <button type="submit" class="log-in" value="login"> Log In </button>
   </div>
  
     
<!--   End Conrainer  -->
  </div>
  
  <!-- End Form -->
  <center>
  <p class="alerta" id="alerta"></p>
  </center>
</form>
</div>
 
    </body>
</html>
