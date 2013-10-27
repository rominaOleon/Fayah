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
public class UsuariosList {
    
private SortedSet<Usuario> usuarios;
private Comparator idcomparator;
    


    public UsuariosList() {
        this.idcomparator = (Comparator) new IdComparatorUsuario();
        this.usuarios = new TreeSet(idcomparator);
    }

    public boolean addUsuario(Usuario usuario) {
        return this.usuarios.add(usuario);
    }

    public boolean removeUsuario(Usuario usuario) {
        return this.usuarios.remove(usuario);
    }

    public int size() {
        return this.usuarios.size();
    }

    public Usuario get(int posicion) {
        ArrayList<Usuario> list = new ArrayList(this.usuarios);
        return list.get(posicion);
       
    }

    public SortedSet<Usuario> getGroups() {
        return usuarios;
    }

    public void setUsuarios(SortedSet<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

    

