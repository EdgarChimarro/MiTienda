/**
 * 
 */
package com.mitienda.clientes.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mitienda.clientes.dao.IClienteDAO;
import com.mitienda.clientes.model.Cliente;
import com.mitienda.clientes.service.IClienteRepo;

import lombok.AllArgsConstructor;

/**
 * @author Edgar Chimarro
 *
 */
@Service
@AllArgsConstructor
public class ClienteDAOImpl implements IClienteDAO {

    @Autowired
    private IClienteRepo clienteRepo;

    @Override
    public List<Cliente> findAll() {
	return clienteRepo.findAll();
    }

    @Override
    public Cliente findByEmail(String email) {
	return clienteRepo.findByEmail(email);
    }

    @Override
    public Cliente save(Cliente cliente) {
	return clienteRepo.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
	clienteRepo.deleteById(id);
    }

}
