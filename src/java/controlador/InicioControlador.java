/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Album;
import negocio.Amigo;
import negocio.Comentario;
import negocio.Dislike;
import negocio.Like;
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
import util.Util;
/**
 *
 * @author romina
 */
public class InicioControlador {
    
    public static UsuariosList BuscarUsuario(String busqueda) {
    
        UsuarioDAO usuariodao = new UsuarioDAOSQL();

        UsuariosList usuarios = usuariodao.buscarUsuario(busqueda);

        return usuarios;
    }
    
    
    /**
 * idAmigo. 
 * Dado el id de la tabla que relaciona la amistad entre un usuario y otro
 * consulta el id del usuario que pertenece a esa amistad.
 *
 * @param  idTabla  id de la tabla amigo.
 * @return      Id del amigo que pertenece a la amistad
 * @see         negocio.Amigo
 */
    
    public static int idAmigo (int idTabla){
    AmigoDAO amigodao= new AmigoDAOSQL();
    Amigo amigo = amigodao.consultarAmigo(idTabla);
    
    
    return amigo.getAmigo_fkusuario1();
    }
    
    /**
 * idAlbum. 
 * Dado el id de un comentario consulta a que album pertene el comentario
 * y retorna 1 si el usuario conectado es el dueño del album o 0 si el dueño
 * es otro usuario
 *
 * @param  idComentario  id del comentario
 * @return      1 si el usuario conectado es el dueño del album. 0 si el dueño del album es otro usuario
 * @see         negocio.Comentario
 * @see         negocio.Album
 */
    
    public static int idAlbum (int idComentario){
       
    ComentarioDAO comentariodao= new ComentarioDAOSQL();
    Comentario comentario = comentariodao.consultarComentario(idComentario);
    AlbumDAO albumdao = new AlbumDAOSQL();
    
    Album album= albumdao.consultarAlbum(comentario.getFk_album_id());
    ResultFriendControlador.TraerAmigo(album.getFk_usuario());
    for (int pos=0; pos<=Util.amigoPerfil.getUsuario_albums().size()-1;pos++){
     
        
        if (album.getAlbum_id()==Util.amigoPerfil.getUsuario_albums().get(pos).getAlbum_id())
            Util.posAlbum = pos;
    }
    if (album.getFk_usuario()==Util.usuario.getUsuario_id()){
       Util.amigoPerfil= new Usuario();
       return 1;
    }
    else{
        return 0;
    }
    

    }
    
    /**
 * likeAlbum. 
 * Dado el id de un like consulta a que album pertenece el like.
 * 
 * @param  idLike  id del like
 * @return      id del album al que corresponde el like
 * @see         negocio.Like
 * @see         negocio.Album
 */
    public static int likeAlbum(int idLike){
        LikeDAO likedao = new LikeDAOSQL();
        Like like = likedao.consultarLike(idLike);
        AlbumDAO albumdao = new AlbumDAOSQL();
        Album album = albumdao.consultarAlbum(like.getFk_album_id());
        return album.getAlbum_id();
    }
    
        /**
 * dislikeAlbum. 
 * Dado el id de un dislike consulta a que album pertenece el dislike.
 * 
 * @param  idDislike  id del dislike
 * @return      id del album al que corresponde el dislike
 * @see         negocio.Dislike
 * @see         negocio.Album
 */    
    
   public static int dislikeAlbum(int idDislike){
        DislikeDAO dislikedao = new DislikeDAOSQL();
        Dislike dislike = dislikedao.consultarDislike(idDislike);
        AlbumDAO albumdao = new AlbumDAOSQL();
        Album album = albumdao.consultarAlbum(dislike.getFk_album_id());
        return album.getAlbum_id();
    }
    
    public static int albumAmigo (int idAlbum){
        AlbumDAO albumdao = new AlbumDAOSQL();        
        Album album = albumdao.consultarAlbum(idAlbum);
        ResultFriendControlador.TraerAmigo(album.getFk_usuario());
        
        for (int pos = 0; pos <= Util.amigoPerfil.getUsuario_albums().size() - 1; pos++) {
            if (idAlbum == Util.amigoPerfil.getUsuario_albums().get(pos).getAlbum_id()) {
                Util.posAlbum = pos;
            }
        }
        
        if (album.getFk_usuario() == Util.usuario.getUsuario_id()) {
            Util.amigoPerfil = new Usuario();
            return 1;
        } else {
            return 0;
        }

        
        
    }
    
}
