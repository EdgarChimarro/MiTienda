/**
 * 
 */
package com.mitienda.clientes.controller;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
=======
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> aadd7e38a4ba73689f1620d3bf7ddc1286c13749

import com.mitienda.clientes.dao.IClienteDAO;
import com.mitienda.clientes.model.Cliente;

import lombok.RequiredArgsConstructor;

/**
 * @author Edgar Chimarro
 *
 */
@Controller
@RequiredArgsConstructor
<<<<<<< HEAD
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST })

public class ClienteController {
    
    private static final String ATRIBUTO_CLIENTES = "clientes";
=======
public class ClienteController {
>>>>>>> aadd7e38a4ba73689f1620d3bf7ddc1286c13749

    @Autowired
    private IClienteDAO clienteDao;

    @GetMapping
    public String inicio(Model model, @PageableDefault(size = 3) Pageable pageable) {
<<<<<<< HEAD
	Page<Cliente> clientes = clienteDao.findAll(pageable);
	model.addAttribute(ATRIBUTO_CLIENTES, clientes);
=======
	List<Cliente> clientes = clienteDao.findAll();
	System.out.println("clientes:" + clientes.toString());
	model.addAttribute("clientes", clientes);
>>>>>>> aadd7e38a4ba73689f1620d3bf7ddc1286c13749
	return "index";
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Model model) {
<<<<<<< HEAD
	model.addAttribute(ATRIBUTO_CLIENTES, new Cliente());
	return "form";
    }

    @PostMapping("/guardar")
    public String crear(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date, Cliente cliente) {
=======
	model.addAttribute("clientes", new Cliente());
	return "form";
    }

    @PostMapping("/nuevo")
    public String crear(Cliente cliente) {
>>>>>>> aadd7e38a4ba73689f1620d3bf7ddc1286c13749
	clienteDao.save(cliente);
	return "redirect:/";
    }

<<<<<<< HEAD
    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Long id) {
	Optional<Cliente> clientes = clienteDao.findById(id);
	model.addAttribute(ATRIBUTO_CLIENTES, clientes);
	return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Model model, @PathVariable Long id) {
	clienteDao.deleteById(id);
	return "redirect:/";
    }

=======
>>>>>>> aadd7e38a4ba73689f1620d3bf7ddc1286c13749
}
