/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author isaia
 */
public class Computador {
    private String TipoTeclado;
    private String Marca;
    private String CPUModelo;
    private int RamCantidad;
    private String TamanoPantalla;
    private String GPUNombre;
    private String TipoAlmacenamiento;
    private int CantidadMemoriaGB;
    public Computador(int RamCantidad,int CantidadMemoriaGB)
    {
    this.RamCantidad= RamCantidad;
    this.CantidadMemoriaGB=CantidadMemoriaGB;
    }
    public Computador()
    {
    }
    public Computador(String TipoTeclado, String Marca, String CPUModelo, String TamanoPantalla, String GPUNombre, String TipoAlmacenamiento){
    this.CPUModelo=CPUModelo;
    this.TipoTeclado=TipoTeclado;
    this.Marca=Marca;
    this.GPUNombre=GPUNombre;
    this.TipoAlmacenamiento=TipoAlmacenamiento;
    this.TamanoPantalla=TamanoPantalla; 
    }
    public void setTipoTeclado(String TipoTeclado) {
        this.TipoTeclado = TipoTeclado;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setCPUModelo(String CPUModelo) {
        this.CPUModelo = CPUModelo;
    }

    public void setRamCantidad(int RamCantidad) {
        this.RamCantidad = RamCantidad;
    }

    public void setTamanoPantalla(String TamanoPantalla) {
        this.TamanoPantalla = TamanoPantalla;
    }

    public void setGPUNombre(String GPUNombre) {
        this.GPUNombre = GPUNombre;
    }

    public void setTipoAlmacenamiento(String TipoAlmacenamiento) {
        this.TipoAlmacenamiento = TipoAlmacenamiento;
    }

    public void setCantidadMemoriaGB(int CantidadMemoriaGB) {
        this.CantidadMemoriaGB = CantidadMemoriaGB;
    }

    public String getTipoTeclado() {
        return TipoTeclado;
    }

    public String getMarca() {
        return Marca;
    }

    public String getCPUModelo() {
        return CPUModelo;
    }

    public int getRamCantidad() {
        return RamCantidad;
    }

    public String getTamanoPantalla() {
        return TamanoPantalla;
    }

    public String getGPUNombre() {
        return GPUNombre;
    }

    public String getTipoAlmacenamiento() {
        return TipoAlmacenamiento;
    }

    public int getCantidadMemoriaGB() {
        return CantidadMemoriaGB;
    }

    @Override
    public String toString() {
        return "Computador{" + "TipoTeclado=" + TipoTeclado + ", Marca=" + Marca + ", CPUModelo=" + CPUModelo + ", RamCantidad=" + RamCantidad + ", TamanoPantalla=" + TamanoPantalla + ", GPUNombre=" + GPUNombre + ", TipoAlmacenamiento=" + TipoAlmacenamiento + ", CantidadMemoriaGB=" + CantidadMemoriaGB + '}';
    }
    
    
}
