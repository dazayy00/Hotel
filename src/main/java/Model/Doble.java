/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Doble extends Pieza{
    private static double PRECIO_BASE = 99.0;
    private static final String FOTO = "[foto de una pieza doble]";

    public Doble(String numeroPieza) {
        super(numeroPieza);
    }
    
    @Override
    public double getPrecio(){
        return PRECIO_BASE;
    }
    
    @Override
    public String getTipo(){
        return "Doble";
    }
    
    @Override
    public void dibujarFoto(){
        System.out.println(FOTO);
    }
    
    public static void setPrecioBase(double precio){
        PRECIO_BASE = precio;
    }
    
    public static double getPrecioBase(){
        return PRECIO_BASE;
    }
}
