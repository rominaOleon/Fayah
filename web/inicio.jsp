
<%@page import="controlador.ResultFriendControlador"%>
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
         <SCRIPT Language=Javascript SRC="js/loginFace.js"></SCRIPT>


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
        
             
              <div class="lupa">
                  <a type="submit" onclick="document.formularioBusqueda.submit();">
              
                <img src="img/lupaicon.png"  width="25px" />
      
            </a>
        </div>
        
        <div class="lion" style="position: absolute; left: 1%;">
            
            <img src="img/lion.png" width="25px"/>
            
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
            <a href="index.jsp" onclick="FLogout();">
          <img src="img/logout.png" alt="home icon" width="29px"  /></a>
        </div>	
        <div class="message">
            <img src="img/message.png" alt="home icon" width="37px" />
        </div>	
        		
        <h1 class="demo-panel-title">Fayah

        </h1>
        
        
       
        <div class="todo-search">
            <form name="formularioBusqueda" id="formularioBusqueda" method="post">
                <input class="todo-search-field" type="text" name="newBusqueda"  placeholder="Search for people" id="labusqueda">
                <select class="select" name="opcion">
  <option value="friends">Friends</option>
  <option value="instagram">Instagram</option>
  <option value="youtube">Youtube</option>
  <option value="soundcloud">SoundCloud</option>
</select>
            </form>
            
        </div> 

      
    </div>

    <div class="columnleft">
        <div class="usuariodefault">
            <link href='http://fonts.googleapis.com/css?family=Share+Tech' rel='stylesheet' type='text/css'>
            <img src="<%=Util.usuario.getUsuario_foto()%>" width="175px" />
            <h4><%=Util.usuario.getUsuario_nombre()%> <%=Util.usuario.getUsuario_apellido()%> </h4>
        </br>    
        <h5><%=Util.usuario.getUsuario_username()%></h4>
        <h5><%=Util.usuario.getUsuario_ubicacion()%></h4>

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
    




        <div class="columnright" style="top: 16%">
            
            <%
                int posicion=0;
                int maximo = Util.notificaciones.size()-1;
                String icono="";
                String msg ="";
                while (posicion<=maximo){
                    
                    if (Util.notificaciones.get(posicion).getNotificacion_tipo().compareTo("amigo")==0){
                        icono="img/friend.png";
                        msg = Util.notificacionAmigoMsg(Util.notificaciones.get(posicion).getFk_amigo_id());
                    }
                    if (Util.notificaciones.get(posicion).getNotificacion_tipo().compareTo("comentario")==0){
                        icono="img/coments.png";
                        msg = Util.notificacionComentarioMsg(Util.notificaciones.get(posicion).getFk_comentario_id());
                    }
                    if (Util.notificaciones.get(posicion).getNotificacion_tipo().compareTo("like")==0){
                        icono="img/like.png";
                        msg=Util.notificacionLike(Util.notificaciones.get(posicion).getFk_like_id());
                    }
                    if (Util.notificaciones.get(posicion).getNotificacion_tipo().compareTo("dislike")==0){
                        icono="img/dislike.png";
                        msg=Util.notificacionDislike(Util.notificaciones.get(posicion).getFk_dislike_id());
                    }
                    if (Util.notificaciones.get(posicion).getNotificacion_tipo().compareTo("reply")==0){
                        icono="img/reply.png";
                        msg = "reply your comment";
                    }
                    if (Util.notificaciones.get(posicion).getNotificacion_tipo().compareTo("album")==0){
                        icono="img/album.png";
                        msg=Util.notificacionAlbumMsg(Util.notificaciones.get(posicion).getFk_album_id());
                    }
                    
                   
                        
                
                %>
      
        <div class="notificacion" style="left: 12%; position:relative">
            <form name="form<%=posicion%>" id="form<%=posicion%>" method="post">
                <img src="<%=icono%>" width="20px" style="float: left"/>
                <p style="float: left"><a href="#" onclick="document.form<%=posicion%>.submit();"><%=msg%></a></p> 
                <input type="text" name="notificacion" value="<%=posicion%>" style="width: 0;height: 0; visibility: hidden">
                <hr>
            </form>
        </div>
        <%posicion=posicion+1;}
                    %>
              
       
       
    </div>
   
        
        <div class="columnright2">

    </div>
        
    
</body>	
<%
                
if (request.getParameter("notificacion")!=null){
int posicionNot = Integer.parseInt(request.getParameter("notificacion"));

String tipo = Util.notificaciones.get(posicionNot).getNotificacion_tipo();

if (tipo.compareTo("amigo")==0){
    
   int idTabla= Util.notificaciones.get(posicionNot).getFk_amigo_id();
   int idAmigo = InicioControlador.idAmigo(idTabla);
   ResultFriendControlador.TraerAmigo(idAmigo);
   

  %>
                   
                  
                   <script>
                       window.location = "perfilAmigo.jsp";
                       
                   </script>
                          
                  
                   
<%
                 }

if (tipo.compareTo("comentario")==0){
    
    int idComentario = Util.notificaciones.get(posicionNot).getFk_comentario_id();
   int redirect =InicioControlador.idAlbum(idComentario);
    if (redirect ==1){
       %>
                        <script>
                       window.location = "albumContent.jsp";
                       
                   </script>
                       <%
    }
    else{
        
         %>
                        <script>
                       window.location = "albumAmigoContent.jsp";
                       
                   </script>
                       <%
    }
        
        
    }
}





 
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