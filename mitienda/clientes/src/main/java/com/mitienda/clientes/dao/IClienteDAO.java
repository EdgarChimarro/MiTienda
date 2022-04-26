/**
 * 
 */
package com.mitienda.clientes.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitienda.clientes.modell.Cliente;

/**
 * @author Edgar Chimarro
 *
 */
public interface IClienteDAO {

    public Page<Cliente> findAll(Pageable pageable);

    public Cliente findByEmail(String email);

    public Cliente save(Cliente cliente);

    public void deleteById(Long id);

}
