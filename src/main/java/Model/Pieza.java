/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public abstract class Pieza {
    private String numeroPieza;
    private boolean ocupada;

    public Pieza(String numeroPieza) {
        this.numeroPieza = numeroPieza;
        this.ocupada = false;
    }
    
    //abstraccion
    public abstract double getPrecio();
    public abstract String getTipo();
    public abstract void dibujarFoto();

    public String getNumeroPieza() {
        return numeroPieza;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    public static void setPrecioBase(String tipo, double precio){
        switch(tipo.toLowerCase()){
            case "simple": Simple.setPrecioBase(precio); break;
            case "doble": Doble.setPrecioBase(precio); break;
            case "matrimonial": Matrimonial.setPrecioBase(precio); break;
        }
    }
    
    public static double getPrecioBase(String tipo){
        switch(tipo.toLowerCase()){
            case "simple": return Simple.getPrecioBase();
            case "doble": return Doble.getPrecioBase();
            case "matrimonial": return Matrimonial.getPrecioBase();
            default: return 0.0;
        }
    }
}
