/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Album;
import negocio.Contenido;
import negocio.ContenidoList;

/**
 *
 * @author romina
 */
public interface ContenidoDAO {
    public void insertarContenido (Contenido contenido);
    public ContenidoList traerContenidos (Album album);
    public void modificarContenido (Contenido contenido);
    
}
