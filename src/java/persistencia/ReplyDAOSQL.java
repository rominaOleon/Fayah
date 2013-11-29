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
import negocio.Comentario;
import negocio.ComentarioList;
import negocio.Notificacion;
import negocio.Reply;

/**
 *
 * @author romina
 */
public class ReplyDAOSQL extends Object implements ReplyDAO {

    @Override
    public void insertarReply(Reply reply) {
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            String fecha = reply.getReply_fecha();
            String fk_comentario1 = String.valueOf(reply.getFk_comentario1_id());
            String fk_comentario2 = String.valueOf(reply.getFk_comentario2_id());
            
            String query = "INSERT INTO reply VALUES (nextval('reply_reply_id_seq'),"
                    + fk_comentario1 + ","
                    + fk_comentario2 + ")";
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            
            String querySelect = "SELECT last_value FROM reply_reply_id_seq";
            int fk_id=0;      
            Statement stSelect = connection.createStatement();
            ResultSet rsSelect = st.executeQuery(querySelect);
            
            while (rsSelect.next()) {
                fk_id = Integer.parseInt(rsSelect.getString("reply_id"));
            }
            
            Date date = new Date();
            DateFormat formatofecha = new SimpleDateFormat("mm/dd/yyy");
            String fechaNotificacion = formatofecha.format(date);
            
            Notificacion notificacion = new Notificacion(fechaNotificacion,"reply",fk_id);
            NotificacionDAO notificaciondao = new NotificacionDAOSQL();
            notificaciondao.insertarNotificacion(notificacion);            
            
            stSelect.close();
            rsSelect.close();
            
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(LikeDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ComentarioList traerReplys(Comentario comentario) {
        
         
        ComentarioList comentariosReplys = new ComentarioList();
               
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            
            int comentarioId = comentario.getComentario_id();
            String idString = String.valueOf(comentarioId);
            
            String query = "SELECT c.* FROM comentario c, reply r where "
                    +"r.fk_comentario1_id="+idString+" and "
                    +"r.fk_comentario2_id = c.comentario_id";
            
                    
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            int idComentario;
            String fecha;
            int likes;
            int dislikes;
            String show;
            int fk_usuario;
            int fk_album;
            String texto;

            
            while (rs.next()) {
                idComentario  = Integer.parseInt(rs.getString("comentario_id"));
                fecha = rs.getString("comentario_fecha");
                likes = Integer.parseInt(rs.getString("comentario_likes"));
                dislikes = Integer.parseInt(rs.getString("comentario_dislikes"));
                show = rs.getString("comentario_show");
                fk_usuario = Integer.parseInt(rs.getString("fk_usuario_id"));
                fk_album = Integer.parseInt(rs.getString("fk_album_id"));
                texto = rs.getString("comentario_texto");
                Comentario reply = new Comentario (idComentario,fecha,likes,dislikes,show,fk_usuario,fk_album,texto);
                comentariosReplys.addComentario(reply);
            }
            st.close();
            rs.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentariosReplys;
        
    }
    
}
