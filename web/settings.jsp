<%@page import="controlador.InicioControlador"%>
<%@page import="controlador.SettingsControlador"%>
<%@page import="util.Util"%>
<!DOCTYPE html>

<html>

    <body>
    <head>
        <title>Configuracion del Perfil</title>

        <SCRIPT Language=Javascript SRC="js/loginFace.js"></SCRIPT>
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="css/estiloFayah.css" rel="stylesheet" media="screen">
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
                    <img src="img/logout.png" alt="home icon" width="29px" onclick="FLogout();" /></a>
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

                    <a  href="album.jsp" class="h10">Album</a>
                    <a href="friends.jsp" class="h11">Friends</a>

                    </div>




                    <div class="columnright">
                        <div class="titulo">
                            <h2 class="demo-panel-title">General Account Settings</h1></b>



                        </div>


                        <div class="separador">
                            <HR width=80% align="left">
                        </div>


                        <div class="nombre">
                            <form name="formularioUsuario" id="formularioUsuario" method="post"  > 
                                <ul>
                                    <li class="name" type="none"> 



                                        <span>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a></a>

                                            [<a href="javascript:void(0)" style=" text-decoration:none" id="signo1" onClick="showhide('colors1', 'signo1')">+</a>] Edit 
                                            <span id="colors1" style="display:none"><br><div class="control-group">

                                                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;First:&nbsp;
                                                        <input type="text" name ="newNombre" class="login-field" value=" <%=Util.usuario.getUsuario_nombre()%>" id="login-name">
                                                    </label>
                                                </div><br> <div class="control-group">
                                                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Last:&nbsp;
                                                        <input type="text" name="newApellido" class="login-field" value="<%=Util.usuario.getUsuario_apellido()%>" id="login-lastname">
                                                    </label>  
                                                    <div class="control-group">

                                                        <a class="login-link" onclick="document.formularioUsuario.submit();" type="submit" href="#">Save Changes</a>

                                                    </div>          
                                                </div></span> 

                                        </span>

                                    </li>
                                    <HR width=639px align="left">			





                                    <li class="Username" type="none">

                                        <span class="h3">Username&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a></a>
                                            [<a href="javascript:void(0)" style=" text-decoration:none" id="signo2" onClick="showhide('colors2', 'signo2')">+</a>] Edit 
                                            <span id="colors2" style="display:none"><br><div class="control-group">

                                                    <label>&nbsp;&nbsp;&nbsp;Username:&nbsp;
                                                        <input type="text" name="newUsername" class="login-field" value="<%=Util.usuario.getUsuario_username()%>" id="login-name">
                                                    </label>
                                                    <div class="control-group">
                                                        <a class="login-link" onclick="document.formularioUsuario.submit();" type="submit" href="#">Save Changes</a>
                                                    </div> 
                                                </div></span> 

                                        </span>

                                    </li>
                                    <HR width=639px align="left">

                                    <li class="Email" type="none">

                                        <span>Hometown&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a></a>
                                            [<a href="javascript:void(0)" style=" text-decoration:none" id="signo3" onClick="showhide('colors3', 'signo3')">+</a>] Edit 
                                            <span id="colors3" style="display:none"><br><div class="control-group">

                                                    <label>&nbsp;&nbsp;&nbsp;Hometown:&nbsp;
                                                        <input type="text" name="newDireccion" class="login-field" value="<%=Util.usuario.getUsuario_ubicacion()%>" id="login-name">
                                                    </label>
                                                    <div class="control-group">
                                                        <a class="login-link" onclick="document.formularioUsuario.submit();" type="submit" href="#">Save Changes</a>
                                                    </div> 
                                                </div></span> 

                                        </span>

                                    </li>
                                    <HR width=639px align="left">

                                    <li class="BirthDay"type="none">

                                        <span>Birthday&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a></a>
                                            [<a href="javascript:void(0)" style=" text-decoration:none" id="signo4" onClick="showhide('colors4', 'signo4')">+</a>] Edit 
                                            <span id="colors4" style="display:none"><br><div class="control-group">

                                                    <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Birthday&nbsp;
                                                        <input type="text" name="newCumple" class="login-field" value="<%=Util.usuario.getUsuario_fecha_nacimiento()%>" id="login-name">

                                                    </label>
                                                </div><br><div class="control-group">


                                                </div><br><div class="control-group">

                                                    <div class="control-group">
                                                        <a class="login-link" onclick="document.formularioUsuario.submit();" type="submit" href="#">Save Changes</a>
                                                    </div> 
                                                </div></span> 

                                        </span>


                                    </li>
                                    <HR width=639px align="left">

                                    <li class="Private"type="none">

                                        <span>Privacy&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a></a>
                                            [<a href="javascript:void(0)" style=" text-decoration:none" id="signo5" onClick="showhide('colors5', 'signo5')">+</a>] Edit 
                                            <span id="colors5" style="display:none"><br><div class="control-group">


                                                    <label class="radio checked">
                                                        <span class="icons">
                                                            <span class="first-icon fui-radio-unchecked"></span>
                                                            <span class="second-icon fui-radio-checked"></span>
                                                        </span>
                                                        <input type="radio" name="newPrivate" id="optionsRadios1" value="A" data-toggle="radio" checked="checked">

                                                        Public

                                                    </label>				
                                                    <label class="radio checked">
                                                        <span class="icons">
                                                            <span class="first-icon fui-radio-unchecked"></span>
                                                            <span class="second-icon fui-radio-checked"></span>
                                                        </span>
                                                        <input type="radio" name="newPrivate" id="optionsRadios2" value="P" data-toggle="radio">

                                                        Private

                                                    </label>
                                                    </label>
                                                </div><br><div class="control-group">


                                                </div><br><div class="control-group">

                                                    <div class="control-group">
                                                        <a class="login-link" onclick="document.formularioUsuario.submit();" type="submit" href="#">Save Changes</a>
                                                    </div> 
                                                </div></span> 

                                        </span>


                                    </li>
                                </ul>
                            </form>
                        </div>


                    </div>







                    <div class="columnright2">

                    </div>













                    </body>
                    <%
                        String username = request.getParameter("newUsername");
                        String nombre = request.getParameter("newNombre");
                        String apellido = request.getParameter("newApellido");
                        String fecha_nacimiento = request.getParameter("newCumple");
                        String ubicacion = request.getParameter("newDireccion");
                        String privacidad = request.getParameter("newPrivate");
                        int refresh = SettingsControlador.ModificarPerfil(username, nombre, apellido,
                                fecha_nacimiento, ubicacion, privacidad);

                        if (refresh == 1) {

                    %>

                    <script>
            window.location = "settings.jsp";

                    </script>

                    <%         }


                    %>  

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
                    </html>

