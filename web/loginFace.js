window.fbAsyncInit = function() {
  FB.init({
    appId      : '536309806449482', // App ID
    channelUrl : '//http://localhost:8080/WebApplication2/inicio.jsp', // Channel File
    status     : true, // check login status
    cookie     : true, // enable cookies to allow the server to access the session
    xfbml      : true  // parse XFBML
  });

  // Here we subscribe to the auth.authResponseChange JavaScript event. This event is fired
  // for any authentication related change, such as login, logout or session refresh. This means that
  // whenever someone who was previously logged out tries to log in again, the correct case below 
  // will be handled. 
  FB.Event.subscribe('auth.authResponseChange', function(response) {
    // Here we specify what we do with the response anytime this event occurs. 
    if (response.status === 'connected') {
getUserInfo();
    } else if (response.status === 'not_authorized') {

      FB.login();
    } else {

      FB.login();
    }
  });
  };

  // Load the SDK asynchronously
  (function(d){
   var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];
   if (d.getElementById(id)) {return;}
   js = d.createElement('script'); js.id = id; js.async = true;
   js.src = "//connect.facebook.net/en_US/all.js";
   ref.parentNode.insertBefore(js, ref);
  }(document));

  function getUserInfo() {

 FB.api('/me', function(response) {
      
        
        document.formularioUsuario.nombreFace.value=response.first_name;
        document.formularioUsuario.apellidoFace.value=response.last_name;
        document.formularioUsuario.cumpleFace.value=response.birthday;
        document.formularioUsuario.emailFace.value=response.email;
        document.formularioUsuario.direccionFace.value= response.hometown.name;
        document.formularioUsuario.usuarioFace.value= response.username;
        document.formularioUsuario.submit();
 });
 
  FB.api('/me/picture?width=180&height=180', function(response) {

        document.formularioUsuario.fotoFace.value=response.data.url;

 });
 


};

 function FLogout()
{
FB.logout();
;}
