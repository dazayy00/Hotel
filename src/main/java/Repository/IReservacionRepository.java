/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.Reservacion;
import java.util.List;

/**
 *
 * @author johan
 */
public interface IReservacionRepository {
    void save(Reservacion resrvacion);
    Reservacion findByNumeroPieza(String numeroPieza);
    void deleteByNumeroPieza(String numeroPieza);
    List<Reservacion> findAll();
}
