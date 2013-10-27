<%@page import="util.Util"%>
<!DOCTYPE html>

<html>
    
  <body>
	<head>
		<title>Configuracion del Perfil</title>
		
		
		<link href="css/bootstrap.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="css/estiloFayah.css" rel="stylesheet" media="screen">
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
			function showhide(capa,sign) 
			{ 
			obj=document.getElementById(capa); 
			obj.style.display=obj.style.display=='none'?'block':'none'; 
			sig=document.getElementById(sign); 
			sig.innerHTML=sig.innerHTML=='+'?'-':'+'; 
			} 
	    </script> 
	
          
	
	
	
	
	
	</head>
        
      
	
	
	
			 
	
	
		 <div class="contenedor"> 
                      <div class="lupa">
            <a href="amigos.jsp">
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
            <a href="friends.jsp">
            <img src="img/friends.png" alt="home icon" width="31px" /></a>
        </div>		
        <h1 class="demo-panel-title">Fayah

        </h1>
        <div class="todo-search">

            <input class="todo-search-field" type="search" value="" placeholder="Search for people">

        </div> 


    </div>
		
		
		<div class="columnleft">
        <div class="usuariodefault">
             <link href='http://fonts.googleapis.com/css?family=Share+Tech' rel='stylesheet' type='text/css'>
            <h4><%=Util.usuario.getUsuario_nombre()%> <%=Util.usuario.getUsuario_apellido()%> </h4>
            <img src="<%=Util.usuario.getUsuario_foto()%>" width="175px" />
        </div>
                </div>

             
	    
	    <div class="columnright">
	    	<div class="titulo">
	    		<h2 class="demo-panel-title">General Account Settings</h1></b>
                        
  	
  		
	    	</div>
	    
	    
	  		  	<div class="separador">
					<HR width=80% align="left">
				</div>


		<div class="nombre">
		  <ul>
			<li class="name" type="none"> 
				
			
                            <form name="formularioUsuario" id="formularioUsuario" method="post"  >  
			    <span>Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a></a>
			    
[<a href="javascript:void(0)" style=" text-decoration:none" id="signo1" onClick="showhide('colors1','signo1')">+</a>] Edit 
<span id="colors1" style="display:none"><br><div class="control-group">
            
                   <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;First:&nbsp;
                   <input type="text" name ="newNombre" class="login-field" value placeholder=" <%=Util.usuario.getUsuario_nombre()%>" id="login-name">
            	   </label>
            </div><br> <div class="control-group">
            	   <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Last:&nbsp;
                       <input type="text" name="newApellido" class="login-field" value placeholder="<%=Util.usuario.getUsuario_apellido()%>" id="login-lastname">
                   </label>  
                   <div class="control-group">
                       
                       <a class="login-link" onclick="document.formularioUsuario.submit();" type="submit" href="#">Save Changes</a>
						
				   </div>          
            </div></span> 
				 
			   </span>
			</form>
			</li>
			<HR width=639px align="left">			
			
			
			
			
			
			<li class="Username" type="none">
                               <form name="cambiarUsuario" id="formularioNombre" method="post"  >  
			<span class="h3">Username&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a></a>
			    [<a href="javascript:void(0)" style=" text-decoration:none" id="signo2" onClick="showhide('colors2','signo2')">+</a>] Edit 
<span id="colors2" style="display:none"><br><div class="control-group">
            
                   <label>&nbsp;&nbsp;&nbsp;Username:&nbsp;
                       <input type="text" name="newUsername" class="login-field" value placeholder="<%=Util.usuario.getUsuario_username()%>" id="login-name">
            	   </label>
            	   <div class="control-group">
                       <a class="login-link" onclick="document.cambiarUsuario.submit();" type="submit" href="#">Save Changes</a>
				   </div> 
            </div></span> 
				 
			   </span>
                               </form>
			</li>
			<HR width=639px align="left">
			
			<li class="Email" type="none">
                               <form name="cambiarNombre"  method="post"  >  
			<span>Hometown&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a></a>
			    [<a href="javascript:void(0)" style=" text-decoration:none" id="signo3" onClick="showhide('colors3','signo3')">+</a>] Edit 
<span id="colors3" style="display:none"><br><div class="control-group">
            
                   <label>&nbsp;&nbsp;&nbsp;Hometown:&nbsp;
                       <input type="text" name="newDireccion" class="login-field" value placeholder="<%=Util.usuario.getUsuario_ubicacion()%>" id="login-name">
            	   </label>
            	   <div class="control-group">
                       <a class="login-link" onclick="document.cambiarNombre.submit();" type="submit" href="#">Save Changes</a>
				   </div> 
            </div></span> 
				 
			   </span>
                               </form>
			</li>
			<HR width=639px align="left">
			
			<li class="BirthDay"type="none">
                               <form name="cambiarCumple" id="formularioNombre" method="post"  >  
			<span>Birthday&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a></a>
			    [<a href="javascript:void(0)" style=" text-decoration:none" id="signo4" onClick="showhide('colors4','signo4')">+</a>] Edit 
<span id="colors4" style="display:none"><br><div class="control-group">
            
                   <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Birthday:&nbsp;
                       <input type="text" name="newCumple" class="login-field" value placeholder="<%=Util.usuario.getUsuario_fecha_nacimiento()%>" id="login-name">
            	   </label>
            </div><br><div class="control-group">
        
                  
            </div><br><div class="control-group">
            
            	   <div class="control-group">
                       <a class="login-link" onclick="document.cambiarCumple.submit();" type="submit" href="#">Save Changes</a>
				   </div> 
            </div></span> 
				 
			   </span>
                               </form>
                   
			</li>
			<HR width=639px align="left">
		  </ul>
		</div>

  		
	    </div>
	   
	   
	  
	  
	  
	  
	  
	   <div class="columnright2">
	   	 
	   </div>
	
	

	  
	   
	 
	  
	  
	  
	
    

                    
  </body>
  <%
// newNombre
// newApellido
// newCumple
// newDireccion



%>  
  
</html>

