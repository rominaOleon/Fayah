/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author romina
 */
public class Amigo {
    private int Amigo_id;
    private int Amigo_usuario;
    private int Amigo;

    
    public Amigo (int usuario, int amigo){
        this.Amigo_usuario=usuario;
        this.Amigo=amigo;
    }
    
    public int getAmigo_usuario() {
        return Amigo_usuario;
    }

    public void setAmigo_usuario(int Amigo_usuario) {
        this.Amigo_usuario = Amigo_usuario;
    }

    public int getAmigo() {
        return Amigo;
    }

    public void setAmigo(int Amigo) {
        this.Amigo = Amigo;
    }

    public int getAmigo_id() {
        return Amigo_id;
    }

    public void setAmigo_id(int Amigo_id) {
        this.Amigo_id = Amigo_id;
    }
}
