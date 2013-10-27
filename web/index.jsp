<%@page import="util.Util"%>
<%@page import="controlador.IndexControlador"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap.min.css" rel="stylesheet">
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
    <body background="img/espacio.png">
        <SCRIPT Language=Javascript SRC="loginFace.js"></SCRIPT>


        <div class="contenedor">
            <h1 class="demo-panel-title">
                <img src="img/losfayah.jpg" alt="foto logo facebook" width="70px" />
                Fayah

            </h1>


        </div>

        <div class="contenedor2">
            <div class="facebook">
                <form name="formularioUsuario" id="formularioUsuario" method="post"  >
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




            <h2 class="demo-panel-title">LogIn with:


            </h2>

        </div>




        <div class="separador">
            <HR width=100% align="left">
        </div>


        <h4 class="demo-panel-title">Connect with your friends

            and share the best of Youtube, Instagram and Soundcloud.</h4>

        <div class="youtube">
            <img src="img/youtube2.png" alt="foto logo facebook" width="150px" />
        </div>
        <div class="instagram">
            <img src="img/instagram2.png" alt="foto logo facebook" width="150px" />
        </div>
        <div class="soundcloud">
            <img src="img/soundcloud2.png" alt="foto logo facebook" width="150px" />
        </div> 



        <h5 class="demo-panel-title">Fayah, Inc. Copyright 2013</h5>



        <%
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
                    response.sendRedirect("inicio.jsp");
                }
            }
         
        %>

    </body> 
</html>
