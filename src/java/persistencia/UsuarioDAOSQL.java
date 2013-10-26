/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AlbumList;
import modelo.AmigoList;
import modelo.Usuario;

/**
 *
 * @author romina
 */
public class UsuarioDAOSQL extends Object implements UsuarioDAO {

    @Override
    public void InsertarUsuario(Usuario usuario) {
        try {
            Date fecha_nacimiento = usuario.getUsuario_fecha_nacimiento();
            SimpleDateFormat formatofecha = new SimpleDateFormat("DD/MM/YYYY");
            String fecha_nacimiento_string = formatofecha.format(fecha_nacimiento);

            Connection connection = ConexionBaseDeDatos.getConnection();

            String query = "INSERT INTO usuario VALUES (nextval(usuario_usuario_id_seq),'"
                    + usuario.getUsuario_username() + "','"
                    + usuario.getUsuario_nombre() + "','"
                    + usuario.getUsuario_apellido() + "','"
                    + usuario.getUsuario_email() + "','"
                    + fecha_nacimiento_string + "','"
                    + usuario.getUsuario_ubicacion() + "','"
                    + usuario.getUsuario_privacidad() + "')";

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
