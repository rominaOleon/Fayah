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
public class LikeList {
    
    private SortedSet<Like> likes;
    private Comparator idcomparator;

    public LikeList() {
        this.idcomparator = (Comparator) new IdComparatorLikes();
        this.likes = new TreeSet(idcomparator);
    }

    public boolean addLike(Like like) {
        return this.likes.add(like);
    }

    public boolean removeLike(Like like) {
        return this.likes.remove(like);
    }

    public int size() {
        return this.likes.size();
    }

    public Like get(int posicion) {
        ArrayList<Like> list = new ArrayList(this.likes);
        return list.get(posicion);
       
    }

    public SortedSet<Like> getGroups() {
        return likes;
    }

    public void setLikes(SortedSet<Like> likes) {
        this.likes = likes;
    }
    
    
}
