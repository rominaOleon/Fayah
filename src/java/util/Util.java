/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import negocio.Album;
import negocio.Amigo;
import negocio.Comentario;
import negocio.ComentarioList;
import negocio.ContenidoList;
import negocio.Dislike;
import negocio.Like;
import negocio.NotificacionList;
import negocio.ReplyList;
import negocio.Usuario;
import negocio.UsuariosList;
import persistencia.AlbumDAO;
import persistencia.AlbumDAOSQL;
import persistencia.AmigoDAO;
import persistencia.AmigoDAOSQL;
import persistencia.ComentarioDAO;
import persistencia.ComentarioDAOSQL;
import persistencia.DislikeDAO;
import persistencia.DislikeDAOSQL;
import persistencia.LikeDAO;
import persistencia.LikeDAOSQL;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;

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
    public static ContenidoList listaContenido = new ContenidoList();
    public static ComentarioList listaComentario= new ComentarioList();
    
    public static boolean reply=false;
    public static int posComentario =0;
    public static ComentarioList listaReply = new ComentarioList();
    public static NotificacionList notificacionesAmigo = new NotificacionList();
    
    
    
    
    public static String notificacionAmigoMsg(int idAmistad){
        
        AmigoDAO amigodao = new AmigoDAOSQL();
        Amigo amistad = amigodao.consultarAmigo(idAmistad);
        
        int amigo1=amistad.getAmigo_fkusuario1();
        int amigo2=amistad.getAmigo_fkusuario2();
        
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

        
        return nombre1 + " and " + nombre2 + " are now friends.";
        
    }
    
    public static String notificacionAlbumMsg(int albumid){
        AlbumDAO albumdao = new AlbumDAOSQL();
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        
        Album album = albumdao.consultarAlbum(albumid);
        Usuario dueñoAlbum = usuariodao.consultarUsuario(album.getFk_usuario());
        String msg = dueñoAlbum.getUsuario_nombre() + " " 
                + dueñoAlbum.getUsuario_apellido()+ " added a new album " 
                + album.getAlbum_nombre();

        return msg;
    }
    
    public static String notificacionComentarioMsg(int idComentario){
        ComentarioDAO comentariodao = new ComentarioDAOSQL();
        Comentario comentario = comentariodao.consultarComentario(idComentario);
        
        int idComentador = comentario.getFk_usuario_id();
        int idAlbum = comentario.getFk_album_id();
        
        
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        Usuario comentador = usuariodao.consultarUsuario(idComentador);
        
        AlbumDAO albumdao = new AlbumDAOSQL();
        Album album = albumdao.consultarAlbum(idAlbum);
        
        int idDueñoAlbum = album.getFk_usuario();
        Usuario dueñoAlbum = usuariodao.consultarUsuario(idDueñoAlbum);
        
        String nombreDueño ="";
        if (dueñoAlbum.getUsuario_id()==Util.usuario.getUsuario_id())
            nombreDueño = "Your";
        else
            nombreDueño = dueñoAlbum.getUsuario_nombre() + " " + dueñoAlbum.getUsuario_apellido()+"'s";
            
        
        String msg = comentador.getUsuario_nombre() + " " 
                + comentador.getUsuario_apellido() 
                + " commented on " + nombreDueño 
                + " album " + album.getAlbum_nombre();
        

        return msg;
        
    }
    
    public static String notificacionLike(int idLike){
        
        LikeDAO likedao = new LikeDAOSQL();
        Like like = likedao.consultarLike(idLike);
        
        int idComentador = like.getFk_usuario_id();
        int idAlbum = like.getFk_album_id();
        
        
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        Usuario comentador = usuariodao.consultarUsuario(idComentador);
        
        AlbumDAO albumdao = new AlbumDAOSQL();
        Album album = albumdao.consultarAlbum(idAlbum);
        
        int idDueñoAlbum = album.getFk_usuario();
        Usuario dueñoAlbum = usuariodao.consultarUsuario(idDueñoAlbum);
        
        String nombreDueño ="";
        if (dueñoAlbum.getUsuario_id()==Util.usuario.getUsuario_id())
            nombreDueño = "Your";
        else
            nombreDueño = dueñoAlbum.getUsuario_nombre() + " " + dueñoAlbum.getUsuario_apellido() +"'s";
        
        String msg = comentador.getUsuario_nombre() + " " 
                + comentador.getUsuario_apellido() 
                + " liked " + nombreDueño
                + " album " + album.getAlbum_nombre();

        
        return msg;
    }
    
    public static String notificacionDislike (int idDislike){
        
          
        DislikeDAO dislikedao = new DislikeDAOSQL();
        Dislike dislike = dislikedao.consultarDislike(idDislike);
        
        int idComentador = dislike.getFk_usuario_id();
        int idAlbum = dislike.getFk_album_id();
        
        
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        Usuario comentador = usuariodao.consultarUsuario(idComentador);
        
        AlbumDAO albumdao = new AlbumDAOSQL();
        Album album = albumdao.consultarAlbum(idAlbum);
        
        int idDueñoAlbum = album.getFk_usuario();
        Usuario dueñoAlbum = usuariodao.consultarUsuario(idDueñoAlbum);
        
        String nombreDueño ="";
        if (dueñoAlbum.getUsuario_id()==Util.usuario.getUsuario_id())
            nombreDueño = "Your";
        else
            nombreDueño = dueñoAlbum.getUsuario_nombre() + " " + dueñoAlbum.getUsuario_apellido()+"'s";
        
        String msg = comentador.getUsuario_nombre() + " " 
                + comentador.getUsuario_apellido() 
                + " disliked " + nombreDueño
                + " album " + album.getAlbum_nombre();

        
        return msg;
    }
    
    
}
