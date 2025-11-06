/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Model.*;
import Repository.*;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author johan
 */
public class HotelService {
    private final IClienteRepository clienteRepo;
    private final IPiezaRepository piezaRepo;
    private final IReservacionRepository reservacionRepo;

    public HotelService(IClienteRepository clienteRepo, IPiezaRepository piezaRepo, IReservacionRepository reservacionRepo) {
        this.clienteRepo = clienteRepo;
        this.piezaRepo = piezaRepo;
        this.reservacionRepo = reservacionRepo;
    }
    
    public List<Pieza> getPiezasDisponibles(String tipo){
        return piezaRepo.findDisponiblesByTipo(tipo);
    }
    
    public double getPrecioPieza(String tipo){
        return Pieza.getPrecioBase(tipo);
    }
    
    public double getDescuentoHabitual(String tipo){
        return Habitual.getDescuentoGlobal();
    }
    
    public double consultarPrecioTotal(String rut, String tipoPieza, int noches){
        Cliente cliente = clienteRepo.findByRut(rut);
        double precioNoche = Pieza.getPrecioBase(tipoPieza);
        
        double descuento = cliente.getDescuentoAplicable();
        
        return (precioNoche * noches) * (1 - descuento);
    }
    
    public void dibujarFotoPieza(String tipo){
        if(tipo.equalsIgnoreCase("simple")) new Simple("temp").dibujarFoto();
        else if(tipo.equalsIgnoreCase("doble")) new Doble("temp").dibujarFoto();
        else if(tipo.equalsIgnoreCase("Matrimonial")) new Matrimonial("temp").dibujarFoto();
    }
    
    public boolean reservarPieza(String tipoPieza, String rut, String nombre, int dias){
        List<Pieza> disponibles = piezaRepo.findDisponiblesByTipo(tipoPieza);
        if(disponibles.isEmpty()){
            return false;
        }
        
        Pieza piezaAReservar = disponibles.get(0);
        Cliente cliente = clienteRepo.findByRut(rut);
        
        if(cliente instanceof Esporadico){
            cliente.setNombre(nombre);
        }
        
        Reservacion nuevaReservacion = new Reservacion(LocalDate.now(), dias, cliente, piezaAReservar);
        
        piezaAReservar.setOcupada(true);
        piezaRepo.update(piezaAReservar);
        
        reservacionRepo.save(nuevaReservacion);
        return true;
    }
    
    public boolean eliminarReservacion(String numeroPieza){
        Reservacion reserva = reservacionRepo.findByNumeroPieza(numeroPieza);
        if(reserva == null){
            return false;
        }
        
        Pieza piezaLiberada = reserva.getPieza();
        piezaLiberada.setOcupada(false);
        piezaRepo.update(piezaLiberada);
        
        reservacionRepo.deleteByNumeroPieza(numeroPieza);
        return true;
    }
    
    public void cambiarPrecioPieza(String tipo, double nuevoPrecio){
        Pieza.setPrecioBase(tipo, nuevoPrecio);
    }
    
    public void cambiarDescuentoHabitua(double nuevoDescuento){
        Habitual.setDescuentoGlobal(nuevoDescuento);
    }
    
    public double calcularGananciasMes(int mes){
        double ganancias = 0.0;
        List<Reservacion> todas = reservacionRepo.findAll();
        
        for(Reservacion r : todas){
            if(r.getFechaInicio().getMonthValue() == mes){
                ganancias += r.getCostoTotal();
            }
        }
        return ganancias;
    }
}
