/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author romina
 */
public class Notificacion {
    
    private int     notificacion_id;
    private String  notificacion_fecha;
    private String  notificacion_tipo;
    private int     fk_amigo_id;
    private int     fk_comentario_id;
    private int     fk_reply_id;
    private int     fk_like_id;
    private int     fk_dislike_id;
    private int     fk_album_id;
    
    public Notificacion (String fecha, String tipo, int fk_id){
        this.notificacion_id = 0;
        this.notificacion_fecha = fecha;
        this.notificacion_tipo = tipo;
        
        this.fk_amigo_id        = 0;
        this.fk_comentario_id   = 0;
        this.fk_reply_id        = 0;
        this.fk_like_id         = 0;
        this.fk_dislike_id      = 0;
        this.fk_album_id        = 0;
        
        if ("amigo".compareTo(tipo)==0)
            this.fk_amigo_id = fk_id;
        
        if ("comentario".compareTo(tipo)==0)
            this.fk_comentario_id = fk_id;
        
        if ("reply".compareTo(tipo)==0)
            this.fk_reply_id = fk_id;
        
        if ("like".compareTo(tipo)==0)
            this.fk_like_id = fk_id;
        
        if ("dislike".compareTo(tipo)==0)
            this.fk_dislike_id = fk_id;
        
        if ("album".compareTo(tipo)==0)
            this.fk_album_id = fk_id;
    }
    public Notificacion (int id,String fecha,String tipo, int fk_id){
        this.notificacion_id = id;
        this.notificacion_fecha = fecha;
        this.notificacion_tipo = tipo;
        
        this.fk_amigo_id        = 0;
        this.fk_comentario_id   = 0;
        this.fk_reply_id        = 0;
        this.fk_like_id         = 0;
        this.fk_dislike_id      = 0;
        this.fk_album_id        = 0;
        
        if ("amigo".compareTo(tipo)==0)
            this.fk_amigo_id = fk_id;
        
        if ("comentario".compareTo(tipo)==0)
            this.fk_comentario_id = fk_id;
        
        if ("reply".compareTo(tipo)==0)
            this.fk_reply_id = fk_id;
        
        if ("like".compareTo(tipo)==0)
            this.fk_like_id = fk_id;
        
        if ("dislike".compareTo(tipo)==0)
            this.fk_dislike_id = fk_id;
        
        if ("album".compareTo(tipo)==0)
            this.fk_album_id = fk_id;
    }

    public int getNotificacion_id() {
        return notificacion_id;
    }

    public void setNotificacion_id(int notificacion_id) {
        this.notificacion_id = notificacion_id;
    }

    public String getNotificacion_fecha() {
        return notificacion_fecha;
    }

    public void setNotificacion_fecha(String notificacion_fecha) {
        this.notificacion_fecha = notificacion_fecha;
    }

    public String getNotificacion_tipo() {
        return notificacion_tipo;
    }

    public void setNotificacion_tipo(String notificacion_tipo) {
        this.notificacion_tipo = notificacion_tipo;
    }

    public int getFk_amigo_id() {
        return fk_amigo_id;
    }

    public void setFk_amigo_id(int fk_amigo_id) {
        this.fk_amigo_id = fk_amigo_id;
    }

    public int getFk_comentario_id() {
        return fk_comentario_id;
    }

    public void setFk_comentario_id(int fk_comentario_id) {
        this.fk_comentario_id = fk_comentario_id;
    }

    public int getFk_reply_id() {
        return fk_reply_id;
    }

    public void setFk_reply_id(int fk_reply_id) {
        this.fk_reply_id = fk_reply_id;
    }

    public int getFk_like_id() {
        return fk_like_id;
    }

    public void setFk_like_id(int fk_like_id) {
        this.fk_like_id = fk_like_id;
    }

    public int getFk_dislike_id() {
        return fk_dislike_id;
    }

    public void setFk_dislike_id(int fk_dislike_id) {
        this.fk_dislike_id = fk_dislike_id;
    }

    public int getFk_album_id() {
        return fk_album_id;
    }

    public void setFk_album_id(int fk_album_id) {
        this.fk_album_id = fk_album_id;
    }
    
       
}
