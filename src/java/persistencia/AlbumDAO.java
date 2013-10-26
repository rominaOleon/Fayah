/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Album;

/**
 *
 * @author romina
 */
public interface AlbumDAO {    
    public void InsertarAlbum (Album album);;
    public void ModificarAlbum (Album album);
}
