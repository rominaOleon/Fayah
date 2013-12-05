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
import negocio.Notificacion;
import negocio.NotificacionList;
import negocio.Usuario;
/**
 *
 * @author romina
 */
public class NotificacionDAOSQL extends Object implements NotificacionDAO {
    
    @Override
    public void insertarNotificacion(Notificacion notificacion) {
        try {   
            System.out.println("Insertando notificacion de: "+notificacion.getNotificacion_tipo()+"...");
            Connection connection = ConexionBaseDeDatos.getConnection();        
            int fk_amigo = notificacion.getFk_amigo_id();
            String fk_amigo_id = "null";
            int fk_comentario = notificacion.getFk_comentario_id();
            String fk_comentario_id = "null";
            int fk_reply = notificacion.getFk_reply_id();
            String fk_reply_id = "null";
            int fk_like = notificacion.getFk_like_id();
            String fk_like_id = "null";
            int fk_dislike = notificacion.getFk_dislike_id();
            String fk_dislike_id = "null";
            int fk_album = notificacion.getFk_album_id();
            String fk_album_id = "null";
            
            
            if (fk_amigo!=0)
                fk_amigo_id = String.valueOf(fk_amigo);
                     
            if (fk_comentario!=0)
                fk_comentario_id = String.valueOf(fk_comentario);
            
            if (fk_reply!=0)
                fk_reply_id = String.valueOf(fk_reply);
            
            if (fk_like!=0)
                fk_like_id = String.valueOf(fk_like);
                    
            if (fk_dislike!=0)
                fk_dislike_id = String.valueOf(fk_dislike);
            
            if (fk_album!=0)
                fk_album_id = String.valueOf(fk_album);
            
            String query = "INSERT INTO notificacion VALUES (nextval('notificacion_notificacion_id_seq'),'"
                    + notificacion.getNotificacion_fecha() + "','"
                    + notificacion.getNotificacion_tipo() + "',"
                    + fk_amigo_id + ","
                    + fk_comentario_id + ","
                    + fk_reply_id + ","
                    + fk_like_id + ","
                    + fk_dislike_id + ","
                    + fk_album_id + ")";
            
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            System.out.println("Se ha Insertado una notificacion de: "+notificacion.getNotificacion_tipo());
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar insertar la"
                    +" notificacion de: "+notificacion.getNotificacion_tipo()
                    +". Error: "+ex.getMessage());    
        }

    }

    @Override
    public NotificacionList traerNotificaciones(Usuario usuario) {

        NotificacionList notificaciones = new NotificacionList();
        try {
            
            System.out.println("Consultando las notificaciones del usuario: "
                    +usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido()+"...");
            Connection connection = ConexionBaseDeDatos.getConnection();

            int id = usuario.getUsuario_id();
            String idString = "";
            idString = String.valueOf(id);
            
            String query = "SELECT distinct(n.notificacion_id), n.notificacion_fecha,"
            +" n.notificacion_tipo, n.fk_amigo_id, n.fk_comentario_id, n.fk_reply_id, "
            +"n.fk_like_id, n.fk_dislike_id, n.fk_album_id from notificacion n,"
            +" amigo am, album al, comentario co, likes li, dislikes dis where "
            +"(n.fk_amigo_id = am.amigo_id) and (am.fk_usuario1_id in (select"
            +" usuario_id from usuario where (usuario_id in (select fk_usuario1_id"
            +" from amigo where fk_usuario1_id="+idString
            +" or fk_usuario2_id="+idString+") or "
            +"usuario_id in (select fk_usuario2_id from amigo where "
            +"fk_usuario1_id="+idString+" or fk_usuario2_id="+idString
            +")) and usuario_id<>"+idString+") "
            +"or am.fk_usuario2_id in (select usuario_id from usuario where "
            +"(usuario_id in (select fk_usuario1_id from amigo where "
            +"fk_usuario1_id="+idString+" or fk_usuario2_id="+idString
            +") or usuario_id in "
            +"(select fk_usuario2_id from amigo where fk_usuario1_id="+idString
            +" or fk_usuario2_id="+idString+")) and usuario_id<>"+idString+")) or "
            +"((n.fk_album_id = al.album_id) and (al.fk_usuario_id in "
            +"(select usuario_id from usuario where (usuario_id in (select "
            +"fk_usuario1_id from amigo where fk_usuario1_id="+idString+" or "
            +"fk_usuario2_id="+idString+") or usuario_id in (select fk_usuario2_id from "
            +"amigo where fk_usuario1_id="+idString+" or fk_usuario2_id="+idString+")) and "
            +"usuario_id<>"+idString+"))) or ((n.fk_comentario_id = co.comentario_id) "
            +"and (co.fk_usuario_id in (select usuario_id from usuario where "
            +"(usuario_id in (select fk_usuario1_id from amigo where "
            +"fk_usuario1_id="+idString+" or fk_usuario2_id="+idString+") or usuario_id in "
            +"(select fk_usuario2_id from amigo where fk_usuario1_id="+idString+" "
            +"or fk_usuario2_id="+idString+")) and usuario_id<>"+idString+"))) or "
            +"((n.fk_like_id = li.likes_id) and (li.fk_usuario_id in "
            +"(select usuario_id from usuario where (usuario_id in "
            +"(select fk_usuario1_id from amigo where fk_usuario1_id="+idString+" or "
            +"fk_usuario2_id="+idString+") or usuario_id in (select fk_usuario2_id "
            +"from amigo where fk_usuario1_id="+idString+" or fk_usuario2_id="+idString+")) and "
            +"usuario_id<>"+idString+"))) or ((n.fk_dislike_id = dis.dislikes_id) and "
            +"(dis.fk_usuario_id in (select usuario_id from usuario where "
            +"(usuario_id in (select fk_usuario1_id from amigo where "
            +"fk_usuario1_id="+idString+" or fk_usuario2_id="+idString+") or usuario_id in "
            +"(select fk_usuario2_id from amigo where fk_usuario1_id="+idString+" "
            +"or fk_usuario2_id="+idString+")) and usuario_id<>"+idString+")))"
            +" order by n.notificacion_id desc";
            
                
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int idNotificacion = 0;
            String fecha = "";
            String tipo = "";
            int fk_activa = 0;



            while (rs.next()) {
                idNotificacion = Integer.parseInt(rs.getString("notificacion_id"));
                fecha = rs.getString("notificacion_fecha");
                tipo = rs.getString("notificacion_tipo");

                if (tipo.compareTo("amigo") == 0) {
                    fk_activa = Integer.parseInt(rs.getString("fk_amigo_id"));
                }

                if (tipo.compareTo("comentario") == 0) {
                    fk_activa = Integer.parseInt(rs.getString("fk_comentario_id"));
                }

                if (tipo.compareTo("reply") == 0) {
                    fk_activa = Integer.parseInt(rs.getString("fk_reply_id"));
                }

                if (tipo.compareTo("like") == 0) {
                    fk_activa = Integer.parseInt(rs.getString("fk_like_id"));
                }

                if (tipo.compareTo("dislike") == 0) {
                    fk_activa = Integer.parseInt(rs.getString("fk_dislike_id"));
                }

                if (tipo.compareTo("album") == 0) {
                    fk_activa = Integer.parseInt(rs.getString("fk_album_id"));
                }

                Notificacion notificacion = new Notificacion(idNotificacion, fecha, tipo, fk_activa);
                notificaciones.addNotificacion(notificacion);
            }
            st.close();
            rs.close();
            connection.close();
            System.out.println("Se han cargado las notificaciones del usuario: "
                    +usuario.getUsuario_nombre()+" "+usuario.getUsuario_apellido());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar consultar"+
                    " las notificaciones del usuario: "+usuario.getUsuario_nombre()
                    +" "+usuario.getUsuario_apellido()+". Error: "+ex.getMessage());
        }
        return notificaciones;
    }
}
