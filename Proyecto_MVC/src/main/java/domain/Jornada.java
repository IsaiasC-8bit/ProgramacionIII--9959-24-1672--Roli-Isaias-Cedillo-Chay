/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author isaia
 */
public class Jornada {
   private int jor_codigo;
    private String jor_nombre;

    // Constructor vacío
    public Jornada() {
    }

    // Constructor solo con ID
    public Jornada(int jor_codigo) {
        this.jor_codigo = jor_codigo;
    }

    // Constructor sin ID (para insert)
    public Jornada(String jor_nombre) {
        this.jor_nombre = jor_nombre;
    }

    // Constructor completo
    public Jornada(int jor_codigo, String jor_nombre) {
        this.jor_codigo = jor_codigo;
        this.jor_nombre = jor_nombre;
    }

    // Getters y Setters

    public int getjor_codigo() {
        return jor_codigo;
    }

    public void setjor_codigo(int jor_codigo) {
        this.jor_codigo = jor_codigo;
    }

    public String getjor_nombre() {
        return jor_nombre;
    }

    public void setjor_nombre(String jor_nombre) {
        this.jor_nombre = jor_nombre;
    }

 
    @Override
    public String toString() {
        return "Jornada{" +
                "jor_codigo=" + jor_codigo +
                ", jor_nombre=" + jor_nombre +
                '}';
    }  
}
