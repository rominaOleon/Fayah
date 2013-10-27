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
public class AlbumList implements Serializable {

    private SortedSet<Album> albums;
    private Comparator idcomparator;

    public AlbumList() {
        this.idcomparator = (Comparator) new IdComparatorAlbum();
        this.albums = new TreeSet(idcomparator);
    }

    public boolean addAlbum(Album album) {
        return this.albums.add(album);
    }

    public boolean removeAlbum(Album album) {
        return this.albums.remove(album);
    }

    public int size() {
        return this.albums.size();
    }

    public Album get(int posicion) {
        ArrayList<Album> list = new ArrayList(this.albums);
        return list.get(posicion);
       
    }

    public SortedSet<Album> getGroups() {
        return albums;
    }

    public void setAlbums(SortedSet<Album> albums) {
        this.albums = albums;
    }
}
