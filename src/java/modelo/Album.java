/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author romina
 */
public class Album {
    private int     album_id;
    private String  album_nombre;
    private String  album_descripcion;
    private String  album_privacidad;
    private Date    album_fecha_creacion;
    private int     album_likes;
    private int     album_dislikes;
    
    
    public Album(int id,String nombre, String descripcion, String privacidad, Date fecha_creacion, int likes, int dislikes) {
        this.album_id = id;
        this.album_nombre = nombre;
        this.album_descripcion = descripcion;
        this.album_privacidad = privacidad;
        this.album_fecha_creacion = fecha_creacion;
        this.album_likes = likes;
        this.album_dislikes = dislikes;
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

    public Date getAlbum_fecha_creacion() {
        return album_fecha_creacion;
    }

    public void setAlbum_fecha_creacion(Date album_fecha_creacion) {
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
  
}
