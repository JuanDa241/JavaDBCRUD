/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import Entidades.Procesador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProcesadorDAO {
    
    private Conexion conexion = new Conexion();
    
    public boolean agregarProcesador(Procesador procesador) throws SQLException{
        
        boolean fueAgregar = false;
        Connection conn = conexion.conectar();
        try {
            String sql= "INSERT INTO procesadores VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, procesador.getNombre());
            stmt.setString(2, procesador.getFabricante());
            stmt.setString(3, procesador.getGama());
            stmt.setString(4, procesador.getFrecuencia());
            stmt.setString(5, procesador.getGpu());
            stmt.setString(6, procesador.getConstruccion_proceso_nanometros());
            stmt.setString(7, procesador.getGeneracion_tecnologica_redes());
            
            int cantidad = stmt.executeUpdate();
            
            fueAgregar = (cantidad > 0);
            
         }catch(Exception e){
            System.out.println("Error al agregar el procesador"+ e.getMessage());
        }finally{
            conn.close();
        }
        return fueAgregar;
    }
    
     public ArrayList<Procesador> listadoProcesadores() throws SQLException{
        ArrayList<Procesador> procesadores = new ArrayList<>();
        Connection conn = conexion.conectar();
        
        try{
            String sql = "SELECT*FROM procesadores";
            PreparedStatement stmt = conn.prepareStatement (sql);
            ResultSet result = stmt.executeQuery();
            
            while(result.next()){
                Procesador t = new Procesador();
                t.setNombre(result.getString("nombre"));
                t.setFabricante(result.getString("fabricante"));
                t.setGama (result.getString("gama"));
                t.setFrecuencia (result.getString("frecuencia"));
                t.setGpu(result.getString("gpu"));
                t.setConstruccion_proceso_nanometros(result.getString("construcción_nm"));
                t.setGeneracion_tecnologica_redes(result.getString("generacion_redes"));
                
                procesadores.add(t);
            }
        }catch (Exception e){
            System.out.println("Error al generar el listado"+e.getMessage());
        }finally {
            conn.close();
        }
        return procesadores;
     }
     
      public ArrayList<Procesador> buscarPorNombre(String nombre) throws SQLException{
        ArrayList<Procesador> procesadores = new ArrayList<>();
        Connection conn = conexion.conectar();
        
        try{
            String sql = "SELECT * FROM procesadores WHERE nombre=?";
            PreparedStatement stmt = conn.prepareStatement (sql);
            stmt.setString(1, nombre);
            ResultSet result = stmt.executeQuery();
            
            while(result.next()){
                Procesador t = new Procesador();
                t.setNombre(result.getString("nombre"));
                t.setFabricante(result.getString("fabricante"));
                t.setGama (result.getString("gama"));
                t.setFrecuencia (result.getString("frecuencia"));
                t.setGpu(result.getString("gpu"));
                t.setConstruccion_proceso_nanometros(result.getString("construccion_nm"));
                t.setGeneracion_tecnologica_redes(result.getString("generacion_redes"));
                procesadores.add(t);
            }
        }catch (Exception e){
            System.out.println("error al buscar el procesador"+e.getMessage());
        }finally {
            conn.close();
        }
        return procesadores;
    }
      
        public boolean eliminarProcesador(String nombre) throws SQLException{
        boolean fueEliminado = false;
        Connection conn = conexion.conectar();
        
        try{
            String sql = "DELETE FROM procesadores WHERE nombre = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombre);
            
            fueEliminado = (stmt.executeUpdate() > 0 );
        }catch (Exception e){
            System.out.println("Error al eliminar el Procesador: "+e.getMessage());
        }finally{
            conn.close();
        }
        return fueEliminado;
    }
        
   public boolean actualizarProcesador(Procesador procesador) throws SQLException{
       boolean fueActualizado = false;

       Connection conn = conexion.conectar();

       try{
           String sql = "UPDATE procesadores SET nombre=?,fabricante=?,gama=?,frecuencia=?,gpu=?,construcción_nm=?,generacion_redes=? WHERE nombre=?";
           PreparedStatement stmt = conn.prepareCall(sql);
            stmt.setString(1, procesador.getNombre());
            stmt.setString(2, procesador.getFabricante());
            stmt.setString(3, procesador.getGama());
            stmt.setString(4, procesador.getFrecuencia());
            stmt.setString(5, procesador.getGpu());
            stmt.setString(6, procesador.getConstruccion_proceso_nanometros());
            stmt.setString(7, procesador.getGeneracion_tecnologica_redes());
             stmt.setString(8, procesador.getNombre());

            int cantidad = stmt.executeUpdate();
            fueActualizado = (cantidad > 0);

       }catch (Exception e){
            System.out.println("Error al actualizar el procesador " +e.getMessage());
        }finally{
            conn.close();
        }
     return fueActualizado;
   }
}
