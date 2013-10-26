window.fbAsyncInit = function() {

 FB.init({
 appId : '171611049700442', // App ID
 status : true, // check login status
 cookie : true, // enable cookies to allow the server to access the session
 xfbml : true // parse XFBML

 });

FB.Event.subscribe('auth.authResponseChange', function(response) 
{
 if (response.status === 'connected') 
 {
getUserInfo();
if (document.formularioUsuario.nombreFace.value!==''){
 document.getElementById("formularioUsuario").submit();  
}

    

//document.location.href='http://localhost:8080/WebApplication2/inicioFayah.jsp';

 } 

else if (response.status === 'not_authorized') {
FLogin();


  } else{
      
 
 }

});

};

 

 function Flogin(){

FB.login(function(response) {
 getUserInfo();
 
 },{scope: 'email,user_photos,user_hometown,user_birthday'});
 

}


 function getUserInfo() {

 FB.api('/me', function(response) {
      
        
        document.formularioUsuario.nombreFace.value=response.first_name;
        document.formularioUsuario.apellidoFace.value=response.last_name;
        document.formularioUsuario.cumpleFace.value=response.birthday;
        document.formularioUsuario.emailFace.value=response.email;
        document.formularioUsuario.direccionFace.value= response.hometown.name;
        document.formularioUsuario.usuarioFace.value= response.username;
        
 });
 
  FB.api('/me/picture?width=180&height=180', function(response) {

        document.getElementById("img").src= response.data.url;
        document.formularioUsuario.fotoFace.value=response.data.url;

 });
 


}

function FLogout()

{
FB.logout(function(){document.location.reload();
    });

}

 // Load the SDK asynchronously

 (function(d){

 var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
 if (d.getElementById(id)) {return;}
 js = d.createElement('script'); js.id = id; js.async = true;
 js.src = "//connect.facebook.net/en_US/all.js";
 ref.parentNode.insertBefore(js, ref);
 }(document));

