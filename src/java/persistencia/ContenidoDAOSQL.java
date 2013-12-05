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
 *
 * @author romina
 */

public class ContenidoDAOSQL extends Object implements ContenidoDAO {

    @Override
    public void insertarContenido(Contenido contenido) {
        System.out.println("Insertando contenido en el album: "+contenido.getFk_album_id()+"...");
         try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            String fk_album = String.valueOf(contenido.getFk_album_id());
            String query = "INSERT INTO contenido VALUES (nextval('contenido_contenido_id_seq'),'"
                    + contenido.getContenido_url() + "',"
                    + fk_album + ")";
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            System.out.println("Se ha insertado el contenido en el album: "+contenido.getFk_album_id());
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar insertar el"
                    +" contenido en el album: "+contenido.getFk_album_id()+
                    ". Error: "+ex.getMessage());    
        }
    }

    @Override
    public ContenidoList traerContenidos(Album album) {
        System.out.println("Consultando el contenido del album: "+album.getAlbum_nombre()+"...");
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
            System.out.println("Se ha cargado el contenido del album: "+album.getAlbum_nombre());
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar consultar "
                    +"el contenido del album: "+album.getAlbum_nombre()
                    +". Error: "+ex.getMessage());    
        }
        return contenidos;
    }

    @Override
    public void eliminarContenido(Contenido contenido) {
        try {
            System.out.println("Eliminando el contenido: "+contenido.getContenido_id()+"...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            //delete from contenido where contenido_id=1;
            String idContenido = String.valueOf(contenido.getContenido_id());
            String query = "DELETE FROM contenido WHERE contenido_id="
                    + idContenido;
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            System.out.println("Se ha eliminado el contenido: "
                    +contenido.getContenido_id()+" del album: "
                    +contenido.getFk_album_id());
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar eliminar el"
                    +" contenido: "+contenido.getContenido_id()+" del album: "
                    +contenido.getFk_album_id()+". Error: "+ex.getMessage());    
        }
    }

    @Override
    public Contenido consultarContenido(int id) {
        System.out.println("Consultando el contenido: "+id+"...");
        String idString = String.valueOf(id);
        Contenido contenido = null;
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "SELECT * FROM contenido WHERE contenido_id="
                    + idString;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String url = "";
            int    fk_album = 0;
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("contenido_id"));
                url = rs.getString("contenido_url");
                fk_album = Integer.parseInt(rs.getString("fk_album_id"));
                
            }
            rs.close();
            st.close();
            System.out.println("Se ha consultado la informacion del contenido: "
                    +contenido.getContenido_url());
            ConexionBaseDeDatos.closeConnection(connection);
            contenido = new Contenido(id, url, fk_album);
            return contenido;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar consultar "
                    +"la informacion del contenido: "+id+". Error: "+ex.getMessage());    
        }
        return contenido;
    }
}
