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
public class ComentarioList implements Serializable {
    
    
    private SortedSet<Comentario> comentarios;
    private Comparator idcomparator;

    public ComentarioList() {
        this.idcomparator = (Comparator) new IdComparatorComentario();
        this.comentarios = new TreeSet(idcomparator);
    }

    public boolean addComentario(Comentario comentario) {
        return this.comentarios.add(comentario);
    }

    public boolean removeComentario(Comentario comentario) {
        return this.comentarios.remove(comentario);
    }

    public int size() {
        return this.comentarios.size();
    }

    public Comentario get(int posicion) {
        ArrayList<Comentario> list = new ArrayList(this.comentarios);
        return list.get(posicion);
       
    }

    public SortedSet<Comentario> getGroups() {
        return comentarios;
    }

    public void setComentarios(SortedSet<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    
}
