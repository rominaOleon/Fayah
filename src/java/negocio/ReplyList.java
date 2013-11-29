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
public class ReplyList {
        
    private SortedSet<Reply> replys;
    private Comparator idcomparator;

    public ReplyList() {
        this.idcomparator = (Comparator) new IdComparatorReply();
        this.replys = new TreeSet(idcomparator);
    }

    public boolean addReply(Reply reply) {
        return this.replys.add(reply);
    }

    public boolean removeReply(Reply reply) {
        return this.replys.remove(reply);
    }

    public int size() {
        return this.replys.size();
    }

    public Reply get(int posicion) {
        ArrayList<Reply> list = new ArrayList(this.replys);
        return list.get(posicion);
       
    }

    public SortedSet<Reply> getGroups() {
        return replys;
    }

    public void setReplys(SortedSet<Reply> replys) {
        this.replys = replys;
    }
    
    
}
