/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Simple extends Pieza{
    private static double PRECIO_BASE = 100.0;
    private static final String FOTO = "[foto de una pieza simple]";

    public Simple(String numeroPieza) {
        super(numeroPieza);
    }
    
    @Override
    public double getPrecio(){
        return PRECIO_BASE;
    }
    
    @Override
    public String getTipo(){
        return "Simple";
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
