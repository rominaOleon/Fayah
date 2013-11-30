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
import negocio.Notificacion;
import util.Util;

/**
 *
 * @author romina
 */
public class AlbumDAOSQL extends Object implements AlbumDAO {

    @Override
    public void insertarAlbum(Album album) {
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
            
            Connection connection2 = ConexionBaseDeDatos.getConnection();
            
            String querySelect = "SELECT last_value fk FROM album_album_id_seq";
            int fk_id=0;      
            Statement stSelect = connection2.createStatement();
            ResultSet rsSelect = stSelect.executeQuery(querySelect);
            
            while (rsSelect.next()) {
                fk_id = Integer.parseInt(rsSelect.getString("fk"));
            }
            
            Date date = new Date();
            DateFormat formatofecha = new SimpleDateFormat("mm/dd/yyy");
            String fecha = formatofecha.format(date);
            
            Notificacion notificacion = new Notificacion(fecha,"album",fk_id);
            NotificacionDAO notificaciondao = new NotificacionDAOSQL();
            notificaciondao.insertarNotificacion(notificacion);            
            
            stSelect.close();
            rsSelect.close();
            
            
            
            ConexionBaseDeDatos.closeConnection(connection2);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

       

    }

    @Override
    public void modificarAlbum(Album album) {
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

    @Override
    public Album consultarAlbum(int id) {

            String idString = String.valueOf(id);
            
            
        Album album = null;
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "SELECT * FROM album WHERE album_id="
                    + idString;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

       
            String nombre = "";
            String descripcion = "";
            String privacidad = "";
            String fecha = "";
            String miniatura ="";
            int    likes = 0;
            int    dislikes = 0;
            int    fk_usuario = 0;
            
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("album_id"));
                nombre = rs.getString("album_nombre");
                descripcion = rs.getString("album_descripcion");
                privacidad = rs.getString("album_privacidad");
                fecha = rs.getString("album_fecha_creacion");
                likes = Integer.parseInt(rs.getString("album_likes"));
                dislikes = Integer.parseInt(rs.getString("album_dislikes"));
                fk_usuario = Integer.parseInt(rs.getString("fk_usuario_id"));
                miniatura = rs.getString("album_miniatura");
                
            }
            rs.close();
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
            album = new Album(id, nombre, descripcion, privacidad, fecha, likes,
                    dislikes,miniatura, fk_usuario);
            return album;
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return album;
    }
    
}
