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
      
        <SCRIPT Language=Javascript SRC="loginGoogle.js"></SCRIPT>
              
  

  <%-- parte de facebook que enseña los datos --%>
  
   

<div align="center">

<button id="loginText"  onClick='Flogin();' style="visibility: visible">LogInFace</button>

<div id="informacion">

<label id="nombreFace" >Nombre </label><br/>

<label id="apellidoFace" >Apellido:</label><br/>

<label id="emailFace" >Email: </label><br/>

<label id="cumpleFace" >Fecha de Nacimiento:</label><br/> 

<label id="direccionFace" >Direccion:</label><br/> 

<img id="img">

<p id="prueba">  </p>

</div>




<button id="loginText"  onClick='Flogout();' style="visibility: visible">Logout Face</button>
</div>
  
  
  
  
</body>
</html>


  
