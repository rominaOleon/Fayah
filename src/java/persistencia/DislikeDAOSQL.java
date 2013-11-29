/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Album;
import negocio.Dislike;
import negocio.DislikeList;
import negocio.Notificacion;

/**
 *
 * @author romina
 */
public class DislikeDAOSQL extends Object implements DislikeDAO {

    @Override
    public void insertarDislike(Dislike dislike) {
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            int fk_usuario = dislike.getFk_usuario_id();
            String fk_usuario_id = String.valueOf(fk_usuario);
            int fk_album = dislike.getFk_album_id();
            String fk_album_id = String.valueOf(fk_album);
            String query = "INSERT INTO dislikes VALUES (nextval('dislikes_dislikes_id_seq'),"
                    + fk_album_id + ","
                    + fk_usuario_id + ")";
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            
            String querySelect = "SELECT last_value FROM dislikes_dislikes_id_seq";
            int fk_id=0;      
            Statement stSelect = connection.createStatement();
            ResultSet rsSelect = st.executeQuery(querySelect);
            
            while (rsSelect.next()) {
                fk_id = Integer.parseInt(rsSelect.getString("dislikes_id"));
            }
            
            Date date = new Date();
            DateFormat formatofecha = new SimpleDateFormat("mm/dd/yyy");
            String fechaNotificacion = formatofecha.format(date);
            
            Notificacion notificacion = new Notificacion(fechaNotificacion,"dislike",fk_id);
            NotificacionDAO notificaciondao = new NotificacionDAOSQL();
            notificaciondao.insertarNotificacion(notificacion);            
            
            stSelect.close();
            rsSelect.close();
            
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(DislikeDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DislikeList traerDislikes(Album album) {
        
         
        DislikeList dislikes = new DislikeList();
               
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            
            
            int albumId = album.getAlbum_id();
            String idString = String.valueOf(albumId);
            
            
            String query = "SELECT * FROM dislikes WHERE fk_album_id="
                    + idString;
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
        
        
            int idDislike;
            int fk_album;
            int fk_usuario;
            
            while (rs.next()) {
                idDislike  = Integer.parseInt(rs.getString("dislikes_id"));
                fk_album = Integer.parseInt(rs.getString("fk_album_id"));
                fk_usuario = Integer.parseInt(rs.getString("fk_usuario_id"));
                Dislike dislike = new Dislike (idDislike,fk_album,fk_usuario);
                dislikes.addDislike(dislike);
            }
            st.close();
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dislikes;
        
        
    }
    
}
