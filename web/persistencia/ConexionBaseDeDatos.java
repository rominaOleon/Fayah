/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;   
import java.sql.DriverManager;   
import java.sql.ResultSet;
import java.sql.SQLException;   
import java.sql.Statement;

/**
 *
 * @author romina
 */
public class ConexionBaseDeDatos {
    
private static final String DRIVER_BD = "org.postgresql.Driver";   
private static final String URL_BD = "jdbc:postgresql://ec2-107-22-186-169.compute-1.amazonaws.com:5432/d9is36sj7ndbtt?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
private static final String USERNAME_BD = "xpiahmvxfxfbyl";   
private static final String PASSWORD_BD = "gGcD-MWZelTL_PS4uzNFKBFN0T"; 

public static Connection getConnection() throws SQLException{   
    try {
        Class.forName(DRIVER_BD);
    } catch (ClassNotFoundException ex) {
        System.out.println("Driver no encontrado.");
        return null;
    }

    Connection connection = DriverManager.getConnection(URL_BD, USERNAME_BD, PASSWORD_BD);

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
