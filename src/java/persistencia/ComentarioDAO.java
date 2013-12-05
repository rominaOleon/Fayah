/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Album;
import negocio.Comentario;
import negocio.ComentarioList;

/**
 *
 * @author romina
 */
public interface ComentarioDAO {
    public void insertarComentario (Comentario comentario);
    public ComentarioList traerComentarios (Album album);
    public void modificarComentario (Comentario comentario);
    public Comentario consultarComentario(int id);
    
}
