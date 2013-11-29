
package controlador;

import negocio.AlbumList;
import negocio.AmigoList;
import negocio.NotificacionList;
import negocio.Usuario;
import persistencia.NotificacionDAO;
import persistencia.NotificacionDAOSQL;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;
import util.Util;

/**
 *
 * @author romina
 */
public class IndexControlador {
    

    public static Usuario LogIn(String username, String nombre, String apellido,
            String email, String fecha_nacimiento, String ubicacion,String foto) {      
        Usuario usuario=null;
        UsuarioDAO usuariodao = new UsuarioDAOSQL();    
        NotificacionDAO notificaciondao = new NotificacionDAOSQL();
        if ((email != null) || (email.compareTo("undefined") != 0)) {            
                if (email.compareTo("")!=0){
                   
                    if (usuariodao.usuarioExiste(email)== 0){
                       
                    usuario = new Usuario(username, nombre, apellido,
                            email, fecha_nacimiento, ubicacion, "P", foto);
                    usuariodao.insertarUsuario(usuario);
                    }
                }
                usuario = usuariodao.consultarUsuario(email);
                
                AlbumList albums = usuariodao.traerAlbums(usuario);
                AmigoList amigos = usuariodao.traerAmigos(usuario); 
                NotificacionList notificaciones = notificaciondao.traerNotificaciones(usuario);
                if (albums!=null)
                    usuario.setUsuario_albums(albums);              
                if (amigos!=null)
                    usuario.setUsuario_amigos(amigos);  
                if (notificaciones!=null)
                    Util.notificaciones = notificaciones;
        }       
        return usuario;
    }
}
