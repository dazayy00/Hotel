/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Matrimonial extends Pieza{
    private static double PRECIO_BASE = 101.0;
    private static final String FOTO = "[foto de una pieza matrimonial]";

    public Matrimonial(String numeroPieza) {
        super(numeroPieza);
    }
    
    @Override
    public double getPrecio(){
        return PRECIO_BASE;
    }
    
    @Override
    public String getTipo(){
        return "Matrimonial";
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
