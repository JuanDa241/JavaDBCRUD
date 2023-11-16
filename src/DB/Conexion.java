/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private Connection conexion;
    private String host = "localhost";
    private String usuario = "root";
    private String password = "";
    private String nombreBD = "procesadores_moviles";
    private String url = "jdbc:mysql://"+host+"/"+nombreBD;
    
     public Connection conectar(){ 
        try{
            this.conexion = DriverManager.getConnection(this.url, this.usuario, this.password);
            System.out.println("Exito al conectar a la base de datos");
        }catch(Exception e){
            System.out.println("Error al intentar conectar a la base de datos"+ e.getMessage());
        }
        return this.conexion;
        
    }

}
