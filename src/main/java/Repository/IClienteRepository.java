/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import Model.Cliente;

/**
 *
 * @author johan
 */
public interface IClienteRepository {
    Cliente findByRut(String rut);
    void save(Cliente cliente);
}
