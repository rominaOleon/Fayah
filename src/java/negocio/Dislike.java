/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author romina
 */
public class Dislike {
    private int dislikes_id;
    private int fk_album_id;
    private int fk_usuario_id;
    
    public Dislike (int fk_album_id, int fk_usuario_id){
        this.dislikes_id = 0;
        this.fk_album_id = fk_album_id;
        this.fk_usuario_id = fk_usuario_id;
    }
    
    public Dislike (int dislikes_id, int fk_album_id, int fk_usuario_id){
        this.dislikes_id = dislikes_id;
        this.fk_album_id = fk_album_id;
        this.fk_usuario_id = fk_usuario_id;
    }

    public int getDislike_id() {
        return dislikes_id;
    }

    public void setDislike_id(int dislikes_id) {
        this.dislikes_id = dislikes_id;
    }

    public int getFk_album_id() {
        return fk_album_id;
    }

    public void setFk_album_id(int fk_album_id) {
        this.fk_album_id = fk_album_id;
    }

    public int getFk_usuario_id() {
        return fk_usuario_id;
    }

    public void setFk_usuario_id(int fk_usuario_id) {
        this.fk_usuario_id = fk_usuario_id;
    }
    
    

}
