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
import persistencia.AlbumDAO;
import persistencia.AlbumDAOSQL;
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
        Album album = new Album(nombre,descripcion,"A",fecha_creacion,0,0,Util.defaultAlbumCover);
        AlbumDAO albumdao = new AlbumDAOSQL();
        albumdao.InsertarAlbum(album);
        
        UsuarioDAO usuariodao = new UsuarioDAOSQL();
        
        AlbumList albums = usuariodao.TraerAlbums(Util.usuario);
        Util.usuario.setUsuario_albums(albums);
        
   }
    
}
