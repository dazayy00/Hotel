/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Reservacion;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author johan
 */
public class ReservacionRepositoryImpl implements IReservacionRepository{
    private List<Reservacion> reservacionesBD = new ArrayList<>();
    
    @Override
    public void save(Reservacion reservacion){
        reservacionesBD.add(reservacion);
    }
    
    @Override
    public Reservacion findByNumeroPieza(String numeroPieza){
        return reservacionesBD.stream()
                .filter(r -> r.getPieza().getNumeroPieza().equals(numeroPieza))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public void deleteByNumeroPieza(String numeroPieza){
        reservacionesBD.removeIf(r -> r.getPieza().getNumeroPieza().equals(numeroPieza));
    }
    
    @Override
    public List<Reservacion> findAll(){
        return new ArrayList<>(reservacionesBD);
    }
}
