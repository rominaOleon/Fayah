/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Amigo;

/**
 *
 * @author romina
 */
public class AmigoDAOSQL extends Object implements AmigoDAO {

    @Override
    public void InsertarAmigo(Amigo amigo) {
        try {        
            Connection connection = ConexionBaseDeDatos.getConnection();
            
            int idamigo = amigo.getAmigo_id();
            String id = "";
            id = String.valueOf(idamigo);
            
            int fkusuario1 = amigo.getAmigo();
            String fk_usuario1 = "";
            fk_usuario1 = String.valueOf(fkusuario1);
            
            int fkusuario2 = amigo.getAmigo_usuario();
            String fk_usuario2 = "";
            fk_usuario2 = String.valueOf(fkusuario2);
            

            String query = "INSERT INTO amigo VALUES (nextval('amigo_amigo_id_seq'),"
                    + id + ","
                    + fk_usuario1 + ","
                    + fk_usuario2 + ")";
            
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
          
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @Override
    public void ModificarAmigo(Amigo amigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
