/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import modelo.Amigo;

/**
 *
 * @author romina
 */
public interface AmigoDAO {
    public void InsertarAmigo (Amigo amigo);
    public void ModificarAmigo (Amigo amigo);
}
