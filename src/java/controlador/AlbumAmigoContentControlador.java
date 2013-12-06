/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Comentario;
import negocio.ComentarioList;
import negocio.Dislike;
import negocio.Like;
import negocio.Reply;
import negocio.Usuario;
import persistencia.AlbumDAO;
import persistencia.AlbumDAOSQL;
import persistencia.ComentarioDAO;
import persistencia.ComentarioDAOSQL;
import persistencia.ContenidoDAO;
import persistencia.ContenidoDAOSQL;
import persistencia.DislikeDAO;
import persistencia.DislikeDAOSQL;
import persistencia.LikeDAO;
import persistencia.LikeDAOSQL;
import persistencia.ReplyDAO;
import persistencia.ReplyDAOSQL;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;
import util.Util;

/**
 *
 * @author admin
 */
public class AlbumAmigoContentControlador {
    
    public static void traerContenido(int posAlbum, Usuario delAlbum){
    ContenidoDAO contenidodao= new ContenidoDAOSQL();
    Util.listaContenido= contenidodao.traerContenidos(delAlbum.getUsuario_albums().get(posAlbum));
    
    }
    
    public static void modificarComentario(int posComentario, int like, Usuario elComentado){
        
        Comentario comentario= Util.listaComentario.get(posComentario);
        
        
        if (like==0){
            
            comentario.setComentario_likes(comentario.getComentario_likes()+1);
        
        
        }
        
         if (like==1){
            
            comentario.setComentario_dislikes(comentario.getComentario_dislikes()+1);
        
        
        }
         
         ComentarioDAO comentariodao= new ComentarioDAOSQL();
         comentariodao.modificarComentario(comentario);
         Util.listaComentario= comentariodao.traerComentarios(elComentado.getUsuario_albums().get(Util.posAlbum));
    
    
    }
    
    public static void agregarReply (int posComentario, String texto, Usuario delReply){
         ComentarioDAO comentariodao= new ComentarioDAOSQL();
        Comentario comentario= new Comentario("fecha",0,0,"t",Util.usuario.getUsuario_id(),delReply.getUsuario_albums().get(Util.posAlbum).getAlbum_id(),texto);
        comentariodao.insertarComentario(comentario);
        ComentarioList comentarios =     comentariodao.traerComentarios(delReply.getUsuario_albums().get(Util.posAlbum));
        int tamaño = comentarios.size()-1;
        int fk = comentarios.get(tamaño).getComentario_id();
        Reply reply = new Reply("fecha",Util.listaComentario.get(posComentario).getComentario_id(),fk);
        ReplyDAO replydao=new ReplyDAOSQL ();
        replydao.insertarReply(reply);
        comentariodao.traerComentarios(delReply.getUsuario_albums().get(Util.posAlbum));
        
    }

/**
 * modificarRatingAlbum. 
 * Modifica los valores del likes y dislikes de un album en especifico.
 * 
 * El entero like indica si el valor a modificar es un like o un dislike.
 * El dueñoAlbum de tipo Usuario debe ser el dueño del album a modificar.
 * El autorLike de tipo Usuario deber ser el usuario que esta haciendo
 * like o dislike al album.
 *
 * @param  like  define tipo de rating 0=Like, 1=Dislike
 * @param  dueñoAlbum dueño del album al que se le esta modificando el rating
 * @param  autorLike usuario que esta realizando el like o dislike
 * @see         negocio.Usuario
 * @see         negocio.Album
 * @see         negocio.Like
 * @see         negocio.Dislike
 */
    
 public static void modificarRatingAlbum(int like, Usuario dueñoAlbum, Usuario autorLike){
 
 if (like==0){
     int likeAcumulado= dueñoAlbum.getUsuario_albums().get(Util.posAlbum).getAlbum_likes()+1;
     
     dueñoAlbum.getUsuario_albums().get(Util.posAlbum).setAlbum_likes(likeAcumulado);
     AlbumDAO albumdao = new AlbumDAOSQL();
     albumdao.modificarAlbum(dueñoAlbum.getUsuario_albums().get(Util.posAlbum));
     UsuarioDAO usuario= new UsuarioDAOSQL();
     dueñoAlbum.setUsuario_albums(usuario.traerAlbums(dueñoAlbum));
     Like likes = new Like (dueñoAlbum.getUsuario_albums().get(Util.posAlbum).getAlbum_id(),autorLike.getUsuario_id());
     LikeDAO likedao =new  LikeDAOSQL();
     likedao.insertarLike(likes);
 
 }
 
 if (like==1){

          int dislikeAcumulado= dueñoAlbum.getUsuario_albums().get(Util.posAlbum).getAlbum_dislikes()+1;
     
     dueñoAlbum.getUsuario_albums().get(Util.posAlbum).setAlbum_dislikes(dislikeAcumulado);
     AlbumDAO albumdao = new AlbumDAOSQL();
     albumdao.modificarAlbum(dueñoAlbum.getUsuario_albums().get(Util.posAlbum));
     UsuarioDAO usuario= new UsuarioDAOSQL();
     dueñoAlbum.setUsuario_albums(usuario.traerAlbums(dueñoAlbum));
     Dislike dislikes = new Dislike (dueñoAlbum.getUsuario_albums().get(Util.posAlbum).getAlbum_id(),autorLike.getUsuario_id());
     DislikeDAO dislikedao =new  DislikeDAOSQL();
     dislikedao.insertarDislike(dislikes);
     
}
 
 
 
 }
 
 
 
}
