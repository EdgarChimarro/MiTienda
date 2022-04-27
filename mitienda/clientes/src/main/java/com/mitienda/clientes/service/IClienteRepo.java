/**
 * 
 */
package com.mitienda.clientes.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitienda.clientes.model.Cliente;

/**
 * @author Edgar Chimarro
 *
 */
@Repository
public interface IClienteRepo extends JpaRepository<Cliente, Long> {

    public Cliente findByEmail(String email);

}
