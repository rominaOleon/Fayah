
package controlador;

import negocio.Usuario;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;

/**
 *
 * @author romina
 */
public class IndexControlador {
    
/*    
*    Metodo invocado cuando el usuario realiza el LogIn (username!=null).
*    Si el usuario no esta registrado se procede a registrarlo.
*    Si el usuario esta registrado, se procede a cargar sus datos.
**/
    public static Usuario LogIn(String username, String nombre, String apellido,
            String email, String fecha_nacimiento, String ubicacion,String foto) {
        
        Usuario usuario=null;
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        
        if ((email != null) || (email.compareTo("undefined") != 0)) {
            
                if (email.compareTo("")!=0){
                    System.out.println("usuario email!= vacio ");
  
                    
                    if (usuariodao.UsuarioExiste(email)== 0){
                    usuario = new Usuario(username, nombre, apellido,
                            email, fecha_nacimiento, ubicacion, "P", foto);
                    usuariodao.InsertarUsuario(usuario);
                    }
                }
                usuario = usuariodao.ConsultarUsuario(email);
     
        }
        
        return usuario;
    }
}
