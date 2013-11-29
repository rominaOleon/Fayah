/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Album;
import negocio.Dislike;
import negocio.DislikeList;

/**
 *
 * @author romina
 */
public interface DislikeDAO {
    public void insertarDislike(Dislike dislike);
    public DislikeList traerDislikes (Album album);
}
