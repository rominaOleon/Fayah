
<%@page import="controlador.FriendsControlador"%>
<%@page import="controlador.CargarComentarioControlador"%>
<%@page import="controlador.ComentarioControlador"%>
<%@page import="controlador.AlbumAmigoContentControlador"%>
<%@page import="controlador.AlbumContentControlador"%>
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

        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
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
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <meta name="Author" content="httphotos">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/slimbox2.js"></script>
        <link rel="stylesheet" href="css/slimbox2.css" type="text/css" media="screen">
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function() {
                $('.carousel').carousel()
            });
        </script>
        <script>
            $(document).ready(function() {
                $('.carousel').carousel({
                    interval: 3000
                });
            });
        </script>



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





                    <div class="columnright">
                        <div class="titulo">

                            <div id="myCarousel" class="carousel slide">
                                <ol class="carousel-indicators">
                                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                    <li data-target="#myCarousel" data-slide-to="1"></li>
                                    <li data-target="#myCarousel" data-slide-to="2"></li>
                                    <li data-target="#myCarousel" data-slide-to="3"></li>
                                    <li data-target="#myCarousel" data-slide-to="4"></li>
                                </ol>
                                <!-- Carousel items -->
                                <div class="carousel-inner">

                                    <%
                                        AlbumAmigoContentControlador.traerContenido(Util.posAlbum, Util.usuario);

                                        for (int posicion = 0; posicion <= Util.listaContenido.size() - 1; posicion++) {
                                            if ((posicion == 0) && (Util.listaContenido.get(posicion) != null)) {
                                    %>   

                                    <div class="active item"><img src="<%=Util.listaContenido.get(posicion).getContenido_url()%>" alt="banner<%=posicion + 1%>" />
                                        <form method="post" name="formContent0" id="formContent0">
                                            <input name="posContent" value="<%=posicion%>" style=" visibility: hidden;height: 0px;width: 0px" />
                                            <a href="#" class="btn btn-primary" style="position: absolute;top: 98.2%;" onclick="document.formContent<%=posicion%>.submit()">Delete this Content from Album</a>
                                        </form>
                                    </div>

                                    <%} else {%>
                                    <div class="item"><img src="<%=Util.listaContenido.get(posicion).getContenido_url()%>" alt="banner<%=posicion + 1%>"  />

                                        <form method="post" name="formContent<%=posicion%>" id="formContent0">
                                            <input name="posContent" value="<%=posicion%>" style=" visibility: hidden;height: 0px;width: 0px" />
                                            <a href="#" class="btn btn-primary" style="position: absolute;top: 98.2%;" onclick="document.formContent<%=posicion%>.submit();">Delete this Content from Album</a>
                                        </form></div>

                                    <%
                                            }
                                        }

                                    %>




                                </div>
                                <!-- Carousel nav -->
                                <a class="carousel-control left" style="left: 0%;top: 50%;" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                                <a class="carousel-control right" style="left: 88%;top: 50%;" href="#myCarousel" data-slide="next">&rsaquo;</a>
                            </div>


                        </div>

                    </div>




                    <div class="columnright2" style="width: 25%;">

                        <h2 style="position: relative;"><%=Util.usuario.getUsuario_albums().get(Util.posAlbum).getAlbum_nombre()%></h2>

                        <%          int likeAlbum = Util.usuario.getUsuario_albums().get(Util.posAlbum).getAlbum_likes();
                            int dislikeAlbum = Util.usuario.getUsuario_albums().get(Util.posAlbum).getAlbum_dislikes();
                        %>


                        <form method="post" name="formAlbum" id="formAlbum">
                            <input name="deleteAlbum" value="0" style=" visibility: hidden;height: 0px;width: 0px" />
                            <a  style="position: relative;left: -2%;font-size: 82%;color: grey;" href="#" onclick="document.formAlbum.submit();">Delete this Album</a>
                        </form>



                        <div class="Rating" style="position: relative;top: -3%;">


                            <div class="likes" style="position: relative;">
                                <form method="post" name="formRating" id="formRating">
                                    <h5 style="float:left"> <img  src="img/like.png" width="30px" style="float: left"><%=likeAlbum%></h5>
                                    <input type="text" value="0" name="rating" style="width: 0;height: 0;visibility: hidden;float: left;">
                                </form>
                            </div>

                            <div class="dislikes" style="position: relative;">
                                <form method="post" name="formRating2" id="formRating">

                                    <h5 style="float:left"><img  src="img/dislike.png" width="30px" style="float: left"><%=dislikeAlbum%></h5>
                                    <input type="text" value="1" name="rating" style="width: 0;height: 0;visibility: hidden;float: left;">
                                </form>
                            </div>

                        </div>

                        <div class="agregarComentario" style="top: 17%;float: left;">
                            <form name="formAgregarComentario">
                                <% if (request.getParameter("reply") != null) {%>
                                <p style="position: absolute;
                                   top: 24%;
                                   left: 8%;">Reply to Coment:</p>

                                <% }%>
                                <textarea style="position: absolute;
                                          left: 0%;
                                          width: 56%;
                                          height: 15%;
                                          top: 29%;" name="agregarComentario"></textarea>
                                <a type="submit" href="#" onclick="document.formAgregarComentario.submit();"  class="btn btn-large btn-block btn-primary" style="position: absolute;
                                   width: 8%;
                                   margin-top: 7%;
                                   line-height: 20%;
                                   top: 32%;
                                   left: 66%;
                                   resize: none;">+</a>
                            </form>
                            <hr>
                        </div>

                        <div class="comentarios" style="position: relative; top: 36%; float: left; width: 100%">

                            <%

                                CargarComentarioControlador.cargarComentario(Util.usuario);

                                for (int posicion = 0; posicion <= Util.listaComentario.size() - 1; posicion++) {

                                    if (Util.listaComentario.get(posicion).getComentario_show().compareTo("t") == 0) {
                                        String nombre = FriendsControlador.TraerNombreAmigo(Util.listaComentario.get(posicion).getFk_usuario_id());
                                        String foto = FriendsControlador.TraerFotoAmigo(Util.listaComentario.get(posicion).getFk_usuario_id());
                                        String texto = Util.listaComentario.get(posicion).getComentario_texto();
                                        int like = Util.listaComentario.get(posicion).getComentario_likes();
                                        int dislike = Util.listaComentario.get(posicion).getComentario_dislikes();
                                        CargarComentarioControlador.cargarReply(posicion);

                            %>






                            <div class="comentario" style="position: relative;float:inherit;width: 100%;">
                                <img src="<%=foto%>" width="25px" style="left: 0%;float: left;position: relative;">
                                <p style="word-wrap: break-word;"><h style="font-size: 17px;"><%=nombre%></h>:<%=texto%> </p>



                                <div class="ratingComentario" style="position: relative;">
                                    <form method="post" name="formComentario<%=posicion%>" id="formComentario<%=posicion%>" style="margin:0">
                                        <input type="text" value="<%=posicion%>" name="comentario" style="width: 0;height: 0;visibility: hidden;float: left;">
                                        <input type="text" name="like" value="0" id="like" style="width: 0;height: 0;visibility: hidden;float: left;">
                                    </form>
                                    <a href="#" onclick="document.formComentario<%=posicion%>.submit();" style=" z-index: 9"><img  src="img/like.png" width="25px" style="float: left; z-index: 9"></a><p style="float: left"><%=like%></p>

                                    <form method="post" name="formComentario2<%=posicion%>" id="formComentario<%=posicion%>" style="margin:0">
                                        <input type="text" value="<%=posicion%>" name="comentario" style="width: 0;height: 0;visibility: hidden;float: left;">
                                        <input type="text" name="like" value="1" style="width: 0;height: 0;visibility: hidden;float: left;">
                                    </form>
                                    <a href="#" onclick="document.formComentario2<%=posicion%>.submit();" style=" z-index: 9" > <img src="img/dislike.png" width="25px" style="float: left; z-index: 9"></a><p style="float: left"><%=dislike%></p>


                                </div>



                                <div class="botonesComentario" style="position: relative;margin-left: 41%;width: 139%;">
                                    <form method="post" name="formComentario3<%=posicion%>" id="formComentario<%=posicion%>" style="float: left;" >
                                        <a href="#" onclick="document.formComentario3<%=posicion%>.submit();">Reply</a> <input type="text" value="2" name="queHacer" style="width: 0;height: 0;visibility: hidden;float: left;">
                                        <input type="text" name="reply" value="1" id="reply" style="width: 0;height: 0;visibility: hidden;float: left;">
                                        <input type="text" value="<%=posicion%>" name="comentario" style="width: 0;height: 0;visibility: hidden;float: left;">
                                    </form>

                                    <form method="post" name="formComentario4<%=posicion%>" id="formComentario4<%=posicion%>" style="margin-left: 18%;" >
                                        <a href="#" onclick="document.formComentario4<%=posicion%>.submit();">Delete</a> <input type="text" value="2" name="queHacer" style="width: 0;height: 0;visibility: hidden;float: left;">
                                        <input type="text" name="delete" value="1" id="reply" style="width: 0;height: 0;visibility: hidden;float: left;">
                                        <input type="text" value="<%=posicion%>" name="comentario" style="width: 0;height: 0;visibility: hidden;float: left;">
                                    </form>

                                </div>






                                <hr >
                            </div>



                            <%  for (int posReply = 0; posReply <= Util.listaReply.size() - 1; posReply++) {

                                    String nombrereply = FriendsControlador.TraerNombreAmigo(Util.listaReply.get(posReply).getFk_usuario_id());
                                    String fotoreply = FriendsControlador.TraerFotoAmigo(Util.listaReply.get(posReply).getFk_usuario_id());
                                    String textoreply = Util.listaReply.get(posReply).getComentario_texto();

                            %>






                            <div class="reply" style="position: relative;float: inherit;width: 80%;left: 23%;">
                                <img src="<%=fotoreply%>" width="25px" style="left: 0%;float: left;position: relative;">
                                <p style="word-wrap: break-word;"><h style="font-size: 17px;"><%=nombrereply%></h>:<%=textoreply%> </p>





                                <hr >
                            </div>



                            <%
                                        }
                                    }
                                }
                            %>





                        </div>
                    </div>

                    </body>	
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

                        if (request.getParameter("reply") != null) {

                            Util.reply = true;
                            Util.posComentario = Integer.parseInt(request.getParameter("comentario"));
                        }
                    %>

                    <%

                        if ((request.getParameter("agregarComentario") != null) && (Util.reply == false)) {

                            String comentario = request.getParameter("agregarComentario");

                            ComentarioControlador.AgregarComentario(comentario,
                                    Util.usuario.getUsuario_albums().get(Util.posAlbum).getAlbum_id(), Util.usuario.getUsuario_id(), Util.usuario);


                    %>


                    <script>
                        window.location = "albumContent.jsp";

                    </script>

                    <%
                        }

                        if ((request.getParameter("agregarComentario") != null) && (Util.reply == true)) {

                            AlbumAmigoContentControlador.agregarReply(Util.posComentario, request.getParameter("agregarComentario"), Util.usuario);
                            Util.reply = false;

                    %>


                    <script>
                        window.location = "albumContent.jsp";

                    </script>

                    <%
                        }

                        if ((request.getParameter("like") != null) && (request.getParameter("comentario") != null)) {

                            int like = Integer.parseInt(request.getParameter("like"));
                            int posComentario = Integer.parseInt(request.getParameter("comentario"));

                            AlbumAmigoContentControlador.modificarComentario(posComentario, like, Util.usuario);
                    %>

                    <script>
                        window.location = "albumContent.jsp";

                    </script>

                    <%

                        }


                        if (request.getParameter("deleteAlbum") != null) {

                            AlbumContentControlador.eliminarAlbum();


                    %>

                    <script>
                        window.location = "album.jsp";

                    </script>

                    <%

                        }




                        if ((request.getParameter("delete") != null) && (request.getParameter("comentario") != null)) {

                            int posComentario = Integer.parseInt(request.getParameter("comentario"));

                            AlbumContentControlador.eliminarComentario(posComentario);


                    %>

                    <script>
                        window.location = "albumContent.jsp";

                    </script>

                    <%

                        }

                        if (request.getParameter("posContent") != null) {
                            int posContent = Integer.parseInt(request.getParameter("posContent"));
                            AlbumContentControlador.borrarContenido(posContent);

                    %>

                    <script>
                        window.location = "albumContent.jsp";

                    </script>

                    <%

                        }



                    %>

                    </html>