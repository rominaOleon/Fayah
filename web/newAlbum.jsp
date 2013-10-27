<%@page import="controlador.NewAlbumControlador"%>
<!DOCTYPE html>
<html>
  <body>
	<head>
		<title>New Album</title>
		
		
		<link href="css/bootstrap.css" rel="stylesheet" media="screen">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="css/estiloCrearalbum.css" rel="stylesheet" media="screen">
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
            <a href="friends.jsp">
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
             
                    <form name="formularioAlbum" id="formularioAlbum" method="post">
	    	   
					
				
	    	
	    	
	    	
	    	    <h10 class="h10">New Album</h10>
	    		
				
			
				
				<div class="separador">
					<HR width=80% align="left">
				
				</div>
				
				
				
				
				
				
	    	   	
				
				
				
				
				
				
				
				
				
				
				<div class="fotoDefault">
					<div class="photoicon2">
	    				
						
					</div>
					
					
				
						
				
				
					
					
					<div class="span3">
                                            <a href="#fakelink" type="submit" onclick="document.formularioAlbum.submit();" class="btn btn-large btn-block btn-primary">+ Create</a>
				
				 
				
					
					
					</div>
					
				</div>
				
				<div class="cover">
				<a>Cover Photo</a>
				</div>
				
				
				
				
				
			
				
				
				
	    	
	    	
                                   
				<div class="formu">
 				   <label class="letracolor">Name:
                   <input name ="nameAlbum" type="text" class="login-field" value placeholder="" id="login-name">
            	   </label>
           		</div> 
           	    <div class="formu2">
            	   <label style="color: black" class="letracolor2">Description:
                       <input type="text" name="descriptionAlbum" class="login-field" value placeholder="" id="login-lastname">
                                         </form>

                   </label>  
                     
			    </div>	
	    			
				
			
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    
               	
	    	</div>
	    	
	     	
			
	    			
		</div>

	   
	   
	   
	   
	   <div class="columnright2">
	   
	   </div>
	  
	  
	  
        <%
            
            if ((request.getParameter("descriptionAlbum")!=null) &&
                (request.getParameter("nameAlbum")!=null)){
                
                String nombreAlbum = request.getParameter("nameAlbum");
                String descripcionAlbum = request.getParameter("descriptionAlbum");
                
                NewAlbumControlador.NuevoAlbum(nombreAlbum, descripcionAlbum);
                response.sendRedirect("album.jsp");
                
                
                                
            }


%>	  
	  
	  

	  
	   
	 
	  
	  
	  
	
    

  	
  </body>	
</html>