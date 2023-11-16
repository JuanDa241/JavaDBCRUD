/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procesador_movil;

import DB.Conexion;
import DB.ProcesadorDAO;
import Entidades.Procesador;

public class procesadores {
    
     public static void main (String[]args) {
        Entidades.Procesador p = new Entidades.Procesador("Snapdragon", "Qualcomm", "Alta", "3,0 GHz", "Adreno 730", "4nm", "5G");
        
        ProcesadorDAO pdao = new ProcesadorDAO();
         try {
             if(pdao.agregarProcesador(p)){
                 System.out.println("Se agrego correctamente el procesador");
             }
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     } 
}
