/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author romina
 */
public class Amigo {
    private int Amigo_id;
    private int Amigo_fkusuario1;
    private int Amigo_fkusuario2;

    public Amigo(int idamigo, int fkamigo1, int fkamigo2) {
        this.Amigo_id = idamigo;
        this.Amigo_fkusuario1 = fkamigo1;
        this.Amigo_fkusuario2 = fkamigo2;
    }
    
    public Amigo(int fkamigo1, int fkamigo2) {
        this.Amigo_id = 0;
        this.Amigo_fkusuario1 = fkamigo1;
        this.Amigo_fkusuario2 = fkamigo2;
    }
    
    public int getAmigo_fkusuario1() {
        return Amigo_fkusuario1;
    }

    public void setAmigo_fkusuario1(int Amigo_usuario) {
        this.Amigo_fkusuario1 = Amigo_usuario;
    }

    public int getAmigo_fkusuario2() {
        return Amigo_fkusuario2;
    }

    public void setAmigo_fkusuario2(int Amigo) {
        this.Amigo_fkusuario2 = Amigo;
    }

    public int getAmigo_id() {
        return Amigo_id;
    }

    public void setAmigo_id(int Amigo_id) {
        this.Amigo_id = Amigo_id;
    }
}
