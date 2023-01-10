package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar {
        String dbServer = "204.2.63.32"; 
        int dbPort = 10242; 
        String dbName = "maingco";
        String userName = "pipe";
        String password = "12345678";
        String url = String.format("jdbc:mysql://%s:%d?user=%s&password=%s" , 
                                    dbServer, dbPort, userName, password);
    Connection connection = null;

    public  Connection Conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(url);;
            Statement stmt = connection.createStatement();
            String sqlusedb = "use " + dbName;
            int result = stmt.executeUpdate(sqlusedb);
            if (connection != null) {
                //System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            return connection;
    }

   
    public void desconectar() {
        try {
            connection.close();
        } catch (Exception ex) {
        }
    }

}
