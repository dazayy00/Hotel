/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.*;
import java.util.*;

/**
 *
 * @author johan
 */
public class ClienteRepositoryImpl implements IClienteRepository{
    private Map<String, Cliente> clientesHabituales = new HashMap<>();

    public ClienteRepositoryImpl() {
        clientesHabituales.put("1-1", new Habitual("1-1", "Ana gomex"));
    }
    
    @Override
    public Cliente findByRut(String rut){
        if(clientesHabituales.containsKey(rut)){
            return clientesHabituales.get(rut);
        }
        
        return new Esporadico(rut, "Cliente Nuevo");
    }
    
    @Override
    public void save(Cliente cliente){
        if(cliente instanceof Habitual){
            clientesHabituales.put(cliente.getRut(), cliente);
        }
    }
}
