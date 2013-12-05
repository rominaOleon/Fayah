/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import persistencia.NotificacionDAO;
import persistencia.NotificacionDAOSQL;
import util.Util;
/**
 *
 * @author admin
 */
public class PerfilAmigoControlador {
    
    public static void traerNotificaciones(){
    
    NotificacionDAO notificaciondao = new NotificacionDAOSQL();
    Util.notificacionesAmigo = notificaciondao.traerNotificaciones(Util.amigoPerfil);
    
    
    }
    
    
}
