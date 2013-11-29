/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author romina
 */
public class Reply {
    private int reply_id;
    private String reply_fecha;
    private int fk_comentario1_id;
    private int fk_comentario2_id;

    public Reply(String fecha, int fk_comentario1_id, int fk_comentario2_id) {
        this.reply_fecha = fecha;
        this.fk_comentario1_id = fk_comentario1_id;
        this.fk_comentario2_id = fk_comentario2_id;
    }

    public Reply(int id, String fecha, int fk_comentario1_id, int fk_comentario2_id) {
        this.reply_id = id;
        this.reply_fecha = fecha;
        this.fk_comentario1_id = fk_comentario1_id;
        this.fk_comentario2_id = fk_comentario2_id;
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public String getReply_fecha() {
        return reply_fecha;
    }

    public void setReply_fecha(String reply_fecha) {
        this.reply_fecha = reply_fecha;
    }

    public int getFk_comentario1_id() {
        return fk_comentario1_id;
    }

    public void setFk_comentario1_id(int fk_comentario1_id) {
        this.fk_comentario1_id = fk_comentario1_id;
    }

    public int getFk_comentario2_id() {
        return fk_comentario2_id;
    }

    public void setFk_comentario2_id(int fk_comentario2_id) {
        this.fk_comentario2_id = fk_comentario2_id;
    }
    
    
}
