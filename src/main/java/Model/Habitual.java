/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Habitual extends Cliente {
    private static double DESCUENTO = 0.15;

    public Habitual(String rut, String nombre) {
        super(rut, nombre);
    }
    
    //polimorfismo
    @Override
    public double getDescuentoAplicable(){
        return DESCUENTO;
    }
    
    public static void setDescuentoGlobal(double nuevoDescuento){
        DESCUENTO = nuevoDescuento;
    }
    
    public static double getDescuentoGlobal(){
        return DESCUENTO;
    }
}
