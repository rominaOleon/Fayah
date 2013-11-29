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
import negocio.Comentario;
import negocio.ComentarioList;
import negocio.Notificacion;

/**
 *
 * @author romina
 */
public class ComentarioDAOSQL extends Object implements ComentarioDAO  {

    @Override
    public void insertarComentario(Comentario comentario) {
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            
            String fecha = comentario.getComentario_fecha();
            int likes = comentario.getComentario_likes();
            String comentario_likes = String.valueOf(likes);
            int dislikes = comentario.getComentario_dislikes();
            String comentario_dislikes = String.valueOf(dislikes);
            String show = comentario.getComentario_show();
            int fk_usuario = comentario.getFk_usuario_id();
            String fk_usuario_id = String.valueOf(fk_usuario);
            int fk_album = comentario.getFk_album_id();
            String fk_album_id = String.valueOf(fk_album);
            String texto = comentario.getComentario_texto();
            
        
            String query = "INSERT INTO comentario VALUES (nextval('comentario_comentario_id_seq'),'"
                    + fecha + "',"
                    + comentario_likes + ","
                    + comentario_dislikes + ",'"
                    + show + "',"
                    + fk_usuario_id + ","
                    + fk_album_id +",'"
                    + texto +"')";
                   
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            
            String querySelect = "SELECT last_value FROM comentario_comentario_id_seq";
            int fk_id=0;      
            Statement stSelect = connection.createStatement();
            ResultSet rsSelect = st.executeQuery(querySelect);
            
            while (rsSelect.next()) {
                fk_id = Integer.parseInt(rsSelect.getString("comentario_id"));
            }
            
            Date date = new Date();
            DateFormat formatofecha = new SimpleDateFormat("mm/dd/yyy");
            String fechaNotificacion = formatofecha.format(date);
            
            Notificacion notificacion = new Notificacion(fechaNotificacion,"comentario",fk_id);
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
    public ComentarioList traerComentarios(Album album) {
        
        ComentarioList comentarios = new ComentarioList();        
               
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            int albumId = album.getAlbum_id();
            String idString = String.valueOf(albumId);
            
            String query = "SELECT * FROM comentario WHERE fk_album_id="
                    + idString;
            
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int idcomentario;
            String fecha;
            int likes;
            int dislikes;
            String show;
            int fk_usuario;
            int fk_album;
            String texto;
            while (rs.next()) {
                idcomentario  = Integer.parseInt(rs.getString("comentario_id"));
                fecha = rs.getString("comentario_fecha");
                likes = Integer.parseInt(rs.getString("comentario_likes"));
                dislikes = Integer.parseInt(rs.getString("comentario_dislikes"));
                show = rs.getString("comentario_show");
                fk_usuario = Integer.parseInt(rs.getString("fk_usuario_id"));
                fk_album = Integer.parseInt(rs.getString("fk_album_id"));
                texto = rs.getString("comentario_texto");
                Comentario comentario = new Comentario (idcomentario,fecha,likes,dislikes,show,fk_usuario,fk_album,texto);
                comentarios.addComentario(comentario);
            }
            st.close();
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentarios;
        
    }

    @Override
    public void modificarComentario(Comentario comentario) {
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            String idComentario = String.valueOf(comentario.getComentario_id());
            String likes = String.valueOf(comentario.getComentario_likes());
            String dislikes = String.valueOf(comentario.getComentario_dislikes());
            String show = comentario.getComentario_show();

            String query = "UPDATE comentario SET "
                    + "comentario_likes=" + likes + ", "
                    + "comentario_dislikes=" + dislikes + ", "
                    + "comentario_show='" + show + "' "
                    + "WHERE comentario_id=" + idComentario;


            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarComentario(Comentario comentario) {

        try {
            Connection connection = ConexionBaseDeDatos.getConnection();

            String idComentario = String.valueOf(comentario.getComentario_id());


            String query = "DELETE FROM contenido WHERE contenido_id="
                    + idComentario;
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
