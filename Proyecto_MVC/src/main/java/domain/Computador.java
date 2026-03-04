/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Angel R
 */
public class Computador {
   private String software;
   private String marca;
   private int memoria;

    public Computador(int memoria) {
        this.memoria = memoria;
    }

    public Computador(String software, String marca) {
        this.software = software;
        this.marca = marca;
    }

    public Computador(){
        
    }
    

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    public String getmarca() {
        return marca;
    }

    public void setHardware(String Hardware) {
        this.marca = Hardware;
    }
   
}
