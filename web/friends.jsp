<%@page import="controlador.FriendsControlador"%>
<%@page import="util.Util"%>
<!DOCTYPE html>
<html>
    <body>
    <head>
        <title>Friends</title>


        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="css/estilografo.css" rel="stylesheet" media="screen">
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
        <form name="formularioBusqueda" id="formularioBusqueda" method="post">
            <div class="lupa">
                <a type="submit" onclick="document.formularioBusqueda.submit();">
                    <img src="img/lupaicon.png" alt="home icon" width="25px" /></a>
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
                    <img src="img/lock.png" alt="home icon" width="35px"  /></a>
            </div>	
            <div class="message">
                <img src="img/message.png" alt="home icon" width="37px" />
            </div>	
            <div class="friends">
                <a href="friends.jsp" onclick="">
                    <img src="img/friends.png" alt="home icon" width="31px" /></a>
            </div>		
            <h1 class="demo-panel-title">Fayah

            </h1>
            <div class="todo-search">

                <input class="todo-search-field" type="text" name="newBusqueda" placeholder="Search for people" id="laBusqueda"


                       </form>
            </div>  
    </div>

    <div class="columnright">
        <div class="cuadro">

            <h10 class="h10">Friend List</h10>




            <div class="separador">
                <HR width=80% align="left">

            </div>
            
            <div class="fotoDefault">
            
             <%
            int posicion=0;
           
            int maximoamigos = Util.usuario.getUsuario_amigos().size()-1;
            
            while (posicion<=maximoamigos) {
                
                int id;                
                int idUsuario1;
                int idUsuario2;
                
                idUsuario1 = Util.usuario.getUsuario_amigos().get(posicion).getAmigo_fkusuario1();
                idUsuario2 = Util.usuario.getUsuario_amigos().get(posicion).getAmigo_fkusuario2();
                
                if (idUsuario1==Util.usuario.getUsuario_id())
                    id = idUsuario2;
                else
                    id = idUsuario1;
                String nombreAmigo = FriendsControlador.TraerNombreAmigo(id);
                String fotoAmigo = FriendsControlador.TraerFotoAmigo(id);
                String ubicacion= FriendsControlador.TraerUbicacionAmigo(id);
              
            %>     


            
                <div class="photoicon2">
                    <img src=<%=fotoAmigo%> width="100px" />
                    </br>                    </br>
                    </br>
                    </br>
                    </br>
                    </br>

                </div>

                <div class="nombreUsu">
                    <a><%=nombreAmigo%></a>                    </br>
                    <a><%=ubicacion%></a>
                    </br>
                    </br>
                    </br>
                    </br>
                    </br>

                </div>
              
         
                
                <% posicion=posicion+1;
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
</body>	
</html>