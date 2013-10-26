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
public class Usuario {
    private int     usuario_id;
    private String  usuario_username;
    private String  usuario_nombre;
    private String  usuario_apellido;
    private String  usuario_email;
    private Date    usuario_fecha_nacimiento;
    private String  usuario_ubicacion;
    private String  usuario_privacidad;
    private AlbumList usuario_albums;
    private AmigoList usuario_amigos;
    
    public Usuario(int id,String username, String nombre, String apellido, String email, Date fecha_nacimiento, String ubicacion, String privacidad) {
        this.usuario_id = id;
        this.usuario_username = username;
        this.usuario_nombre = nombre;
        this.usuario_apellido = apellido;
        this.usuario_email = email;
        this.usuario_fecha_nacimiento = fecha_nacimiento;
        this.usuario_ubicacion = ubicacion;
        this.usuario_privacidad = privacidad;
        this.usuario_albums = new AlbumList();
        this.usuario_amigos = new AmigoList();
    }
    
        public Usuario(String username, String nombre, String apellido, String email, Date fecha_nacimiento, String ubicacion, String privacidad) {
        this.usuario_id = 0;
        this.usuario_username = username;
        this.usuario_nombre = nombre;
        this.usuario_apellido = apellido;
        this.usuario_email = email;
        this.usuario_fecha_nacimiento = fecha_nacimiento;
        this.usuario_ubicacion = ubicacion;
        this.usuario_privacidad = privacidad;
        this.usuario_albums = new AlbumList();
        this.usuario_amigos = new AmigoList();
    }
 
    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    public String getUsuario_username() {
        return usuario_username;
    }

    public void setUsuario_username(String usuario_username) {
        this.usuario_username = usuario_username;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_apellido() {
        return usuario_apellido;
    }

    public void setUsuario_apellido(String usuario_apellido) {
        this.usuario_apellido = usuario_apellido;
    }

    public String getUsuario_email() {
        return usuario_email;
    }

    public void setUsuario_email(String usuario_email) {
        this.usuario_email = usuario_email;
    }

    public Date getUsuario_fecha_nacimiento() {
        return usuario_fecha_nacimiento;
    }

    public void setUsuario_fecha_nacimiento(Date usuario_fecha_nacimiento) {
        this.usuario_fecha_nacimiento = usuario_fecha_nacimiento;
    }

    public String getUsuario_ubicacion() {
        return usuario_ubicacion;
    }

    public void setUsuario_ubicacion(String usuario_ubicacion) {
        this.usuario_ubicacion = usuario_ubicacion;
    }

    public String getUsuario_privacidad() {
        return usuario_privacidad;
    }

    public void setUsuario_privacidad(String usuario_privacidad) {
        this.usuario_privacidad = usuario_privacidad;
    }

    public AlbumList getUsuario_albums() {
        return usuario_albums;
    }

    public void setUsuario_albums(AlbumList usuario_albums) {
        this.usuario_albums = usuario_albums;
    }

    public AmigoList getUsuario_amigos() {
        return usuario_amigos;
    }

    public void setUsuario_amigos(AmigoList usuario_amigos) {
        this.usuario_amigos = usuario_amigos;
    }
    
    
}
