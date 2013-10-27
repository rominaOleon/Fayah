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
import negocio.Album;
import util.Util;

/**
 *
 * @author romina
 */
public class AlbumDAOSQL extends Object implements AlbumDAO {

    @Override
    public void InsertarAlbum(Album album) {
           try {        
            Connection connection = ConexionBaseDeDatos.getConnection();
            
            int albumlikes = album.getAlbum_likes();
            String likes = "";
            likes = String.valueOf(albumlikes);
            
            int albumdislikes = album.getAlbum_dislikes();
            String dislikes = "";
            dislikes = String.valueOf(albumdislikes);
            
            int fk = Util.usuario.getUsuario_id();
            String fkdueño = "";
            fkdueño = String.valueOf(fk);


            String query = "INSERT INTO album VALUES (nextval('album_album_id_seq'),'"
                    + album.getAlbum_nombre() + "','"
                    + album.getAlbum_descripcion() + "','"
                    + album.getAlbum_privacidad() + "','"
                    + album.getAlbum_fecha_creacion() + "',"
                    + likes + ","
                    + dislikes + ","
                    + fkdueño + ", '"
                    + album.getAlbum_miniatura() + "')";
            



            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
          
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

       

    }

    @Override
    public void ModificarAlbum(Album album) {
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            
            int albumid = album.getAlbum_id();
            String id = "";
            id = String.valueOf(albumid);
            
            int albumlikes = album.getAlbum_likes();
            String likes = "";
            likes = String.valueOf(albumlikes);
            
            int albumdislikes = album.getAlbum_dislikes();
            String dislikes = "";
            dislikes = String.valueOf(albumdislikes);
       

            String query = "UPDATE album SET "
            + "album_nombre='" + album.getAlbum_nombre() +"', "
            + "album_descripcion='" + album.getAlbum_descripcion() + "', "
            + "album_privacidad='" + album.getAlbum_privacidad() + "', "
            + "album_fecha_creacion='" + album.getAlbum_fecha_creacion() +"', "
            + "album_likes=" + likes + ", "
            + "album_dislikes=" + dislikes + ", "
            + "album_miniatura='" + album.getAlbum_miniatura() + "' " 
            + "WHERE album_id=" + id;
           
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);

            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
