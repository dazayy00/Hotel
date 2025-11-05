/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author johan
 */
public class Reservacion {
    private LocalDate fechaInicio;
    private int cantidadDias;
    private Cliente cliente;
    private Pieza pieza;

    public Reservacion(LocalDate fechaInicio, int cantidadDias, Cliente cliente, Pieza pieza) {
        this.fechaInicio = fechaInicio;
        this.cantidadDias = cantidadDias;
        this.cliente = cliente;
        this.pieza = pieza;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public int getCantidadDias() {
        return cantidadDias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pieza getPieza() {
        return pieza;
    }
    
    public double getCostoTotal(){
        double precioNoche = pieza.getPrecio();
        double descuento = cliente.getDescuentoAplicable();
        return (precioNoche * cantidadDias) * (1 - descuento);
    }
}
