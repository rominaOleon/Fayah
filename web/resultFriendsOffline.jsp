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
        
        <div class="lock">
            <a href="index.jsp">
          <img src="img/Home_icon.png" alt="home icon" width="29px" onclick="FLogout();"  /></a>
        </div>	
        	
       		
        <h1 class="demo-panel-title">Fayah
        </h1>
        <div class="todo-search">
            <input class="todo-search-field" type="text" name="newBusqueda" placeholder="Search for people" id="laBusqueda"
      
 </div> 
              </form>
    </div>
    
        <div class="columnleft">
        </div>
        
         

       
        
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
                            if (Util.usuarios.get(posicion).getUsuario_privacidad().compareTo("A")==0) {
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

                     response.sendRedirect("resultFriendsOffline.jsp");
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

