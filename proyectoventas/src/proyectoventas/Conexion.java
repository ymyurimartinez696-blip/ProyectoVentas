package proyectoventas; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection conectar() {
        try {
            // Asegúrate de que tu base de datos se llame bd_ventas
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_ventas", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexión local: " + e.getMessage());
            return null;
        }
    }
}