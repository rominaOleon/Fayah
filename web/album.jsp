<%@page import="util.Util"%>
<!DOCTYPE html>

<html>
    <body>
    <head>
        <title>Album</title>


        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
        <link href="css/estiloalbum.css" rel="stylesheet" media="screen">
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

      

 </div>  
              </form>
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
                
          
              <ul class="cat">
                              
                    <%
            int posicion=0;
            int maximopagina = 4;
            int maximoalbums = Util.usuario.getUsuario_albums().size();
            while ((posicion<=maximopagina) && 
                  (posicion<=maximoalbums-1)){
                System.out.println(Util.usuario.getUsuario_albums().get(posicion).getAlbum_miniatura());
            %>               
                    <li>
                        <a href="#">
                            <img class="min" src="<%=Util.usuario.getUsuario_albums().get(posicion).getAlbum_miniatura()%>" alt="#" />
                            <img class="max" src="<%=Util.usuario.getUsuario_albums().get(posicion).getAlbum_miniatura()%>" alt="#" />
                            <label> <%=Util.usuario.getUsuario_albums().get(posicion).getAlbum_nombre()%> </label>
                        </a>
                    </li>
      
            <% posicion=posicion+1;
            }
            %>
              </ul>
            
            <ul class="cat">
                
            <%
            if(maximoalbums>4){
            
            while ((posicion<=maximopagina) && 
                  (posicion<=maximoalbums)){
            %>      
                        
                
                <li>
                        <a href="#">
                            <img class="min" src="/Users/carlosromero/Documents/galeria/img/chicas/8.jpg" alt="#" />
                            <img class="max" src="/Users/carlosromero/Documents/galeria/img/grandes/8.jpg" alt="#" />
                        </a>
                    </li>
                    
            <% posicion=posicion+1;
            }
            }
            %>      
                    
                </ul>

            </div>
 </div>

    </div>





    <div class="columnright2">

    </div>

















</body>	
</html>