/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.Pieza;
import java.util.List;

/**
 *
 * @author johan
 */
public interface IPiezaRepository {
    List<Pieza> findDisponiblesByTipo(String tipo);
    Pieza findByNumero(String numeroPieza);
    void update(Pieza pieza);
}
