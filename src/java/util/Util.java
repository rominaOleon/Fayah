/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import negocio.Album;
import negocio.NotificacionList;
import negocio.Usuario;
import negocio.UsuariosList;
import persistencia.AlbumDAO;
import persistencia.AlbumDAOSQL;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;

/**
 *
 * @author romina
 */
public abstract class Util {
    public static Usuario usuario = new Usuario();
    public static final String DRIVER_BD = "org.postgresql.Driver";
    public static final String URL_BD = "jdbc:postgresql://ec2-54-235-83-5.compute-1.amazonaws.com:5432/d90thl54rosfe3?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    public static final String USERNAME_BD = "ezfrmsdwmxsdku";
    public static final String PASSWORD_BD = "0LsDzLMI8KFNe-pkM6iQSHuAHI";
    public static UsuariosList usuarios;
    public static String defaultAlbumCover = "img/defaultalbum.jpg";
    public static boolean msgError = false;
    public static Usuario amigoPerfil;
    public static NotificacionList notificaciones = new NotificacionList();
    public static int posAlbum = 0;
    public static String instagramBusqueda = "";
    public static String contenidoLink = "";
    
//    commented on
//            liked
//                    disliked
//                    added a new album.
                            
    
    public static String notificacionAmigoMsg(int amigo1, int amigo2){
        
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        Usuario usuario1 = usuariodao.consultarUsuario(amigo1);
        Usuario usuario2 = usuariodao.consultarUsuario(amigo2);
        String nombre1="";
        String nombre2="";
        
        if (amigo1==Util.usuario.getUsuario_id()){
            nombre1= usuario2.getUsuario_nombre() + " " + usuario2.getUsuario_apellido();
            nombre2="You";
            
        }else if (amigo2==Util.usuario.getUsuario_id()){
            nombre1 = usuario1.getUsuario_nombre() + " " + usuario1.getUsuario_apellido();
            nombre2="You";
        } else{
            nombre1 = usuario1.getUsuario_nombre() + " " + usuario1.getUsuario_apellido();
            nombre2= usuario2.getUsuario_nombre() + " " + usuario2.getUsuario_apellido();
        }
        
        return nombre1 + " and " + nombre2 + "are now frineds.";
        
    }
    
    public static String notificacionAlbumMsg(int albumid){
        AlbumDAO albumdao = new AlbumDAOSQL();
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        
        Album album = albumdao.consultarAlbum(albumid);
        Usuario usuario = usuariodao.consultarUsuario(album.getFk_usuario());
        String nombre = usuario.getUsuario_nombre() + " " + usuario.getUsuario_apellido();
        
        
        return nombre + " added a new album " + album.getAlbum_nombre();
    }
    
    public static String notificacionComentarioMsg(int idComentario){
        
        
        
        return "";
    }
    
    public static String notificacionLike(int idLike){
        return "";
    }
    
    public static String notificacionDislike (int idDislike){
        return "";
    }
    
    
}
