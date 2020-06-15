/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jacob
 */
public class Conexion {
     //Datos de la conexión
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION ="jdbc:mysql://localhost:3306/dbProducts";
    private static final String DB_USER="root";
    private static final String DB_PASSWORD ="";
    private static Connection DBCONNECTION = null;
    
    //Metodo para obtener la conexión 
    public static Connection GetConnection(){
        try{
            Class.forName(DB_DRIVER);
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        try{
            DBCONNECTION = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
        }catch(SQLException ex){
             System.out.println(ex.getMessage());
        }
        return DBCONNECTION;
    }
    
}
