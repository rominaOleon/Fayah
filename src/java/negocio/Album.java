/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author romina
 */
public class Album {
    private int     album_id;
    private String  album_nombre;
    private String  album_descripcion;
    private String  album_privacidad;
    private String  album_fecha_creacion;
    private int     album_likes;
    private int     album_dislikes;
    private String  album_miniatura;
    private int     fk_usuario;
    private String  album_show;
    
    
    public Album(int id,String nombre, String descripcion, String privacidad, String fecha_creacion, int likes, int dislikes,String miniatura,String show) {
        this.album_id = id;
        this.album_nombre = nombre;
        this.album_descripcion = descripcion;
        this.album_privacidad = privacidad;
        this.album_fecha_creacion = fecha_creacion;
        this.album_likes = likes;
        this.album_dislikes = dislikes;
        this.album_miniatura = miniatura;
        this.fk_usuario = 0;
        this.album_show = show;
        
    }
    
        public Album(int id,String nombre, String descripcion, String privacidad, String fecha_creacion, int likes, int dislikes,String miniatura,int fk_usuario,String show) {
        this.album_id = id;
        this.album_nombre = nombre;
        this.album_descripcion = descripcion;
        this.album_privacidad = privacidad;
        this.album_fecha_creacion = fecha_creacion;
        this.album_likes = likes;
        this.album_dislikes = dislikes;
        this.album_miniatura = miniatura;
        this.fk_usuario = fk_usuario;
        this.album_show = show;
    }
    
    public Album(String nombre, String descripcion, String privacidad, String fecha_creacion, int likes, int dislikes,String miniatura,String show) {
        this.album_id = 0;
        this.album_nombre = nombre;
        this.album_descripcion = descripcion;
        this.album_privacidad = privacidad;
        this.album_fecha_creacion = fecha_creacion;
        this.album_likes = likes;
        this.album_dislikes = dislikes;
        this.album_miniatura = miniatura;
        this.fk_usuario = 0;
        this.album_show = show;
    }

    public int getFk_usuario() {
        return fk_usuario;
    }

    public void setFk_usuario(int fk_usuario) {
        this.fk_usuario = fk_usuario;
    }
    
    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_nombre() {
        return album_nombre;
    }

    public void setAlbum_nombre(String album_nombre) {
        this.album_nombre = album_nombre;
    }

    public String getAlbum_descripcion() {
        return album_descripcion;
    }

    public void setAlbum_descripcion(String album_descripcion) {
        this.album_descripcion = album_descripcion;
    }

    public String getAlbum_privacidad() {
        return album_privacidad;
    }

    public void setAlbum_privacidad(String album_privacidad) {
        this.album_privacidad = album_privacidad;
    }

    public String getAlbum_fecha_creacion() {
        return album_fecha_creacion;
    }

    public void setAlbum_fecha_creacion(String album_fecha_creacion) {
        this.album_fecha_creacion = album_fecha_creacion;
    }

    public int getAlbum_likes() {
        return album_likes;
    }

    public void setAlbum_likes(int album_likes) {
        this.album_likes = album_likes;
    }

    public int getAlbum_dislikes() {
        return album_dislikes;
    }

    public void setAlbum_dislikes(int album_dislikes) {
        this.album_dislikes = album_dislikes;
    }

    public String getAlbum_miniatura() {
        return album_miniatura;
    }

    public void setAlbum_miniatura(String album_miniatura) {
        this.album_miniatura = album_miniatura;
    }

    public String getAlbum_show() {
        return album_show;
    }

    public void setAlbum_show(String album_show) {
        this.album_show = album_show;
    }
    
    
    
}
