/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Angel R
 */
public class Empresa {
    
    int codigoEmpresa;
    String nombreEmpresa;

    public Empresa(int codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Empresa(int codigoEmpresa, String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(int codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" + "codigoEmpresa=" + codigoEmpresa + ", nombreEmpresa=" + nombreEmpresa + '}';
    }
    
}
