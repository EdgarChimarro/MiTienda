/**
 * 
 */
package com.mitienda.clientes.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mitienda.clientes.model.Cliente;

/**
 * @author Edgar Chimarro
 *
 */
public interface IClienteDAO {

    public Page<Cliente> findAll(Pageable pageable);

    public Cliente findByEmail(String email);
    
    public Optional<Cliente> findById(Long id);

    public Cliente save(Cliente cliente);

    public void deleteById(Long id);

}
