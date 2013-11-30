<%@page import="controlador.InicioControlador"%>
<%@page import="util.Util"%>
<%@page import="controlador.IndexControlador"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <link href="css/estiloIndex.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Della+Respira' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Kotta+One' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Rokkitt' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Rum+Raisin' rel='stylesheet' type='text/css'>
    <link rel="shortcut icon" href="img/losfayah.png">
    <link href="css/flat-ui.css" rel="stylesheet">
    <link href="flat-ui.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Ubuntu+Mono' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Amaranth' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Trykker' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Krona+One' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Belleza' rel='stylesheet' type='text/css'>
    <link href="css/rotador.css" rel="stylesheet" media="screen">
    <head> 


    </head> 
    <body>
        <SCRIPT Language=Javascript SRC="js/loginFace.js"></SCRIPT>


       <div class="contenedor">
 			
<h1 class="demo-panel-title">Fayah</h1>
<img src="img/lion.png" width="50px" style="position: absolute; left: 19%;"/>
</div>

        <div class="contenedor2">
	  <div class="facebook">
                <form name="formularioUsuario"  id="formularioUsuario" method="post"style="width: 1px; height: 1px">
                    <button  type="submit" id="fb-root"> 
                        <fb:login-button size="xlarge" onlogin="document.formularioUsuario.submit();" 
                                         scope="email,user_photos,user_hometown,user_birthday" width="200" 
                                         max-rows="3"></fb:login-button>
                    </button>
                    <input type="text" name="nombreFace" style="visibility: hidden"> 
                    <input type="text" name="apellidoFace" style="visibility: hidden" > 
                    <input type="text" name="emailFace" style="visibility: hidden"> 
                    <input type="text" name="cumpleFace" style="visibility: hidden"> 
                    <input type="text" name="direccionFace" style="visibility: hidden"> 
                    <input type="text" name="fotoFace" style="visibility: hidden"> 
                    <input type="text" name="usuarioFace" style="visibility: hidden"> 

                </form>
              
              

            </div> 




         
            
             <form name="formularioBusqueda" id="formularioBusqueda" method="post">

                <div class="lupa">
                    <a type="submit" onclick="document.formularioBusqueda.submit();">

                        <img src="img/lupaicon.png"  width="25px" />

                    </a>
                </div>
                <div class="todo-search">

                    <input class="todo-search-field" type="text" style="width: 65%" name="newBusqueda"  placeholder="Search in Fayah" id="labusqueda">

                </div>

            </form>
      
</div>

 	


				<div class="separador">
					<HR width=100% align="left">
				</div>
				
				
		   <h4 class="demo-panel-title">Connect with your friends
            
            and share the best of Yotube, Instagram and Soundcloud.</h4>
            
            <div class="youtube">
	  			<img src="img/youtube.png" alt="foto logo facebook" width="150px" />
	  	    </div>
	  	    <div class="instagram">
	 			<img src="img/instagram.png" alt="foto logo facebook" width="150px" />
	  		</div>
	  		<div class="soundcloud">
	  			<img src="img/soundcloud.png" alt="foto logo facebook" width="150px" />
	 	    </div> 
       
	  <h5 class="demo-panel-title">Fayah, Inc. Copyright 2013</h5>

        <%
            
            System.out.println(request.getParameter("newBusqueda"));
            
            
            String username = request.getParameter("usuarioFace");
            String nombre = request.getParameter("nombreFace");
            String apellido = request.getParameter("apellidoFace");
            String email = request.getParameter("emailFace");
            String fecha_nacimiento = request.getParameter("cumpleFace");
            String ubicacion = request.getParameter("direccionFace");
            String foto = request.getParameter("fotoFace");

            if (email != null) {
                if ((email.compareTo("undefined") != 0)
                        && (email.compareTo("") != 0)) {
                    Util.usuario = IndexControlador.LogIn(username, nombre, apellido, email,
                            fecha_nacimiento, ubicacion, foto);
                   %>
                   
                   
                   <script>
                       window.location = "inicio.jsp";
                       
                   </script>
                   
                   
<%
                 }
            }

%>
    </body> 
    
<%
 
  if (request.getParameter("newBusqueda") != null & (request.getParameter("opcion")!=null )) {
     
      
      if (request.getParameter("opcion").equals("friends")){
           System.out.println("por aqui");
          String busqueda = request.getParameter("newBusqueda");
                    
          Util.usuarios = InicioControlador.BuscarUsuario(busqueda);
          Util.instagramBusqueda= busqueda;
          %>
                   
                  
                   <script>
                       window.location = "resultFriends.jsp";
                       
                   </script>
                          
                  
                   
<%
                 }
      if (request.getParameter("opcion").equals("instagram")){
          
          Util.instagramBusqueda=(String)request.getParameter("newBusqueda");
          
          %>
          
                   <script>
                       window.location = "resultInstagram.jsp";
                       
                   </script>
          
          
          
          <%
          
      }
      
      }
%>
</html>
