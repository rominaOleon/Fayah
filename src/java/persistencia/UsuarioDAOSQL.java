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

/**
 *
 * @author romina
 */
public class UsuarioDAOSQL extends Object implements UsuarioDAO {

    @Override
    public void InsertarUsuario(Usuario usuario) {
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
    public Usuario ConsultarUsuario(String email) {
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

            usuario = new Usuario (id,username,nombre,apellido,email,fecha_nacimiento,
                    ubicacion,privacidad,foto);
            
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    return usuario;
    }

    @Override
    public void ModificarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    /*
    *Metodo que trae de la base de datos los amigos de un usuario.
    *@return null si el usuario no posee amigos. 
    *amigos (AmigoList) la lista de amigos
    */
    public AmigoList TraerAmigos(Usuario usuario) {
        AmigoList amigos = null;
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

            int idamigo = 0;
            int fkamigo1 = 0;
            int fkamigo2 = 0;

            while (rs.next()) {
                idamigo = Integer.parseInt(rs.getString("amigo_id"));
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
    public AlbumList TraerAlbums(Usuario usuario) {
               AlbumList albums = null;
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
            String nombre ="";
            String descripcion = "";
            String privacidad = "";
            String fecha = "";
            int likes =0;
            int dislikes =0;

            while (rs.next()) {
                idalbum = Integer.parseInt(rs.getString("album_id"));
                nombre = rs.getString("album_nombre");
                descripcion = rs.getString("album_descripcion");
                privacidad = rs.getString("album_privacidad");
                fecha = rs.getString("album_fecha_creacion");
                likes = Integer.parseInt(rs.getString("album_likes"));
                dislikes = Integer.parseInt(rs.getString("album_dislikes"));

                Album album = new Album(idalbum, nombre, descripcion,privacidad,fecha,likes,dislikes);
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
    /*            
     *  Verifica la existencia de un usuario en la base de datos.
     * @return int id si el usuario existe. 0 si el usuario no existe.
     */
    public int UsuarioExiste(String email) {
        int id = 0;
        if (email!=null){
            if (email.compareTo("")!=0){
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
    
}
