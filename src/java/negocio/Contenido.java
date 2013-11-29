/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author romina
 */
public class Contenido {
    private int contenido_id;
    private String contenido_url;
    private int fk_album_id;
    
    public Contenido(int id, String url, int fk_album){
        this.contenido_id = id;
        this.contenido_url = url;
        this.fk_album_id = fk_album;
    }
    
    public Contenido (String url, int fk_album){
        this.contenido_id = 0;
        this.contenido_url = url;
        this.fk_album_id = fk_album;
    }

    public int getContenido_id() {
        return contenido_id;
    }

    public void setContenido_id(int contenido_id) {
        this.contenido_id = contenido_id;
    }

    public String getContenido_url() {
        return contenido_url;
    }

    public void setContenido_url(String contenido_url) {
        this.contenido_url = contenido_url;
    }

    public int getFk_album_id() {
        return fk_album_id;
    }

    public void setFk_album_id(int fk_album_id) {
        this.fk_album_id = fk_album_id;
    }
        
}
