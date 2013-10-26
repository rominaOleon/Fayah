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
import negocio.AlbumList;
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
                    + usuario.getUsuario_privacidad() + "')";

            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            connection.commit();
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

            while (rs.next()) {
                id = Integer.parseInt(rs.getString("usuario_id"));
                username = rs.getString("usuario_username");
                nombre = rs.getString("usuario_nombre");
                apellido = rs.getString("usuario_apellido");
                fecha_nacimiento = rs.getString("usuario_fecha_nacimiento");
                ubicacion = rs.getString("usuario_ubicacion");
                privacidad = rs.getString("usuario_privacidad");
            }
            rs.close();
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);

            usuario = new Usuario (id,username,nombre,apellido,email,fecha_nacimiento,
                    ubicacion,privacidad);
            
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
    public AmigoList TraerAmigos(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AlbumList TraerAlbums(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int UsuarioExiste(String email) {
        int id = 0;
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

        return id;
    }
    
}
