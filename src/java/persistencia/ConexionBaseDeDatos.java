/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;


import java.sql.Connection;   
import java.sql.DriverManager;   
import java.sql.SQLException;   
import util.Util;


/**
 *
 * @author romina
 */
public class ConexionBaseDeDatos {
    


public static Connection getConnection() throws SQLException{   
    try {
        Class.forName(Util.DRIVER_BD);
    } catch (ClassNotFoundException ex) {
        System.out.println("Driver no encontrado.");
        return null;
    }

    Connection connection = DriverManager.getConnection(Util.URL_BD, Util.USERNAME_BD, Util.PASSWORD_BD);

    return connection;
   } 

public static void closeConnection (Connection connection){
    
      try {
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
}
