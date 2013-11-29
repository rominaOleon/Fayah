/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.AlbumList;
import negocio.AmigoList;
import negocio.Usuario;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;
import util.Util;

/**
 *
 * @author romina
 */
public class SettingsControlador { 
    
    public static int ModificarPerfil(String newusername, String newnombre, 
            String newapellido,String newfecha_nacimiento, String newubicacion, 
            String newprivacidad) {
        
        int cambio=0;
  
        String username = Util.usuario.getUsuario_username();
        String nombre = Util.usuario.getUsuario_nombre();
        String apellido = Util.usuario.getUsuario_apellido();
        String fecha_nacimiento = Util.usuario.getUsuario_fecha_nacimiento();
        String ubicacion = Util.usuario.getUsuario_ubicacion();
        String privacidad = Util.usuario.getUsuario_privacidad();

        if (newusername != null) {
            username = newusername;
            cambio=1;
        }

        if (newnombre != null) {
            nombre = newnombre;
            cambio=1;
        }

        if (newapellido != null) {
            apellido = newapellido;
            cambio=1;
        }

        if (newfecha_nacimiento != null) {
            fecha_nacimiento = newfecha_nacimiento;
            cambio=1;
        }

        if (newubicacion != null) {
            ubicacion = newubicacion;
            cambio=1;
        }

        if (newprivacidad != null) {
            privacidad = newprivacidad;
            cambio=1;
        }

        Usuario usuario = new Usuario(Util.usuario.getUsuario_id(), username,
                nombre, apellido, Util.usuario.getUsuario_email(),
                fecha_nacimiento, ubicacion, privacidad,
                Util.usuario.getUsuario_albums(),
                Util.usuario.getUsuario_amigos(),
                Util.usuario.getUsuario_foto());

        UsuarioDAO usuariodao = new UsuarioDAOSQL();

        usuariodao.modificarUsuario(usuario);
        usuario = usuariodao.consultarUsuario(Util.usuario.getUsuario_email());
        Util.usuario = usuario;
        AlbumList albums = usuariodao.traerAlbums(usuario);
        AmigoList amigos = usuariodao.traerAmigos(usuario);
        if (albums != null) {
            usuario.setUsuario_albums(albums);
        }
        if (amigos != null) {
            usuario.setUsuario_amigos(amigos);
        }
        Util.usuario = usuario;

        return cambio;

    }
}
