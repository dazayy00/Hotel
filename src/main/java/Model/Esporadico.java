/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public class Esporadico extends Cliente{

    public Esporadico(String rut, String nombre) {
        super(rut, nombre);
    }
    
    //polimorfismo
    @Override
    public double getDescuentoAplicable(){
        return 0.0;
    }
}
