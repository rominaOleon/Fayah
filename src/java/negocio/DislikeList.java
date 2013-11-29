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
public class DislikeList {
    
    
    private SortedSet<Dislike> dislikes;
    private Comparator idcomparator;

    public DislikeList() {
        this.idcomparator = (Comparator) new IdComparatorDislikes();
        this.dislikes = new TreeSet(idcomparator);
    }

    public boolean addDislike(Dislike dislike) {
        return this.dislikes.add(dislike);
    }

    public boolean removeDislike(Dislike dislike) {
        return this.dislikes.remove(dislike);
    }

    public int size() {
        return this.dislikes.size();
    }

    public Dislike get(int posicion) {
        ArrayList<Dislike> list = new ArrayList(this.dislikes);
        return list.get(posicion);
       
    }

    public SortedSet<Dislike> getGroups() {
        return dislikes;
    }

    public void setDislikes(SortedSet<Dislike> dislikes) {
        this.dislikes = dislikes;
    }
    
}
