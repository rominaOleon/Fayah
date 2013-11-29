<%@page import="controlador.InicioControlador"%>
<%@page import="controlador.ResultFriendControlador"%>
<%@page import="util.Util"%>
<!DOCTYPE html>
<html>
    <body>
    <head>
        <title>Search Results:</title>

<SCRIPT Language=Javascript SRC="loginFace.js"></SCRIPT>
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
          <img src="img/logout.png" alt="home icon" width="29px" onclick="FLogout();"  /></a>
        </div>	
        <div class="message">
            <img src="img/message.png" alt="home icon" width="37px" />
        </div>	
       		
        <h1 class="demo-panel-title">Fayah
        </h1>
        <div class="todo-search">
            <input class="todo-search-field" type="text" name="newBusqueda" placeholder="Search for people" id="laBusqueda"
      
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

            <h10 class="h10">Search Results:</h10>




            <div class="separador">
                <HR width=80% align="left">

            </div>


            <div class="fotoDefault">
                
                
                <%
            int posicion=0;
           
            int maximousuarios = Util.usuarios.size()-1;
            
            while (posicion<=maximousuarios) {
                
                String nombreUsuario = Util.usuarios.get(posicion).getUsuario_nombre();
                String apellidoUsuario = Util.usuarios.get(posicion).getUsuario_apellido();
                String ubicacionUsuario = Util.usuarios.get(posicion).getUsuario_ubicacion();
                String fotoUsuario = Util.usuarios.get(posicion).getUsuario_foto();
                
                String nombreCompleto = nombreUsuario + " " + apellidoUsuario;
            %>     
                
                
                <div class="photoicon2">
                    <img src=<%=fotoUsuario%> width="100px" />
                    </br> 
                    </br>
                    </br>
                    </br>
                    </br>
                    </br>
                    </br>

                </div>
                    <form name="formAmigo<%=posicion%>"  id="formAmigo<%=posicion%>" method="post">
                    
                    <div class="span3">
                        <input name="posAmigo" style="visibility: hidden" value="<%=posicion%>">
                        <input name="posPerfil" style="visibility: hidden" value="<%=posicion%>">
                        <% 
                             boolean esAmigo = ResultFriendControlador.esAmigo(Util.usuario.getUsuario_id(),Util.usuarios.get(posicion).getUsuario_id());
                             
                             if ((esAmigo!=true) && (Util.usuarios.get(posicion).getUsuario_id()!=Util.usuario.getUsuario_id())){
                           
                               %>
                        <a type="submit" onclick="document.formAmigo<%=posicion%>.submit();" class="btn btn-large btn-block btn-primary">+ Add Friend</a>
                        
                        <%}
                                 %>
                                 
                            <% 
                            if ((Util.usuarios.get(posicion).getUsuario_privacidad().compareTo("A")==0) && (Util.usuarios.get(posicion).getUsuario_id()!=Util.usuario.getUsuario_id())) {
                             %>     
                         <a type="submit" onclick="document.formAmigo<%=posicion%>.submit();" class="btn btn-large btn-block btn-primary">View Profile</a>
                          <%}
                            %>
                </div>
                  
                <div class="nombreUsu">
                    <a><%=nombreCompleto%></a>                    </br>
                    <a><%=ubicacionUsuario%></a>
                    </br>
                    </br>
                    </br>
                    </br>
                                      </br>
                    </br>


                </div>
                
                </form>  

                    
                         <% posicion=posicion+1;
            }
            %>
                
                
            <% System.out.println("Posicion:" +request.getParameter("posAmigo")); %>
            </div>

            <div class="separador2">
                <HR width=80% align="left">

            </div>
        </div>

    </div>

    <div class="columnright2">

    </div>
            
            <%
         
               
             if (request.getParameter("newBusqueda") != null) {
                     String busqueda = request.getParameter("newBusqueda");

                     Util.usuarios = InicioControlador.BuscarUsuario(busqueda);

                     response.sendRedirect("resultFriends.jsp");
                 }
            

             
                    
            if (request.getParameter("posAmigo")!=null){
                String pos = request.getParameter("posAmigo");
                int posicionAmigo = Integer.parseInt(pos);
                int idamigo = Util.usuarios.get(posicionAmigo).getUsuario_id();
                
                ResultFriendControlador.AgregarAmigo(idamigo);
                
                response.sendRedirect("inicio.jsp");
                
            }
            
            if (request.getParameter("posPerfil")!=null){
                String posicionPerfil = request.getParameter("posPerfil");
                int posPerfil = Integer.parseInt(posicionPerfil);
                int idAmigo = Util.usuarios.get(posPerfil).getUsuario_id();
                ResultFriendControlador.TraerAmigo(idAmigo);
                                
            }
 
%>

</body>	


</html>

