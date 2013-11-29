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
import negocio.Contenido;
import negocio.ContenidoList;

/**
 *delete from contenido where contenido_id=1;

 * @author romina
 */
public class ContenidoDAOSQL extends Object implements ContenidoDAO {

    @Override
    public void insertarContenido(Contenido contenido) {
        
         try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            
            String fk_album = String.valueOf(contenido.getContenido_id());
            String query = "INSERT INTO contenido VALUES (nextval('contenido_contenido_id_seq'),'"
                    + contenido.getContenido_url() + "',"
                    + fk_album + ")";
            
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ContenidoList traerContenidos(Album album) {
        
        ContenidoList contenidos = new ContenidoList();
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            String idAlbum = String.valueOf(album.getAlbum_id());
            
            String query = "SELECT * FROM contenido WHERE fk_album_id="
                    + idAlbum;
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int idContenido;
            String url;
            int fk_album;
            
            while (rs.next()) {
                idContenido  = Integer.parseInt(rs.getString("contenido_id"));
                url = rs.getString("contenido_url");
                fk_album = Integer.parseInt(rs.getString("fk_album_id"));
                
                Contenido contenido = new Contenido (idContenido,url,fk_album);
                contenidos.addContenido(contenido);
            }
            st.close();
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contenidos;
    }

    @Override
    public void modificarContenido(Contenido contenido) {
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            //delete from contenido where contenido_id=1;
            String idContenido = String.valueOf(contenido.getContenido_id());
            
            String query = "DELETE FROM contenido WHERE contenido_id="
                    + idContenido;
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
