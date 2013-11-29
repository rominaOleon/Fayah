/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author romina
 */
public class Comentario {
    private int comentario_id;
    private String comentario_fecha;
    private int comentario_likes;
    private int comentario_dislikes;
    private String comentario_show;
    private int fk_usuario_id;
    private int fk_album_id;
    private String comentario_texto;
    
    public Comentario(String fecha, int likes, int dislikes, String show, int fk_usuario_id, int fk_album_id,String texto){
        this.comentario_id=0;
        this.comentario_fecha = fecha;
        this.comentario_likes = likes;
        this.comentario_dislikes = dislikes;
        this.comentario_show = show;
        this.fk_usuario_id = fk_usuario_id;
        this.fk_album_id = fk_album_id;
        this.comentario_texto = texto;
    }
    
    public Comentario(int id, String fecha, int likes, int dislikes, String show, int fk_usuario_id, int fk_album_id,String texto){
        this.comentario_id=id;
        this.comentario_fecha = fecha;
        this.comentario_likes = likes;
        this.comentario_dislikes = dislikes;
        this.comentario_show = show;
        this.fk_usuario_id = fk_usuario_id;
        this.fk_album_id = fk_album_id;
        this.comentario_texto = texto;
    }

    public int getComentario_id() {
        return comentario_id;
    }

    public void setComentario_id(int comentario_id) {
        this.comentario_id = comentario_id;
    }

    public String getComentario_fecha() {
        return comentario_fecha;
    }

    public void setComentario_fecha(String comentario_fecha) {
        this.comentario_fecha = comentario_fecha;
    }

    public int getComentario_likes() {
        return comentario_likes;
    }

    public void setComentario_likes(int comentario_likes) {
        this.comentario_likes = comentario_likes;
    }

    public int getComentario_dislikes() {
        return comentario_dislikes;
    }

    public void setComentario_dislikes(int comentario_dislikes) {
        this.comentario_dislikes = comentario_dislikes;
    }

    public String getComentario_show() {
        return comentario_show;
    }

    public void setComentario_show(String comentario_show) {
        this.comentario_show = comentario_show;
    }

    public int getFk_usuario_id() {
        return fk_usuario_id;
    }

    public void setFk_usuario_id(int fk_usuario_id) {
        this.fk_usuario_id = fk_usuario_id;
    }

    public int getFk_album_id() {
        return fk_album_id;
    }

    public void setFk_album_id(int fk_album_id) {
        this.fk_album_id = fk_album_id;
    }

    public String getComentario_texto() {
        return comentario_texto;
    }

    public void setComentario_texto(String comentario_texto) {
        this.comentario_texto = comentario_texto;
    }
    
    
    
       
    
}
