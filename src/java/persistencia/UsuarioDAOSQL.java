/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Album;
import negocio.AlbumList;
import negocio.Amigo;
import negocio.AmigoList;
import negocio.Usuario;
import negocio.UsuariosList;

/**
 *
 * @author romina
 */
public class UsuarioDAOSQL extends Object implements UsuarioDAO {

    @Override
    public void insertarUsuario(Usuario usuario) {
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "INSERT INTO usuario VALUES (nextval('usuario_usuario_id_seq'),'"
                    + usuario.getUsuario_username() + "','"
                    + usuario.getUsuario_nombre() + "','"
                    + usuario.getUsuario_apellido() + "','"
                    + usuario.getUsuario_email() + "','"
                    + usuario.getUsuario_fecha_nacimiento() + "','"
                    + usuario.getUsuario_ubicacion() + "','"
                    + usuario.getUsuario_privacidad() + "','"
                    + usuario.getUsuario_foto() + "')";
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Usuario consultarUsuario(int id) {
        
            String idString = "";
            idString = String.valueOf(id);
            
        Usuario usuario = null;
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "SELECT * FROM usuario WHERE usuario_id="
                    + idString;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            String username = "";
            String nombre = "";
            String apellido = "";
            String fecha_nacimiento = "";
            String ubicacion = "";
            String privacidad = "";
            String foto = "";
            String email = "";
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("usuario_id"));
                username = rs.getString("usuario_username");
                nombre = rs.getString("usuario_nombre");
                apellido = rs.getString("usuario_apellido");
                email = rs.getString("usuario_email");
                fecha_nacimiento = rs.getString("usuario_fecha_nacimiento");
                ubicacion = rs.getString("usuario_ubicacion");
                privacidad = rs.getString("usuario_privacidad");
                foto = rs.getString("usuario_foto");
            }
            rs.close();
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
            usuario = new Usuario(id, username, nombre, apellido, email, fecha_nacimiento,
                    ubicacion, privacidad, foto);
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    @Override
    public Usuario consultarUsuario(String email) {
        Usuario usuario = null;
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "SELECT * FROM usuario WHERE usuario_email='"
                    + email + "'";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String username = "";
            String nombre = "";
            String apellido = "";
            String fecha_nacimiento = "";
            String ubicacion = "";
            String privacidad = "";
            String foto = "";
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("usuario_id"));
                username = rs.getString("usuario_username");
                nombre = rs.getString("usuario_nombre");
                apellido = rs.getString("usuario_apellido");
                fecha_nacimiento = rs.getString("usuario_fecha_nacimiento");
                ubicacion = rs.getString("usuario_ubicacion");
                privacidad = rs.getString("usuario_privacidad");
                foto = rs.getString("usuario_foto");
            }
            rs.close();
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
            usuario = new Usuario(id, username, nombre, apellido, email, fecha_nacimiento,
                    ubicacion, privacidad, foto);
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }


    @Override
    public void modificarUsuario(Usuario usuario) {
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            int id = usuario.getUsuario_id();
            String idString = "";
            idString = String.valueOf(id);
            String query = "UPDATE usuario SET "
                    + "usuario_username='" + usuario.getUsuario_username() + "', "
                    + "usuario_nombre='" + usuario.getUsuario_nombre() + "', "
                    + "usuario_apellido='" + usuario.getUsuario_apellido() + "', "
                    + "usuario_fecha_nacimiento='" + usuario.getUsuario_fecha_nacimiento() + "', "
                    + "usuario_ubicacion='" + usuario.getUsuario_ubicacion() + "', "
                    + "usuario_privacidad='" + usuario.getUsuario_privacidad() + "' "
                    + "WHERE usuario_id=" + idString;
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public AmigoList traerAmigos(Usuario usuario) {
        AmigoList amigos = new AmigoList();
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            int id = usuario.getUsuario_id();
            String idString = "";
            idString = String.valueOf(id);
            String query = "SELECT * FROM amigo WHERE fk_usuario1_id="
                    + idString + " OR fk_usuario2_id="
                    + idString;
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int idamigo;
            int fkamigo1;
            int fkamigo2;
            while (rs.next()) {
                idamigo  = Integer.parseInt(rs.getString("amigo_id"));
                fkamigo1 = Integer.parseInt(rs.getString("fk_usuario1_id"));
                fkamigo2 = Integer.parseInt(rs.getString("fk_usuario2_id"));
                
                Amigo amigo = new Amigo(idamigo, fkamigo1, fkamigo2);
                amigos.addAmigo(amigo);
            }
            st.close();
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amigos;
    }

    @Override
       public AlbumList traerAlbums(Usuario usuario) {
        AlbumList albums = new AlbumList();
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            int id = usuario.getUsuario_id();
            String idString = "";
            idString = String.valueOf(id);
            String query = "SELECT * FROM album WHERE fk_usuario_id="
                    + idString;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int idalbum = 0;
            String nombre = "";
            String descripcion = "";
            String privacidad = "";
            String fecha = "";
            int likes = 0;
            int dislikes = 0;
            String miniatura ="";
            while (rs.next()) {
                idalbum = Integer.parseInt(rs.getString("album_id"));
                nombre = rs.getString("album_nombre");
                descripcion = rs.getString("album_descripcion");
                privacidad = rs.getString("album_privacidad");
                fecha = rs.getString("album_fecha_creacion");
                likes = Integer.parseInt(rs.getString("album_likes"));
                dislikes = Integer.parseInt(rs.getString("album_dislikes"));
                miniatura = rs.getString("album_miniatura");
                Album album = new Album(idalbum, nombre, descripcion, privacidad, fecha, likes, dislikes,miniatura);
                albums.addAlbum(album);
            }
            st.close();
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return albums;
    }

    @Override
    public int usuarioExiste(String email) {
        int id = 0;
        if (email != null) {
            if (email.compareTo("") != 0) {
                try {
                    Connection connection = ConexionBaseDeDatos.getConnection();
                    String query = "SELECT usuario_id FROM usuario WHERE usuario_email='"
                            + email + "'";
                    Statement st = connection.createStatement();
                    ResultSet rs = st.executeQuery(query);
                    while (rs.next()) {
                        id = Integer.parseInt(rs.getString("usuario_id"));
                    }
                    rs.close();
                    st.close();
                    ConexionBaseDeDatos.closeConnection(connection);
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return id;
    }

    @Override
    public UsuariosList buscarUsuario(String busqueda) {
        
        UsuariosList usuarios= new UsuariosList();

        try {
    
        Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "SELECT * FROM usuario WHERE lower(usuario_nombre ||"
           +" ' ' || usuario_apellido) LIKE ('%"+busqueda+"%')";
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String username = "";
            String nombreusuario = "";
            String apellidousuario = "";
            String email = "";
            String fecha_nacimiento = "";
            String ubicacion = "";
            String privacidad = "";
            String foto = "";
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("usuario_id"));
                username = rs.getString("usuario_username");
                nombreusuario = rs.getString("usuario_nombre");
                apellidousuario = rs.getString("usuario_apellido");
                email = rs.getString("usuario_email");
                fecha_nacimiento = rs.getString("usuario_fecha_nacimiento");
                ubicacion = rs.getString("usuario_ubicacion");
                privacidad = rs.getString("usuario_privacidad");
                foto = rs.getString("usuario_foto");
       
                Usuario usuario = new Usuario(id, username, nombreusuario, apellidousuario, email, fecha_nacimiento,ubicacion, privacidad, foto);

            usuarios.addUsuario(usuario);
                
            }
            rs.close();
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }
}
