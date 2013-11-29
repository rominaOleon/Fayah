/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Usuario;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;

/**
 *
 * @author romina
 */
public class FriendsControlador {

    public static String TraerFotoAmigo(int id) {

        Usuario usuario = null;
        UsuarioDAO usuariodao = new UsuarioDAOSQL();

        usuario = usuariodao.consultarUsuario(id);

        return usuario.getUsuario_foto();

    }

    public static String TraerNombreAmigo(int id) {

        Usuario usuario = null;
        UsuarioDAO usuariodao = new UsuarioDAOSQL();

        usuario = usuariodao.consultarUsuario(id);

        String nombreAmigo = usuario.getUsuario_nombre() + " " + usuario.getUsuario_apellido();

        return nombreAmigo;

    }
    
      public static String TraerUbicacionAmigo(int id) {

        Usuario usuario = null;
        UsuarioDAO usuariodao = new UsuarioDAOSQL();

        usuario = usuariodao.consultarUsuario(id);

        String ubicacionAmigo = usuario.getUsuario_ubicacion();

        return ubicacionAmigo;

    }
}
