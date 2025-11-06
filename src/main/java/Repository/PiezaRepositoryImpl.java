/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author johan
 */
public class PiezaRepositoryImpl implements IPiezaRepository{
    private List<Pieza> piezasDelHotel = new ArrayList<>();

    public PiezaRepositoryImpl() {
        piezasDelHotel.add(new Simple("101"));
        piezasDelHotel.add(new Simple("102"));
        piezasDelHotel.add(new Simple("103"));
        piezasDelHotel.add(new Doble("201"));
        piezasDelHotel.add(new Doble("202"));
        piezasDelHotel.add(new Matrimonial("301"));
    }
    
    @Override
    public List<Pieza> findDisponiblesByTipo(String tipo){
        return piezasDelHotel.stream()
                .filter(p -> !p.isOcupada())
                .filter(p -> p.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

    @Override
    public Pieza findByNumero(String numeroPieza){
        return piezasDelHotel.stream()
                .filter(p -> p.getNumeroPieza().equals(numeroPieza))
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public void update(Pieza pieza){}
}
