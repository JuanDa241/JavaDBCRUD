/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author admin
 */
public class Procesador {
    private String nombre;
    private String fabricante;
    private String gama;
    private String frecuencia;
    private String gpu;
    private String construccion_proceso_nanometros;
    private String generacion_tecnologica_redes;

    public Procesador() {
    }

    public Procesador(String nombre, String fabricante, String gama, String frecuencia, String gpu, String construccion_proceso_nanometros, String generacion_tecnologica_redes) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.gama = gama;
        this.frecuencia = frecuencia;
        this.gpu = gpu;
        this.construccion_proceso_nanometros = construccion_proceso_nanometros;
        this.generacion_tecnologica_redes = generacion_tecnologica_redes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getGama() {
        return gama;
    }

    public void setGama(String gama) {
        this.gama = gama;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getConstruccion_proceso_nanometros() {
        return construccion_proceso_nanometros;
    }

    public void setConstruccion_proceso_nanometros(String construccion_proceso_nanometros) {
        this.construccion_proceso_nanometros = construccion_proceso_nanometros;
    }

    public String getGeneracion_tecnologica_redes() {
        return generacion_tecnologica_redes;
    }

    public void setGeneracion_tecnologica_redes(String generacion_tecnologica_redes) {
        this.generacion_tecnologica_redes = generacion_tecnologica_redes;
    }

    @Override
    public String toString() {
        return "Procesador{" + "nombre=" + nombre + ", fabricante=" + fabricante + ", gama=" + gama + ", frecuencia=" + frecuencia + ", gpu=" + gpu + ", construccion_proceso_nanometros=" + construccion_proceso_nanometros + ", generacion_tecnologica_redes=" + generacion_tecnologica_redes + '}';
    }

    
    
    
}
