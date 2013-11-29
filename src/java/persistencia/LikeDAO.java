/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Album;
import negocio.Like;
import negocio.LikeList;

/**
 *
 * @author romina
 */
public interface LikeDAO {
    public void insertarLike(Like like);
    public LikeList traerlikes (Album album);
}
