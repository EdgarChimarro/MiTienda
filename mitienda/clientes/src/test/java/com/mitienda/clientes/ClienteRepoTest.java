/**
 * 
 */
package com.mitienda.clientes;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.mitienda.clientes.model.Cliente;
import com.mitienda.clientes.service.IClienteRepo;

import junit.framework.Assert;

/**
 * @author Edgar Chimarro
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ClienteRepoTest {

    @Autowired
    private IClienteRepo clienteRepo;
    @Autowired
    private TestEntityManager entityManager;

    /**
     * Test method for
     * {@link com.mitienda.clientes.impl.ClienteDAOImpl#findAll(org.springframework.data.domain.Pageable)}.
     */
    @Test
    public void testFindAll() {
	List<Cliente> listaClientes = clienteRepo.findAll();

	assertNotNull(listaClientes);
    }

    /**
     * Test method for
     * {@link com.mitienda.clientes.impl.ClienteDAOImpl#findById(java.lang.Long)}.
     */
    @Test
    public void testFindByEmail() {

	String email = "edgarchimarro@gmail.com";
	Cliente clienteExistente = new Cliente();

	clienteExistente = clienteRepo.findByEmail(email);

	assertNotNull(clienteExistente);

    }

    /**
     * Test method for
     * {@link com.mitienda.clientes.impl.ClienteDAOImpl#save(com.mitienda.clientes.model.Cliente)}.
     */
    @Test
    public void testSave() {

	Cliente nuevoCliente = new Cliente();
	nuevoCliente.setNombres("Edgar I");
	nuevoCliente.setApellidos("Chimarro");
	nuevoCliente.setFechaNacimiento(LocalDate.now());
	nuevoCliente.setEmail("edgarchimarro@gmail.com");
	nuevoCliente.setGenero("Masculino");
	nuevoCliente.setNumeroTelefono("22366304");

	/* Guardar nuevo cliente */

	clienteRepo.save(nuevoCliente);

	// Recuperar registro insertado
	Cliente clienteExistente = entityManager.find(Cliente.class, nuevoCliente.getId());
	assertEquals(nuevoCliente.getEmail(), clienteExistente.getEmail());

    }

    /**
     * Test method for
     * {@link com.mitienda.clientes.impl.ClienteDAOImpl#deleteById(java.lang.Long)}.
     */
    @Test
    public void testDeleteById() {

	String email = "edgarchimarro@gmail.com";

	Cliente clienteExistente = clienteRepo.findByEmail(email);
	clienteRepo.deleteById(clienteExistente.getId());

	List<Cliente> listaClientes = clienteRepo.findAll();

	if (!listaClientes.isEmpty()) {
	    Assert.fail();
	}

    }

}
