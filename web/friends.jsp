<%@page import="controlador.InicioControlador"%>
<%@page import="controlador.FriendsControlador"%>
<%@page import="controlador.ResultFriendControlador"%>
<%@page import="util.Util"%>
<!DOCTYPE html>
<html>
    <body>
    <head>
        <title>Friends</title>
<SCRIPT Language=Javascript SRC="js/loginFace.js"></SCRIPT>

        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="css/estilografo.css" rel="stylesheet" media="screen">
        <link href="css/estiloinicio.css" rel="stylesheet" media="screen">
        <link href='css/http://fonts.googleapis.com/css?family=Della+Respira' rel='stylesheet' type='text/css'>
        <link href='css/http://fonts.googleapis.com/css?family=Kotta+One' rel='stylesheet' type='text/css'>
        <link href='css/http://fonts.googleapis.com/css?family=Rokkitt' rel='stylesheet' type='text/css'>
        <link href='css/http://fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
        <link href='css/http://fonts.googleapis.com/css?family=Rum+Raisin' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="youtube.png">
        <link href="css/flat-ui.css" rel="stylesheet">
        <link href="flat-ui.css" rel="stylesheet">
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
                    <img src="img/lupaicon.png" alt="home icon" width="25px" /></a>
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
                <a href="index.jsp">
                    <img src="img/logout.png" alt="home icon" width="29px" onclick="FLogout();" /></a>
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

                    <a  href="album.jsp" class="h12">Album</a>
                    <a href="friends.jsp" class="h11">Friends</a>

                    </div>

                    <div class="columnright">
                        <div class="cuadro">

                            <h10 class="h10">Friend List</h10>




                            <div class="separador">
                                <HR width=80% align="left">

                            </div>
                            <div class="fotoDefault">

                                <%
                                    int posicion = 0;

                                    int maximoamigos = Util.usuario.getUsuario_amigos().size() - 1;

                                    while (posicion <= maximoamigos) {

                                        int id;
                                        int idUsuario1;
                                        int idUsuario2;

                                        idUsuario1 = Util.usuario.getUsuario_amigos().get(posicion).getAmigo_fkusuario1();
                                        idUsuario2 = Util.usuario.getUsuario_amigos().get(posicion).getAmigo_fkusuario2();

                                        if (idUsuario1 == Util.usuario.getUsuario_id()) {
                                            id = idUsuario2;
                                        } else {
                                            id = idUsuario1;
                                        }

                                        String nombreAmigo = FriendsControlador.TraerNombreAmigo(id);
                                        String fotoAmigo = FriendsControlador.TraerFotoAmigo(id);
                                        String ubicacion = FriendsControlador.TraerUbicacionAmigo(id);

                                %>     


                                <div class="photoicon2">
                                    <img src=<%=fotoAmigo%> width="100px" />
                                    </br>                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>
                                    </br>

                                </div>
                                    <form name="formAmigo<%=posicion%>"  id="formAmigo<%=posicion%>"  method="post">
                                    <div class="span3">


                                        <input name="posPerfil" style="visibility: hidden" value="<%=posicion%>">
                                        <a type="submit"  onclick="document.formAmigo<%=posicion%>.submit();" class="btn btn-large btn-block btn-primary">View Profile</a>
                                    </div>  




                                    <div class="nombreUsu">
                                        <a><%=nombreAmigo%></a>                    </br>
                                        <a><%=ubicacion%></a>
                                        </br>
                                        </br>
                                        </br>
                                        </br>
                                        </br>
                                        </br>


                                    </div>

                                </form> 


                                <% posicion = posicion + 1;
                                    }
                                %>

                            </div>



                            <div class="separador2">
                                <HR width=80% align="left">

                            </div>

                        </div>

                    </div>
                    <div class="columnright2">

                    </div>

<%
           System.out.println(request.getParameter("posPerfil"));
                 if (request.getParameter("posPerfil") != null){

                     
                     
               String posicionPerfil = request.getParameter("posPerfil");
               int posPerfil = Integer.parseInt(posicionPerfil);
               
                                        int id;
                                        int idUsuario1;
                                        int idUsuario2;

                                        idUsuario1 = Util.usuario.getUsuario_amigos().get(posPerfil).getAmigo_fkusuario1();
                                        idUsuario2 = Util.usuario.getUsuario_amigos().get(posPerfil).getAmigo_fkusuario2();

                                        if (idUsuario1 == Util.usuario.getUsuario_id()) {
                                            id = idUsuario2;
                                        } else {
                                            id = idUsuario1;
                                        }
               
               ResultFriendControlador.TraerAmigo(id);

               %>
               
               
                   <script>
                       window.location = "perfilAmigo.jsp";
                       
                   </script>
                   
               
               
               
               <%
            }
%>
            
<%
    
    System.out.println(" opcion: " + request.getParameter("opcion"));
    System.out.println(" texto: " + request.getParameter("newBusqueda"));
    
    
  if (request.getParameter("newBusqueda") != null & (request.getParameter("opcion")!=null )) {
     
      
      if (request.getParameter("opcion").equals("friends")){

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
                                    
                                    
                                    
  
                    </body>	
                    </html>