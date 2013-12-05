/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import negocio.Album;
import negocio.AlbumList;
import negocio.Notificacion;
import negocio.NotificacionList;
import persistencia.AlbumDAO;
import persistencia.AlbumDAOSQL;
import persistencia.NotificacionDAO;
import persistencia.NotificacionDAOSQL;
import persistencia.UsuarioDAO;
import persistencia.UsuarioDAOSQL;
import util.Util;

/**
 *
 * @author romina
 */
public class NewAlbumControlador {
    
    public static void NuevoAlbum(String nombre, String descripcion){
        Date date = new Date();
        DateFormat formatofecha = new SimpleDateFormat("mm/dd/yyy");
        String fecha_creacion = formatofecha.format(date);
        
        Album album = new Album(nombre,descripcion,"A",fecha_creacion,0,0,Util.defaultAlbumCover,"t");
        AlbumDAO albumdao = new AlbumDAOSQL();
        albumdao.insertarAlbum(album);
        
       
        
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        
        NotificacionDAO notificaciondao = new NotificacionDAOSQL();
        NotificacionList notificaciones = notificaciondao.traerNotificaciones(Util.usuario);
        
        AlbumList albums = usuariodao.traerAlbums(Util.usuario);
        Util.usuario.setUsuario_albums(albums);
        Util.notificaciones = notificaciones;
   }
    
}
