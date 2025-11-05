/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author johan
 */
public abstract class Cliente {
    private String rut;
    private String nombre;

    public Cliente(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }
    
    //abstraccion
    public abstract double getDescuentoAplicable();

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
