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
            System.out.println("Insertando reply de comentario...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            String fecha = reply.getReply_fecha();
            String fk_comentario1 = String.valueOf(reply.getFk_comentario1_id());
            String fk_comentario2 = String.valueOf(reply.getFk_comentario2_id());
            
            String query = "INSERT INTO reply VALUES (nextval('reply_reply_id_seq'),'"
                    + fecha +"',"
                    + fk_comentario1 + ","
                    + fk_comentario2 + ")";
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
            System.out.println("Se ha insertado un reply de comentario.");
            
            Connection connection2 = ConexionBaseDeDatos.getConnection();
            
           
            
            String querySelect = "SELECT last_value fk FROM reply_reply_id_seq";
            int fk_id=0;      
            Statement stSelect = connection2.createStatement();
            ResultSet rsSelect = stSelect.executeQuery(querySelect);
            
            while (rsSelect.next()) {
                fk_id = Integer.parseInt(rsSelect.getString("fk"));
            }
            
            Date date = new Date();
            DateFormat formatofecha = new SimpleDateFormat("mm/dd/yyyy");
            String fechaNotificacion = formatofecha.format(date);
            
            Notificacion notificacion = new Notificacion(fechaNotificacion,"reply",fk_id);
            NotificacionDAO notificaciondao = new NotificacionDAOSQL();
            notificaciondao.insertarNotificacion(notificacion);            
            
            stSelect.close();
            rsSelect.close();
            
            ConexionBaseDeDatos.closeConnection(connection2);
        } catch (SQLException ex) {
            Logger.getLogger(LikeDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar insertar el reply"
                    +". Error: "+ex.getMessage());
        }
    }

    @Override
    public ComentarioList traerReplys(Comentario comentario) {
        
         
        ComentarioList comentariosReplys = new ComentarioList();
               
        try {
            System.out.println("Consultando replys del comentario: "+comentario.getComentario_id()+"...");
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
            System.out.println("Se han cargado las respuestas al comentario: "+comentario.getComentario_id());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar consultar los replys"
                    +". Error: "+ex.getMessage());    
        }
        return comentariosReplys;
        
    }
    
}


// System.out.println("Consultando replys del comentario: "+comentario.getComentario_id()+"...");
//    System.out.println("Se han cargado las respuestas al comentario: "+comentario.getComentario_id());
//    System.err.println("Ocurrio un error de SQL al intentar consultar los replys.");    
//    System.out.println("Insertando la notificacion de reply...");
//    System.out.println("Se ha insertado la notificacion de reply");
