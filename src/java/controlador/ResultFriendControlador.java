/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.AlbumList;
import negocio.Amigo;
import negocio.AmigoList;
import negocio.NotificacionList;
import negocio.Usuario;
import persistencia.AmigoDAO;
import persistencia.AmigoDAOSQL;
import persistencia.NotificacionDAO;
import persistencia.NotificacionDAOSQL;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;
import util.Util;

/**
 *
 * @author romina
 */
public class ResultFriendControlador {
    
    public static void AgregarAmigo (int id){
        
        Amigo amigo = new Amigo(Util.usuario.getUsuario_id(),id);
        
        AmigoDAO amigodao = new AmigoDAOSQL();
        NotificacionDAO notificaciondao = new NotificacionDAOSQL();
        
        amigodao.insertarAmigo(amigo);
        
        
        AmigoList amigos = new AmigoList();
        NotificacionList notificaciones = new NotificacionList();
        
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        
        notificaciones = notificaciondao.traerNotificaciones(Util.usuario);
        amigos =  usuariodao.traerAmigos(Util.usuario);
        
        Util.usuario.setUsuario_amigos(amigos);
        Util.notificaciones = notificaciones;
        
    }
    
    public static boolean esAmigo (int usuarioId, int amigoId){
        boolean esAmigo=false;
        AmigoDAO amigodao = new AmigoDAOSQL();
        esAmigo = amigodao.sonAmigos(usuarioId, amigoId);
        
        return esAmigo;
        
    }
    
    public static void TraerAmigo(int id){        
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        Util.amigoPerfil = new Usuario();
        AlbumList albums = new AlbumList();
        AmigoList amigos = new AmigoList();
        Usuario amigoPerfil = usuariodao.consultarUsuario(id);
        albums = usuariodao.traerAlbums(amigoPerfil);
        amigos = usuariodao.traerAmigos(amigoPerfil);
        amigoPerfil.setUsuario_albums(albums);
        amigoPerfil.setUsuario_amigos(amigos);
        
        Util.amigoPerfil = amigoPerfil;     
        
    }
    
}
