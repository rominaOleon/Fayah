/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Contenido;
import negocio.ContenidoList;
import persistencia.ContenidoDAO;
import persistencia.ContenidoDAOSQL;
import util.Util;
/**
 *
 * @author admin
 */
public class NewContentControlador {
    public static void agregarContenido(String contenidoURL, int idAlbum){
        ContenidoDAO contenidodao = new ContenidoDAOSQL();
        Contenido contenido = new Contenido (contenidoURL,idAlbum);
        contenidodao.insertarContenido(contenido);
        ContenidoList contenidos= contenidodao.traerContenidos(Util.usuario.getUsuario_albums().get(Util.posAlbum));
        Util.listaContenido= contenidos;
        
        
    }
}
