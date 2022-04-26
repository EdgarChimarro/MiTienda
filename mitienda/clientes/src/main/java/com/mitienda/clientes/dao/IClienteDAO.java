/**
 * 
 */
package com.mitienda.clientes.dao;

import java.util.List;

import com.mitienda.clientes.model.Cliente;

/**
 * @author Edgar Chimarro
 *
 */
public interface IClienteDAO {

    public List<Cliente> findAll();

    public Cliente findByEmail(String email);

    public Cliente save(Cliente cliente);

    public void deleteById(Long id);

}
