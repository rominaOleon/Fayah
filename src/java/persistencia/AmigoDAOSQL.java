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
import negocio.Amigo;
import negocio.Notificacion;

/**
 *
 * @author romina
 */

public class AmigoDAOSQL extends Object implements AmigoDAO {

    @Override
    public void insertarAmigo(Amigo amigo) {
        try {        
            System.out.println("Insertando amistad: "
                    +amigo.getAmigo_fkusuario1()+" y "
                    +amigo.getAmigo_fkusuario2()+"...");
            Connection connection = ConexionBaseDeDatos.getConnection();
            int fkusuario1 = amigo.getAmigo_fkusuario1();
            String fk_usuario1 = "";
            fk_usuario1 = String.valueOf(fkusuario1);
            int fkusuario2 = amigo.getAmigo_fkusuario2();
            String fk_usuario2 = "";
            fk_usuario2 = String.valueOf(fkusuario2);
            String query = "INSERT INTO amigo VALUES (nextval('amigo_amigo_id_seq'),"
                    + fk_usuario1 + ","
                    + fk_usuario2 + ")";
            Statement st = connection.createStatement();
            int rs = st.executeUpdate(query);
            st.close();
            System.out.println("Se ha insertado la amistad: "
                    +amigo.getAmigo_fkusuario1()+" y "
                    +amigo.getAmigo_fkusuario2());
            ConexionBaseDeDatos.closeConnection(connection);
            Connection connectionFk = ConexionBaseDeDatos.getConnection();
            String querySelect = "SELECT last_value fk FROM amigo_amigo_id_seq";
            int fk_id=0;      
            Statement stSelect = connectionFk.createStatement();
            ResultSet rsSelect = stSelect.executeQuery(querySelect);
           while (rsSelect.next()) {
                fk_id = Integer.parseInt(rsSelect.getString("fk"));
            }
            Date date = new Date();
            DateFormat formatofecha = new SimpleDateFormat("mm/dd/yyy");
            String fecha = formatofecha.format(date);
            Notificacion notificacion = new Notificacion(fecha,"amigo",fk_id);
            NotificacionDAO notificaciondao = new NotificacionDAOSQL();
            notificaciondao.insertarNotificacion(notificacion);            
            stSelect.close();
            rsSelect.close();
            ConexionBaseDeDatos.closeConnection(connectionFk);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar insertar"
                    +" la amistad: "+amigo.getAmigo_fkusuario1()+" y "
                    +amigo.getAmigo_fkusuario2()+". Error: "+ex.getMessage()); 
        }
    }

    @Override
    public void modificarAmigo(Amigo amigo) {
        
    }

    @Override
    public boolean sonAmigos(int usuarioId, int amigoId) {
        System.out.println("Consultando existencia de amistad entre: "
                +usuarioId+" y "+amigoId+"...");
        boolean sonAmigos=false;
        try {        
            Connection connection = ConexionBaseDeDatos.getConnection();
            String idUsuario = String.valueOf(usuarioId);
            String idAmigo = String.valueOf(amigoId);
            int fk_usuario1=0;
            int fk_usuario2=0;
            String query = "SELECT * FROM amigo WHERE fk_usuario1_id="
                    +idUsuario+" or fk_usuario2_id="+idUsuario;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                fk_usuario1 = Integer.parseInt(rs.getString("fk_usuario1_id"));
                fk_usuario2 = Integer.parseInt(rs.getString("fk_usuario2_id"));
                if (fk_usuario1!=usuarioId){
                    if (fk_usuario1==amigoId)
                        sonAmigos = true;
                } else{
                    if (fk_usuario2==amigoId)
                        sonAmigos = true;
                }
     }
            rs.close();
            st.close();
            System.out.println("Se ha consultado la existencia de la amistad: "
                    +usuarioId+" y "+amigoId);
            ConexionBaseDeDatos.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar verificar la"
                    +" amistad entre: "+usuarioId+" y "+amigoId
                    +". Error: "+ex.getMessage());    
        }
        return sonAmigos;
    }

    @Override
    public Amigo consultarAmigo(int id) {
        System.out.println("Consultando la amistad: "+id+"...");
        String idString = String.valueOf(id);
        Amigo amigo = null;
        try {
            Connection connection = ConexionBaseDeDatos.getConnection();
            String query = "SELECT * FROM amigo WHERE amigo_id="
                    + idString;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int fk_usuario1 = 0;
            int fk_usuario2 =0;
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("amigo_id"));
                fk_usuario1 = Integer.parseInt(rs.getString("fk_usuario1_id"));
                fk_usuario2 = Integer.parseInt(rs.getString("fk_usuario2_id")); 
            }
            rs.close();
            st.close();
            ConexionBaseDeDatos.closeConnection(connection);
            System.out.println("Se ha consultado la amistad entre: "
                    +fk_usuario1+" y "+fk_usuario2);
            amigo = new Amigo(id,fk_usuario1,fk_usuario2);
            return amigo;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOSQL.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Ocurrio un error de SQL al intentar consultar"
                    +" la amistad: "+id+". Error: "+ex.getMessage());    
        }
        return amigo;
    }
}
