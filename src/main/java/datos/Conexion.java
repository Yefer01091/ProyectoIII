/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * 
 * @author Sergio Enrique Jair Gonzalez Arcos>
 */
public class Conexion {
 private static final String url = "jdbc:postgresql://localhost:5432/estudiantesdb?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
private static final String user = "postgres";
private static final String password = "123";

public static DataSource  getDataSource(){
    BasicDataSource ds = new BasicDataSource();
    ds.setUrl(url);
    ds.setUsername(user);
    ds.setPassword(password);
    ds.setInitialSize(50);
    
    return ds;
}

public static Connection  getConnection() throws SQLException {
return  getDataSource().getConnection();
}

public static void close (ResultSet rs){
     try {
         rs.close();
     } catch (SQLException ex) {
         ex.printStackTrace(System.out);
     }
}


public  static void close (PreparedStatement stmt){
     try {
         stmt.close();
     } catch (SQLException ex) {
         ex.printStackTrace(System.out);
     }

}

    public static void close (Connection conn) {
     try {
         conn.close();
     } catch (SQLException ex) {
          ex.printStackTrace(System.out);
     }
        
    }
}

 


