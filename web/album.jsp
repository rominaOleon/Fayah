<%@page import="controlador.InicioControlador"%>
<%@page import="util.Util"%>
<!DOCTYPE html>

<html>
    <body>
    <head>
        <title>Album</title>

        <SCRIPT Language=Javascript SRC="js/loginFace.js"></SCRIPT>
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="css/estiloalbum.css" rel="stylesheet" media="screen">
        <link href="css/estiloinicio.css" rel="stylesheet" media="screen">
        <link href='http://fonts.googleapis.com/css?family=Della+Respira' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Kotta+One' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Rokkitt' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Marmelad' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Rum+Raisin' rel='stylesheet' type='text/css'>
        <link rel="shortcut icon" href="youtube.png">
        <link href="css/flat-ui.css" rel="stylesheet">
        <link href="flat-ui.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Ubuntu+Mono' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Amaranth' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Trykker' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Krona+One' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Belleza' rel='stylesheet' type='text/css'>









        <meta name="description" content="Galería de imágenes con CSS y HTML" />
        <meta name="keywords" content="galería de imagenes, css, html" />
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="Content-Style-Type" content="text/css" />
        <meta name="robots" content="all" />
        <meta name="author" content="Andrés Fernández" />
        <meta name="owner" content="LaWebera.es" />
        <meta name="Language" content="Spanish" />




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
                    <img src="img/logout.png" alt="home icon" width="29px" onclick="FLogout();"  /></a>
            </div>	
            <div class="message">
                <img src="img/message.png" alt="home icon" width="37px" />
            </div>	
            <h1 class="demo-panel-title">Fayah

            </h1>
            <div class="todo-search">

                <input class="todo-search-field" type="text" name="newBusqueda" placeholder="Search for people" id="laBusqueda">
                <select class="select" name="opcion">
                    <option value="friends">Friends</option>
                    <option value="instagram">Instagram</option>
                    <option value="youtube">Youtube</option>
                    <option value="soundcloud">SoundCloud</option>
                </select>


            </div>  
        </form>
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


                            <div class="photoicon2">
                                <img src="img/photoicon.png" alt="photo icon" width="25px" />
                            </div>
                            <h10 class="h10">Albums</h10>


                            <div class="span3">
                                <a href="newAlbum.jsp" class="btn btn-large btn-block btn-primary">+ Create Album</a>
                            </div>  



                            <div class="separador">
                                <HR width=80% align="left">
                            </div>





                            <div id="central">
                                <div id="titulos">

                                </div>
                                <div id="borde">



                                </div>


                                <table style="top: 15%; position: absolute">



                                    <%
                                        int posicion = 0;
                                        int contador = 0;
                                        int maximofila = 5;
                                        int eliminados = 0;
                                        int maximoalbums = Util.usuario.getUsuario_albums().size();
                                        while (posicion <= maximoalbums - 1) {

                                            if (Util.usuario.getUsuario_albums().get(posicion).getAlbum_show().compareTo("t") == 0) {

                                    %>      
                                    <td>

                                    <li>
                                        <a href=# type="submit" onclick="document.formAlbum<%=posicion%>.submit();">
                                            <img  class="min" src="<%=Util.usuario.getUsuario_albums().get(posicion).getAlbum_miniatura()%>" alt="#" />

                                            <label > <%=Util.usuario.getUsuario_albums().get(posicion).getAlbum_nombre()%> </label>
                                            <form name="formAlbum<%=posicion%>"  id="formAmigo<%=posicion%>" method="post">
                                                <input type="radio" checked="true" name="posAlbum" style="visibility: hidden" value="<%=posicion%>"/></form>
                                        </a>
                                    </li> 

                                    </td>

                                    <% } else {
                                            eliminados++;

                                        }
                                        contador = contador + 1;
                                        if (contador - eliminados == maximofila) {%>

                                    <tr>
                                        <%
                                                    contador = 0;

                                                }

                                                posicion = posicion + 1;
                                            }

                                        %>
                                        </ul>
                                </table>


                            </div>
                        </div>

                    </div>





                    <div class="columnright2">

                    </div>





                    <%

                        if (request.getParameter("newBusqueda") != null & (request.getParameter("opcion") != null)) {


                            if (request.getParameter("opcion").equals("friends")) {

                                String busqueda = request.getParameter("newBusqueda");

                                Util.usuarios = InicioControlador.BuscarUsuario(busqueda);
                                Util.instagramBusqueda = busqueda;
                    %>


                    <script>
            window.location = "resultFriends.jsp";

                    </script>



                    <%
                        }
                        if (request.getParameter("opcion").equals("instagram")) {

                            Util.instagramBusqueda = (String) request.getParameter("newBusqueda");

                    %>

                    <script>
                        window.location = "resultInstagram.jsp";

                    </script>



                    <%

                            }

                        }
                    %>

                    <% if (request.getParameter("posAlbum") != null) {

                            Util.posAlbum = Integer.parseInt(request.getParameter("posAlbum"));

                    %>
                    <script>
                        window.location = "albumContent.jsp";

                    </script>
                    <%
                        }
                    %>


                    </body>	
                    </html>