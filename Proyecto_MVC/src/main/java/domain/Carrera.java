/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 * Clase que representa la tabla carreras.
 * @author isaia
 */
public class Carrera {

    private int car_codigo;
    private String car_nombre;
    private String car_status;

    // Constructor vacío
    public Carrera() {
    }

    // Constructor solo con ID
    public Carrera(int car_codigo) {
        this.car_codigo = car_codigo;
    }

    // Constructor sin ID (para insert)
    public Carrera(String car_nombre, String car_status) {
        this.car_nombre = car_nombre;
        this.car_status = car_status;
    }

    // Constructor completo
    public Carrera(int car_codigo, String car_nombre, String car_status) {
        this.car_codigo = car_codigo;
        this.car_nombre = car_nombre;
        this.car_status = car_status;
    }

    // Getters y Setters

    public int getCar_codigo() {
        return car_codigo;
    }

    public void setCar_codigo(int car_codigo) {
        this.car_codigo = car_codigo;
    }

    public String getCar_nombre() {
        return car_nombre;
    }

    public void setCar_nombre(String car_nombre) {
        this.car_nombre = car_nombre;
    }

    public String getCar_status() {
        return car_status;
    }

    public void setCar_estatus(String car_status) {
        this.car_status = car_status;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "car_codigo=" + car_codigo +
                ", car_nombre=" + car_nombre +
                ", car_estatus=" + car_status +
                '}';
    }
}