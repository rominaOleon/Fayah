/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Amigo;

/**
 *
 * @author romina
 */
public interface AmigoDAO {
    public void insertarAmigo (Amigo amigo);
    public void modificarAmigo (Amigo amigo);
    public boolean sonAmigos(int usuarioId, int amigoId);
}
