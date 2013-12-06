/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Album;
import negocio.AlbumList;
import negocio.Comentario;
import negocio.Contenido;
import persistencia.AlbumDAO;
import persistencia.AlbumDAOSQL;
import persistencia.ComentarioDAO;
import persistencia.ComentarioDAOSQL;
import persistencia.ContenidoDAO;
import persistencia.ContenidoDAOSQL;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;
import util.Util;

/**
 *
 * @author admin
 */
public class AlbumContentControlador {
    public static void traerContenido(int posAlbum){
    ContenidoDAO contenidodao= new ContenidoDAOSQL();
    Util.listaContenido= contenidodao.traerContenidos(Util.usuario.getUsuario_albums().get(posAlbum));
    }
    
    public static void eliminarAlbum(){
    Album album = Util.usuario.getUsuario_albums().get(Util.posAlbum);
    AlbumDAO albumdao = new AlbumDAOSQL();
    album.setAlbum_show("f");
    albumdao.modificarAlbum(album);
    UsuarioDAO usuariodao = new UsuarioDAOSQL();
    AlbumList albums = usuariodao.traerAlbums(Util.usuario);
    Util.usuario.setUsuario_albums(albums);
    }
    
    public static void eliminarComentario(int posComentario){
     Comentario comentario = Util.listaComentario.get(posComentario);
     ComentarioDAO comentariodao= new ComentarioDAOSQL();
     comentario.setComentario_show("f");
     comentariodao.modificarComentario(comentario);
     
        
    }
    
    public static void borrarContenido(int posContent){
        Contenido contenido = Util.listaContenido.get(posContent);
        ContenidoDAO contenidodao = new ContenidoDAOSQL();
        contenidodao.eliminarContenido(contenido);
        
    }
    
}
