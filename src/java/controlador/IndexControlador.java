
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
            String email, String fecha_nacimiento, String ubicacion) {
        Usuario usuario=null;
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        int x = usuariodao.UsuarioExiste(email);
        if ((username != null) || (email.compareTo("undefined")!=0)) {
            if (usuariodao.UsuarioExiste(email) == 0) {
                usuario = new Usuario(username, nombre, apellido,
                        email, fecha_nacimiento, ubicacion, "P");
                usuariodao.InsertarUsuario(usuario);
            } else {
                usuariodao.ConsultarUsuario(email);
            }
   
        }
        return usuario;
    }
}
