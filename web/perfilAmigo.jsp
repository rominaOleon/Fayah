
<%@page import="controlador.InicioControlador"%>
<%@page import="util.Util"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="persistencia.ConexionBaseDeDatos"%>
<%@page import="persistencia.UsuarioDAO"%>
<%@page import="persistencia.UsuarioDAOSQL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <body>
    <head>
        <title>Fayah</title>


        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="css/estiloinicio.css" rel="stylesheet" media="screen">
        <link href='http://fonts.googleapis.com/css?family=Della+Respira' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Kotta+One' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Rokkitt' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Rum+Raisin' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="youtube.png">
        <link href="css/flat-ui.css" rel="stylesheet">
        <link href="css/flat-ui.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Ubuntu+Mono' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Amaranth' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Trykker' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Krona+One' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Belleza' rel='stylesheet' type='text/css'>




        <script type="text/javascript">
            function showhide(capa, sign)
            {
                obj = document.getElementById(capa);
                obj.style.display = obj.style.display == 'none' ? 'block' : 'none';
                sig = document.getElementById(sign);
                sig.innerHTML = sig.innerHTML == '+' ? '-' : '+';
            }
        </script> 







    </head>






    <div class="contenedor"> 
         <form name="formularioBusqueda" id="formularioBusqueda" method="post">
             
              <div class="lupa">
                  <a type="submit" onclick="document.formularioBusqueda.submit();">
              
                <img src="img/lupaicon.png"  width="25px" />
      
            </a>
        </div>

        <div class="home">
            <a href="inicio.jsp">
                <img src="img/Home_icon.png" alt="home icon" width="35px" /></a>
        </div>
        <div class="settings">
            <a href="settings.jsp">
            <img src="img/setting-icon3.png" alt="home icon" width="32px" /></a>
        </div>
        <div class="lock">
            <a href="index.jsp">
          <img src="img/logout.png" alt="home icon" width="29px"  /></a>
        </div>	
        <div class="message">
            <img src="img/message.png" alt="home icon" width="37px" />
        </div>	
     	
        <h1 class="demo-panel-title">Fayah

        </h1>
        
        
       
        <div class="todo-search">

            <input class="todo-search-field" type="text" name="newBusqueda"  placeholder="Search for people" id="labusqueda">
     
        </div> 

         </form>
    </div>

    <div class="columnleft">
        <div class="usuariodefault">
            <link href='http://fonts.googleapis.com/css?family=Share+Tech' rel='stylesheet' type='text/css'>
            <img src="<%=Util.amigoPerfil.getUsuario_foto() %>" width="175px" />
            <h4><%=Util.amigoPerfil.getUsuario_nombre()%> <%=Util.amigoPerfil.getUsuario_apellido()%> </h4>
        </br>    
        <h5><%=Util.amigoPerfil.getUsuario_username()%></h4>
        <h5><%=Util.amigoPerfil.getUsuario_ubicacion()%></h4>

        </div>
        
         
        <div class="photos">


            <div class="photoicon">
                <img src="img/photoicon.png" alt="photo icon" width="18px" />
            </div>
            <div class="photoicon2">
                <img src="img/friends.png" alt="photo icon" width="18px" />
            </div>




    </div>
       
        <a  href="album.jsp" class="h10">Album</a>
        <a href="friends.jsp" class="h11">Friends</a>
        
    </div>
    




    <div class="columnright">
        <div class="titulo">
        </div>
    </div>
    <div class="columnright2">

    </div>
        
    
</body>	
<%
  if (request.getParameter("newBusqueda") != null) {
          String busqueda = request.getParameter("newBusqueda");
                    
          Util.usuarios = InicioControlador.BuscarUsuario(busqueda);
          
          response.sendRedirect("resultFriends.jsp");
      }
%>


</html>