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
public class AmigoList {

    private SortedSet<Amigo> amigos;
    private Comparator idcomparator;

    public AmigoList() {
        this.idcomparator = (Comparator) new IdComparatorAmigo();
        this.amigos = new TreeSet(idcomparator);

    }

    public boolean addAmigo(Amigo amigo) {
        return this.amigos.add(amigo);
    }

    public boolean removeAmigo(Amigo amigo) {
        return this.amigos.remove(amigo);
    }

    public int size() {
        return this.amigos.size();
    }

    public Amigo get(int posicion) {
        ArrayList<Amigo> list = new ArrayList(this.amigos);
        return list.get(posicion);
    }

    public SortedSet<Amigo> getAmigos() {
        return amigos;
    }

    public void serAmigos(SortedSet<Amigo> amigos) {
        this.amigos = amigos;
    }
}
