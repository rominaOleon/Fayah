<%-- 
    Document   : index
    Created on : 20/10/2013, 06:03:04 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE jsp>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PDS</title>
        <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Lobster">
        <link rel="stylesheet" type="text/css" href="style.css">
        <style type="text/css">
  html, body { margin: 0; padding: 0; }
  .hide { display: none;}
  .show { display: block;}
  </style>
        
        
    </head>
    <body style="background:#2980b9" align="center">
        
        
        
        <h1 align=center>Fayah en Modo Prueba</h1>
        <div align=center id="fb-root"></div>
        
 
 <!-- BOTONES DE LOGIN Y LOGOUT DE AMBOS-->
 
 
 

        <SCRIPT Language=Javascript SRC="loginFace.js"></SCRIPT>
      
        
              
  

  <%-- parte de facebook que enseña los datos --%>
  
   

<div align="center">

    



<form name="formularioUsuario" id="formularioUsuario" method="post"  >
<input type="text" name="nombreFace" hidden="true" > 
<input type="text" name="apellidoFace" hidden="true" > 
<input type="text" name="emailFace" hidden="true"  > 
<input type="text" name="cumpleFace" hidden="true"> 
<input type="text" name="direccionFace" hidden="true" > 
<input type="text" name="fotoFace" hidden="true" > 

</form>

<button id="loginText"  onClick='Flogin();' style="visibility: visible">LogInFace</button>






<img id="img">

<p id="prueba">  </p>

</div>




  <button id="loginText" type="submit"  onClick='Flogout();' style="visibility: visible">Logout Face</button>
</div>
  
  
  
  
</body>



<%= request.getParameter("nombreFace")%>

<%= request.getParameter("apellidoFace") %>

<%= request.getParameter("direccionFace") %>
<%= request.getParameter("emailFace") %>
<%= request.getParameter("cumpleFace") %>
<%= request.getParameter("fotoFace") %>


<% System.out.println(request.getParameter("nombreFace"));%>

<% System.out.println(request.getParameter("apellidoFace")); %>

<% System.out.println(request.getParameter("direccionFace")); %>
<% System.out.println(request.getParameter("emailFace")); %>
<% System.out.println(request.getParameter("cumpleFace")); %>
<% System.out.println(request.getParameter("fotoFace")); %>
</html>


  
