/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Notificacion;
import negocio.NotificacionList;
import negocio.Usuario;

/**
 *
 * @author romina
 */
public interface NotificacionDAO {
    public void insertarNotificacion (Notificacion notificacion);
    public NotificacionList traerNotificaciones (Usuario usuario);
}
