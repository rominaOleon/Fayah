/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author romina
 */
public class NotificacionList {
    
    private SortedSet<Notificacion> notificaciones;
    private Comparator idcomparator;

    public NotificacionList() {
        this.idcomparator = (Comparator) new IdComparatorNotificacion();
        this.notificaciones = new TreeSet(idcomparator);

    }

    public boolean addNotificacion(Notificacion notificacion) {
        return this.notificaciones.add(notificacion);
    }

    public boolean removeNotificacion(Notificacion notificacion) {
        return this.notificaciones.remove(notificacion);
    }

    public int size() {
        return this.notificaciones.size();
    }

    public Notificacion get(int posicion) {
        ArrayList<Notificacion> list = new ArrayList(this.notificaciones);
        return list.get(posicion);
    }

    public SortedSet<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificacion(SortedSet<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
    
}
