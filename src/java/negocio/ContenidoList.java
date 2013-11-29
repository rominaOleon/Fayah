/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author romina
 */
public class ContenidoList implements Serializable  {
   
    private SortedSet<Contenido> contenidos;
    private Comparator idcomparator;

    public ContenidoList() {
        this.idcomparator = (Comparator) new IdComparatorContenido();
        this.contenidos = new TreeSet(idcomparator);
    }

    public boolean addContenido(Contenido contenido) {
        return this.contenidos.add(contenido);
    }

    public boolean removeContenido(Contenido contenido) {
        return this.contenidos.remove(contenido);
    }

    public int size() {
        return this.contenidos.size();
    }

    public Contenido get(int posicion) {
        ArrayList<Contenido> list = new ArrayList(this.contenidos);
        return list.get(posicion);
       
    }

    public SortedSet<Contenido> getGroups() {
        return contenidos;
    }

    public void setContenidos(SortedSet<Contenido> contenidos) {
        this.contenidos = contenidos;
    }
    
}
