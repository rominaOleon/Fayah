/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.AlbumList;
import negocio.AmigoList;
import negocio.Usuario;
import negocio.UsuariosList;

/**
 *
 * @author romina
 */
public interface UsuarioDAO {    
    public int usuarioExiste (String email);
    public void insertarUsuario (Usuario usuario);
    public Usuario consultarUsuario (String email);
    public void modificarUsuario (Usuario usuario);
    public AmigoList traerAmigos (Usuario usuario);
    public AlbumList traerAlbums (Usuario usuario);
    public UsuariosList buscarUsuario (String busqueda);
    public Usuario consultarUsuario(int id);
}
