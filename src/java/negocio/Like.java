/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author romina
 */
public class Like {
    private int likes_id;
    private int fk_album_id;
    private int fk_usuario_id;
    
    public Like (int fk_album_id, int fk_usuario_id){
        this.likes_id = 0;
        this.fk_album_id = fk_album_id;
        this.fk_usuario_id = fk_usuario_id;
    }
    
    public Like (int likes_id, int fk_album_id, int fk_usuario_id){
        this.likes_id = likes_id;
        this.fk_album_id = fk_album_id;
        this.fk_usuario_id = fk_usuario_id;
    }

    public int getLike_id() {
        return likes_id;
    }

    public void setLike_id(int likes_id) {
        this.likes_id = likes_id;
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
