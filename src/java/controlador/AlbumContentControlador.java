/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import persistencia.ContenidoDAO;
import persistencia.ContenidoDAOSQL;
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
    
}
