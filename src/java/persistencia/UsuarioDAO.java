/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.AlbumList;
import modelo.AmigoList;
import modelo.Usuario;

/**
 *
 * @author romina
 */
public interface UsuarioDAO {    
    public int UsuarioExiste (String email);
    public void InsertarUsuario (Usuario usuario);
    public Usuario ConsultarUsuario (String email);
    public void ModificarUsuario (Usuario usuario);
    public AmigoList TraerAmigos (Usuario usuario);
    public AlbumList TraerAlbums (Usuario usuario);
}
