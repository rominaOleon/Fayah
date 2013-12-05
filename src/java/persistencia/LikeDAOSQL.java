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
import negocio.Like;
import negocio.LikeList;
import negocio.Notificacion;

/**
 *
 * @author romina
 */

public class LikeDAOSQL extends Object implements LikeDAO {

    @Override
    public void insertarLike(Like like) {
        try {
            System.out.println("Insertando like del album: "+like.getFk_album_id()+"...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            int fk_usuario = like.getFk_usuario_id();
            String fk_usuario_id = String.valueOf(fk_usuario);
            int fk_album = like.getFk_album_id();
            String fk_album_id = String.valueOf(fk_album);
            String query = "INSERT INTO likes VALUES (nextval('likes_likes_id_seq'),"
                    + fk_album_id + ","
                    + fk_usuario_id + ")";
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
            
            System.out.println("Se ha insertado el like del album: "+like.getFk_album_id());
            
            Connection connectionFk = ConexionBaseDeDatos.getConnection();
            
            
            String querySelect = "SELECT last_value fk FROM likes_likes_id_seq";
            int fk_id=0;      
            Statement stSelect = connectionFk.createStatement();
            ResultSet rsSelect = stSelect.executeQuery(querySelect);
            
            while (rsSelect.next()) {
                fk_id = Integer.parseInt(rsSelect.getString("fk"));
            }
            
            Date date = new Date();
            DateFormat formatofecha = new SimpleDateFormat("mm/dd/yyyy");
            String fechaNotificacion = formatofecha.format(date);
            
            Notificacion notificacion = new Notificacion(fechaNotificacion,"like",fk_id);
            NotificacionDAO notificaciondao = new NotificacionDAOSQL();
            notificaciondao.insertarNotificacion(notificacion);            
            
            stSelect.close();
            rsSelect.close();
            
            
            ConexionBaseDeDatos.closeConnection(connectionFk);
        } catch (SQLException ex) {
            Logger.getLogger(LikeDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar insertar el like del album: "
                    +like.getFk_album_id());    
        }
    }

    @Override
    public LikeList traerlikes(Album album) {
        
        LikeList likes = new LikeList();
               
        try {
            System.out.println("Consultando likes del album: "+album.getAlbum_nombre()+"...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            int albumId = album.getAlbum_id();
            String idString = String.valueOf(albumId);
            String query = "SELECT * FROM likes WHERE fk_album_id="
                    + idString;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int idLike;
            int fk_album;
            int fk_usuario;
            while (rs.next()) {
                idLike  = Integer.parseInt(rs.getString("likes_id"));
                fk_album = Integer.parseInt(rs.getString("fk_album_id"));
                fk_usuario = Integer.parseInt(rs.getString("fk_usuario_id"));
                Like like = new Like (idLike,fk_album,fk_usuario);
                likes.addLike(like);
            }
            st.close();
            rs.close();
            connection.close();
            System.out.println("Se han cargado los likes del album: "+album.getAlbum_nombre());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar consultar los likes"
                    +" del album: "+album.getAlbum_nombre());    
        }
        return likes;
    }

    @Override
    public Like consultarLike(int id) {
        String idString = String.valueOf(id);
        Like like = null;
        try {
            System.out.println("Consultando el like: "+id+"...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "SELECT * FROM likes WHERE likes_id="
                    + idString;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int fk_usuario = 0;
            int fk_album =0;
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("likes_id"));
                fk_album = Integer.parseInt(rs.getString("fk_album_id"));
                fk_usuario = Integer.parseInt(rs.getString("fk_usuario_id")); 
            }
            rs.close();
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
            like = new Like(id,fk_album,fk_usuario);
            System.out.println("Se ha cargado la informacion del like: "+id);
            return like;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar consultar "
                    +"el like: "+id+". Error: "+ex.getMessage());   
        }         
        return like;
      
    }
    
}
